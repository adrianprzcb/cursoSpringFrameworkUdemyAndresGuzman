package com.adrian.springboot_jparelationships.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrian.springboot_jparelationships.entities.ClientDetails;

@Repository
public interface ClientDetailsRepository extends CrudRepository<ClientDetails, Long> {

}
