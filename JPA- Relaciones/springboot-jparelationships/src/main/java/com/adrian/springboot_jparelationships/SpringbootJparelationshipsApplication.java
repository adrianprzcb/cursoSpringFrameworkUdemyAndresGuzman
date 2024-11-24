package com.adrian.springboot_jparelationships;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.adrian.springboot_jparelationships.entities.Address;
import com.adrian.springboot_jparelationships.entities.Client;
import com.adrian.springboot_jparelationships.entities.ClientDetails;
import com.adrian.springboot_jparelationships.entities.Invoice;
import com.adrian.springboot_jparelationships.repositories.ClientDetailsRepository;
import com.adrian.springboot_jparelationships.repositories.ClientRepository;
import com.adrian.springboot_jparelationships.repositories.InvoiceRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class SpringbootJparelationshipsApplication implements CommandLineRunner{

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ClientDetailsRepository ClientDetailsRepository;


	public static void main(String[] args) {
		SpringApplication.run(SpringbootJparelationshipsApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		OneToOneFindById();
		
	}


	@Transactional
	public void OneToOneFindById() {

		ClientDetails clientDetails = new ClientDetails(true, 1000);
		ClientDetailsRepository.save(clientDetails);


		Optional<Client> optionalClient = clientRepository.findOne(2L);
		optionalClient.ifPresent(client ->{
			client.setClientDetails(clientDetails);
			clientRepository.save(client);
			System.out.println("Client saved: " + client);
		});

	

	}


	@Transactional
	public void OneToOne() {

		ClientDetails clientDetails = new ClientDetails(true, 1000);
		ClientDetailsRepository.save(clientDetails);


		Client client = new Client("Erba", "Pura");
		client.setClientDetails(clientDetails);
		clientRepository.save(client);

		System.out.println("Client saved: " + client);
	

	}

	@Transactional
	private void removeBidireccionalFindById() {

		Optional<Client> optionalClient = clientRepository.findOne(1L);

		optionalClient.ifPresent(client ->{
			Invoice invoice = new Invoice("Compras de casa", 5000L);
			Invoice invoice2 = new Invoice("Compras de oficina", 8000L);
	
			client.addInvoice(invoice).addInvoice(invoice2);
	
	
			clientRepository.save(client);
	
			System.out.println("Client saved: " + client);
		});
		Optional<Client> optionalClientDb= clientRepository.findOne(1L);
		optionalClientDb.ifPresent(client -> {
			Optional<Invoice> optionalInvoice = invoiceRepository.findById(2L);
			optionalInvoice.ifPresent(invoice -> {
				client.removeInvoice(invoice);
				clientRepository.save(client);
				System.out.println("Client saved: " + client);
			});
		});

	}

	@Transactional
	private void OneToManyInvoiceBidireccionalFindById() {

		Optional<Client> optionalClient = clientRepository.findOne(1L);

		optionalClient.ifPresent(client ->{
			Invoice invoice = new Invoice("Compras de casa", 5000L);
			Invoice invoice2 = new Invoice("Compras de oficina", 8000L);
	
			client.addInvoice(invoice).addInvoice(invoice2);
	
	
			clientRepository.save(client);
	
			System.out.println("Client saved: " + client);
		});

	}


	@Transactional
	private void OneToManyInvoiceBidireccional() {
		Client client = new Client("Fran", "Moras");
		Invoice invoice = new Invoice("Compras de casa", 5000L);
		Invoice invoice2 = new Invoice("Compras de oficina", 8000L);

		client.addInvoice(invoice).addInvoice(invoice2);


		clientRepository.save(client);

		System.out.println("Client saved: " + client);

	}


	@Transactional
	private void removeAdressFindById() {
		Optional<Client> optionalClient = clientRepository.findById(2L);
		optionalClient.ifPresent(client -> {
			Address adress = new Address("El verjel" , 1234);
			Address adress2 = new Address("Vasco de Gama" , 13);

			Set<Address> addresses = new HashSet<>();
			addresses.add(adress);
			addresses.add(adress2);
			client.setAddresses(addresses);

			clientRepository.save(client);
			System.out.println(client);


			Optional<Client> optionalClient2 = clientRepository.findOneWithAddresses(2L);
			optionalClient2.ifPresent(c ->
			{
				c.getAddresses().remove(adress2);
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

		client.getAddresses().add(adress);
		client.getAddresses().add(adress2);
		clientRepository.save(client);
		System.out.println("Client saved: " + client);


		Optional<Client> optionalClient = clientRepository.findById(4L);
		optionalClient.ifPresent(c ->
		{
			c.getAddresses().remove(adress);
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

			Set<Address> addresses = new HashSet<>();
			addresses.add(adress);
			addresses.add(adress2);
			client.setAddresses(addresses);

			clientRepository.save(client);
			System.out.println(client);
		});
	}


	@Transactional
	private void OneToMany() {
		Client client = new Client("Fran", "Moras");
		Address adress = new Address("Calle 1", 123);
		Address adress2 = new Address("Calle 2", 456);

		client.getAddresses().add(adress);
		client.getAddresses().add(adress2);
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
