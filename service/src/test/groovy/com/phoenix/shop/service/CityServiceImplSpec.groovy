package com.phoenix.shop.service

import com.phoenix.shop.configuration.ServiceTestConfiguration
import com.phoenix.shop.service.api.CityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import static java.util.Objects.nonNull

@ContextConfiguration(classes = ServiceTestConfiguration)
class CityServiceImplSpec extends Specification {

    @Autowired
    CityService cityService

    def "test findByName"() {
        when:
        def city = cityService.findByName('Pinsk').block()

        then:
        assert city.name == 'Pinsk'
    }

    def "test findById"() {
        when:
        def city = cityService.findById('5a96f1069c96ed6a10193ef6').block()

        then:
        assert city.name == 'Pinsk'
    }

    def "test findAll"() {
        when:
        def city = cityService.findAll().blockFirst()

        then:
        assert nonNull(city)
    }
}
