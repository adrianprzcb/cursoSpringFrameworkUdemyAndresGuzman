package com.adrian.springboot_jparelationships.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrian.springboot_jparelationships.entities.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

    
    @Query("select c from Client c left join fetch c.addresses where c.id = ?1")
    Optional<Client> findOneWithAddresses(Long id);

    @Query("select c from Client c left join fetch c.invoices where c.id = ?1")
    Optional<Client> findOneWithInvoice(Long id);
     

    @Query("select c from Client c left join fetch c.invoices left join fetch c.addresses left join fetch c.clientDetails where c.id = ?1")
    Optional<Client> findOne(Long id);
} 