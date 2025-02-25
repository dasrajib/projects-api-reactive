package com.adu.api.repository;

import com.adu.api.model.Address;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AddressRepository extends ReactiveCrudRepository<Address, Long> {

    Flux<Address> findByCity(String city);    
}
