package com.adrian.springboot_jpa;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.adrian.springboot_jpa.entities.Person;
import com.adrian.springboot_jpa.repositories.PersonRepository;

@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner{

	@Autowired
	private PersonRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		personalizedQueries();
		//delete2();
	//update();
	//create();
	//list();
	//findOne();
	}

	@Transactional(readOnly = true)
	public void personalizedQueries(){

		Scanner scanner = new Scanner(System.in);
		System.out.println("==============CONSULTA SOLO EL NOMBRE POR EL ID================");
		System.out.println("Ingrese el id:");
		Long id = scanner.nextLong();
		String name = repository.getNameById(id);
		String fullName = repository.getFullNameById(id);
		System.out.println(fullName);

		System.out.println("Consulta por campos personalizado");
		Object[] personReg = (Object[]) repository.obtenerPersonDataFullById(id);
		System.out.println("Id: " + personReg[0] + " Nombre: " + personReg[1] + " LastName: " + personReg[2] + " Lenguaje: " + personReg[3]);

		System.out.println("Consulta por campos personalizado LISTA");
		List<Object[]> persons = repository.obtenerPersonDataFullList();
		persons.stream().forEach(person -> {
			System.out.println("Id: " + person[0] + " Nombre: " + person[1] + " LastName: " + person[2] + " Lenguaje: " + person[3]);
		});

		scanner.close();
	}


	@Transactional
	public void delete2(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el id a eliminar");
		Long id = scanner.nextLong();

		Optional<Person> optionalPerson = repository.findById(id);
		optionalPerson.ifPresentOrElse(person -> repository.delete(person), () -> System.out.println("No existe la persona con ese id: " + id));
		// o (repository::delete , () -> )
		list();

	}


	@Transactional
	public void delete(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el id a eliminar");
		Long id = scanner.nextLong();
		repository.deleteById(id);
		list();

	}


	@Transactional
	public void update(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el id de la persona");
		Long id = scanner.nextLong();

		Optional<Person> optionalPerson = repository.findById(id);

		optionalPerson.ifPresentOrElse(person -> {
			System.out.println("Ingrese el lenguaje de programación:");
			String programmingLanguage = scanner.next();
			person.setProgrammingLanguage(programmingLanguage);
			Person personDb = repository.save(person);
			System.out.println(personDb);
		}, () -> {
			System.out.println("La persona con el id ingresado no existe.");
		});
	}


	@Transactional
	public void create(){

		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		String lastname = scanner.nextLine();
		String programmingLanguage = scanner.nextLine();
		scanner.close();

		Person person = new Person(null, name, lastname, programmingLanguage);

		Person newPerson = repository.save(person);
		System.out.println(newPerson);


		repository.findById(newPerson.getId()).ifPresent(System.out::println);

	}


	@Transactional(readOnly = true)
	public void findOne(){
		/*Person person = null;
		Optional<Person> optionalPerson = repository.findById(9L);
		if(optionalPerson.isPresent()){
			person = optionalPerson.get();
			System.out.println(person);
		}else{
			System.out.println("El usuario con id no existe.");
		}*/

		//repository.findById(1L).ifPresent(System.out::println);
		
		//repository.findOneLikeName("Adr").ifPresent(System.out::println);

		repository.findByName("Adrian").ifPresent(System.out::println);

	}

	@Transactional(readOnly = true)
	public void list(){
	List<Person> persons = (List<Person>) repository.findAll();
		//List<Person> persons = (List<Person>) repository.findByProgrammingLanguage("Java");
		//List<Person> persons = (List<Person>) repository.buscarByProgrammingLanguage("Java", "Adrian");
		//List<Person> persons = (List<Person>) repository.findByProgrammingLanguageAndName("Java", "Adrian");

		persons.stream().forEach(person -> System.out.println(person));


		List<Object[]> personsValues = repository.obtenerPersonDataByProgrammingLanguage("Java");
		personsValues.stream().forEach(person -> {
			System.out.println(person[0] + " es experto en " + person[1]);
			System.out.println(person);
		});
	}


}
