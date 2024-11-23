package com.adrian.springboot_jparelationships;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.adrian.springboot_jparelationships.entities.Client;
import com.adrian.springboot_jparelationships.entities.Invoice;
import com.adrian.springboot_jparelationships.repositories.ClientRepository;
import com.adrian.springboot_jparelationships.repositories.InvoiceRepository;

@SpringBootApplication
public class SpringbootJparelationshipsApplication implements CommandLineRunner{

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private ClientRepository clientRepository;


	public static void main(String[] args) {
		SpringApplication.run(SpringbootJparelationshipsApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		ManyToOneFindByIdClient();
		
	}

	private void ManyToOne() {
		Client client = new Client("Adrian", "Gonzalez");
		clientRepository.save(client);

		Invoice invoice = new Invoice("Compras de oficina", 2000L);
		invoice.setClient(client);
		Invoice invoiceDb = invoiceRepository.save(invoice);
		System.out.println("Invoice saved: " + invoiceDb);
	}

	private void ManyToOneFindByIdClient() {

		Optional<Client> optionalClient = clientRepository.findById(1L);

		if(optionalClient.isPresent()){
			Client client = optionalClient.orElseThrow();

			Invoice invoice = new Invoice("Compras de oficina", 2000L);
			invoice.setClient(client);
			Invoice invoiceDb = invoiceRepository.save(invoice);
			System.out.println("Invoice saved: " + invoiceDb);
		}
		
	}

}
