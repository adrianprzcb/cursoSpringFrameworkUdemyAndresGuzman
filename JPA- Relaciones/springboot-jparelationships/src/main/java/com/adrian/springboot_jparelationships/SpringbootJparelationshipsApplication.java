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
import com.adrian.springboot_jparelationships.entities.Course;
import com.adrian.springboot_jparelationships.entities.Invoice;
import com.adrian.springboot_jparelationships.entities.Student;
import com.adrian.springboot_jparelationships.repositories.ClientDetailsRepository;
import com.adrian.springboot_jparelationships.repositories.ClientRepository;
import com.adrian.springboot_jparelationships.repositories.CourseRepository;
import com.adrian.springboot_jparelationships.repositories.InvoiceRepository;
import com.adrian.springboot_jparelationships.repositories.StudentRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class SpringbootJparelationshipsApplication implements CommandLineRunner{

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ClientDetailsRepository ClientDetailsRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private CourseRepository courseRepository;


	public static void main(String[] args) {
		SpringApplication.run(SpringbootJparelationshipsApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		manyToManyRemoveFind();
		
	}

	@Transactional
	public void manyToManyRemoveFind(){
		Optional<Student> optStudent1 = studentRepository.findById(1L);
		Optional<Student> optStudent2 = studentRepository.findById(2L);

		Student student1 = optStudent1.orElseThrow();
		Student student2 = optStudent2.orElseThrow();

		Course course1 = courseRepository.findById(1L).get();
		Course course2 = courseRepository.findById(2L).get();

		student1.setCourses(Set.of(course1, course2));
		student2.setCourses(Set.of(course2));

		studentRepository.saveAll(Set.of(student1, student2));

		System.out.println("Student saved: " + student1);
		System.out.println("Student saved: " + student2);


		Optional<Student> optStudentDb = studentRepository.findOneWithCourses(1L);
		optStudentDb.ifPresent(student -> {
			Student studentDb = optStudentDb.get();
			Optional<Course> optCourse = courseRepository.findById(2L);
			if(optCourse.isPresent()){
				Course course = optCourse.get();
				studentDb.getCourses().remove(course);
				studentRepository.save(studentDb);
				System.out.println("Student saved: " + studentDb);
			}
		});
	}


	
	@Transactional
	public void manyToManyFindById(){
		Optional<Student> optStudent1 = studentRepository.findById(1L);
		Optional<Student> optStudent2 = studentRepository.findById(2L);

		Student student1 = optStudent1.orElseThrow();
		Student student2 = optStudent2.orElseThrow();

		Course course1 = courseRepository.findById(1L).get();
		Course course2 = courseRepository.findById(2L).get();

		student1.setCourses(Set.of(course1, course2));
		student2.setCourses(Set.of(course2));

		studentRepository.saveAll(Set.of(student1, student2));

		System.out.println("Student saved: " + student1);
		System.out.println("Student saved: " + student2);
	}



	@Transactional
	public void manyToMany(){
		Student student1 = new Student("Adrian", "Gonzalez");
		Student student2 = new Student("Fran", "Moras");

		Course course1 = new Course("Java", "Adrian");
		Course course2 = new Course("Spring", "Adrian");

		student1.setCourses(Set.of(course1, course2));
		student2.setCourses(Set.of(course2));

		studentRepository.saveAll(Set.of(student1, student2));

		System.out.println("Student saved: " + student1);
		System.out.println("Student saved: " + student2);
	}



	@Transactional
	public void oneToOneBidireccionalFindByid(){
		Optional<Client> optionalClient = clientRepository.findOne(2L);
		optionalClient.ifPresent(client ->{
			ClientDetails clientDetails = new ClientDetails(true, 1000);
			client.setClientDetails(clientDetails);
			clientRepository.save(client);
			System.out.println("Client saved: " + client);
		});
	}


	@Transactional
	public void OneToManyBidireccional() {

		Client client = new Client("Erba", "Pura");
		ClientDetails clientDetails = new ClientDetails(true, 1000);
		client.setClientDetails(clientDetails);
		clientDetails.setClient(client);
		clientRepository.save(client);

		System.out.println("Client saved: " + client);
	

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
