package com.adrian.springboot_jparelationships.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adrian.springboot_jparelationships.entities.Invoice;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

}
