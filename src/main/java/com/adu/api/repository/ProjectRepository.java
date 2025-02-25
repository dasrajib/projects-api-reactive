package com.adu.api.repository;

import com.adu.api.model.Project;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProjectRepository extends ReactiveCrudRepository<Project, Long> {

    //Flux<Project> findByName(String name);

   // Mono<Project> findByAddress(String address);
    Flux<Project> findByStatus(String status);

    
}
