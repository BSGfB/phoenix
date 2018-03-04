package com.phoenix.shop.repository;

import com.phoenix.shop.model.Location;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface LocationRepository extends ReactiveCrudRepository<Location, String> {
}
