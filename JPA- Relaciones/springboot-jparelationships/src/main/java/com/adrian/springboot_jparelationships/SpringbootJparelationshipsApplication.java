package com.adrian.springboot_jparelationships;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.adrian.springboot_jparelationships.entities.Address;
import com.adrian.springboot_jparelationships.entities.Client;
import com.adrian.springboot_jparelationships.entities.Invoice;
import com.adrian.springboot_jparelationships.repositories.ClientRepository;
import com.adrian.springboot_jparelationships.repositories.InvoiceRepository;

import jakarta.transaction.Transactional;

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
		OneToManyInvoiceBidireccional();
		
	}


	@Transactional
	private void OneToManyInvoiceBidireccional() {
		Client client = new Client("Fran", "Moras");
		Invoice invoice = new Invoice("Compras de casa", 5000L);
		Invoice invoice2 = new Invoice("Compras de oficina", 8000L);

		client.setInvoices(Arrays.asList(invoice, invoice2));

		invoice.setClient(client);
		invoice2.setClient(client);


		clientRepository.save(client);

		System.out.println("Client saved: " + client);

	}


	@Transactional
	private void removeAdressFindById() {
		Optional<Client> optionalClient = clientRepository.findById(2L);
		optionalClient.ifPresent(client -> {
			Address adress = new Address("El verjel" , 1234);
			Address adress2 = new Address("Vasco de Gama" , 13);

			client.setAdresses(Arrays.asList(adress, adress2));

			clientRepository.save(client);
			System.out.println(client);


			Optional<Client> optionalClient2 = clientRepository.findOne(2L);
			optionalClient2.ifPresent(c ->
			{
				c.getAdresses().remove(adress2);
				clientRepository.save(c);
				System.out.println(c);
			});

		});


	
	}



	@Transactional
	private void removeAdress() {
		Client client = new Client("Fran", "Moras");
		Address adress = new Address("Calle 1", 123);
		Address adress2 = new Address("Calle 2", 456);

		client.getAdresses().add(adress);
		client.getAdresses().add(adress2);
		clientRepository.save(client);
		System.out.println("Client saved: " + client);


		Optional<Client> optionalClient = clientRepository.findById(4L);
		optionalClient.ifPresent(c ->
		{
			c.getAdresses().remove(adress);
			clientRepository.save(c);
			System.out.println(c);
		});

	}


	@Transactional
	private void OneToManyFindById() {
		Optional<Client> optionalClient = clientRepository.findById(2L);
		optionalClient.ifPresent(client -> {
			Address adress = new Address("El verjel" , 1234);
			Address adress2 = new Address("Vasco de Gama" , 13);

			client.setAdresses(Arrays.asList(adress, adress2));

			clientRepository.save(client);
			System.out.println(client);
		});
	}


	@Transactional
	private void OneToMany() {
		Client client = new Client("Fran", "Moras");
		Address adress = new Address("Calle 1", 123);
		Address adress2 = new Address("Calle 2", 456);

		client.getAdresses().add(adress);
		client.getAdresses().add(adress2);
		clientRepository.save(client);
		System.out.println("Client saved: " + client);
	}

	@Transactional
	private void ManyToOne() {
		Client client = new Client("Adrian", "Gonzalez");
		clientRepository.save(client);

		Invoice invoice = new Invoice("Compras de oficina", 2000L);
		invoice.setClient(client);
		Invoice invoiceDb = invoiceRepository.save(invoice);
		System.out.println("Invoice saved: " + invoiceDb);
	}

	@Transactional
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
