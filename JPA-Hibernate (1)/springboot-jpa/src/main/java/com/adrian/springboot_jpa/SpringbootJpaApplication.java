package com.adrian.springboot_jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		//List<Person> persons = (List<Person>) repository.findAll();
		//List<Person> persons = (List<Person>) repository.findByProgrammingLanguage("Java");
		//List<Person> persons = (List<Person>) repository.buscarByProgrammingLanguage("Java", "Adrian");
		List<Person> persons = (List<Person>) repository.findByProgrammingLanguageAndName("Java", "Adrian");

		persons.stream().forEach(person -> System.out.println(person));


		List<Object[]> personsValues = repository.obtenerPersonDataByProgrammingLanguage("Java");
		personsValues.stream().forEach(person -> {
			System.out.println(person[0] + " es experto en " + person[1]);
			System.out.println(person);
		});
	}


}
