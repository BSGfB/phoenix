package com.phoenix.shop.service;

import com.phoenix.shop.model.entity.PhotoEntity;
import com.phoenix.shop.model.entity.ProductEntity;
import com.phoenix.shop.model.entity.UserEntity;
import com.phoenix.shop.model.request.ProductRequest;
import com.phoenix.shop.model.response.ProductResponse;
import com.phoenix.shop.repository.ProductRepository;
import com.phoenix.shop.repository.UserRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final Mapper mapper;

    @Autowired
    public ProductService(final Mapper mapper, final ProductRepository productRepository, final UserRepository userRepository) {
        this.mapper = mapper;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public Long save(ProductRequest productRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userRepository.findByEmail(getUserEmail()).getUserId());

        ProductEntity productEntity = mapper.map(productRequest, ProductEntity.class);
        productEntity.setUser(userEntity);
        List<PhotoEntity> photos = productRequest.getPhotos().stream()
                .map(url -> createPhotoEntityFromUrl(url, productEntity))
                .collect(Collectors.toList());

        productEntity.setPhotos(photos);
        return productRepository.save(productEntity).getProductId();
    }

    public List<ProductResponse> findAllMy() {
        Long userId = userRepository.findByEmail(getUserEmail()).getUserId();

        return productRepository.findAllByUserUserId(userId).stream()
                .map(this::mapToProductResponse)
                .collect(Collectors.toList());
    }

    private String getUserEmail() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    private PhotoEntity createPhotoEntityFromUrl(final String url, final ProductEntity productEntity) {
        PhotoEntity photoEntity = new PhotoEntity();
        photoEntity.setPhoto(url);
        photoEntity.setProduct(productEntity);
        return photoEntity;
    }

    private ProductResponse mapToProductResponse(final ProductEntity productEntity) {
        List<String> photos = productEntity.getPhotos().stream().map(v -> v.getPhoto()).collect(Collectors.toList());
        ProductResponse map = mapper.map(productEntity, ProductResponse.class);
        map.setPhotos(photos);
        return map;
    }
}


