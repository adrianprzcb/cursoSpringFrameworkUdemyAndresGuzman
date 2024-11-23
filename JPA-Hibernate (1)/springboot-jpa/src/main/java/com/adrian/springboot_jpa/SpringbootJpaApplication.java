package com.adrian.springboot_jpa;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.adrian.springboot_jpa.dto.PersonDto;
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
		//subQueries();
		//QueriesFunctionAggregations();
		//personalizedQueriesBetween();
		//personalizedQueriesConcatUpperAndLowerCase();
		//personalizedQueriesDistinct();
		//personalizedQueries2();
		//personalizedQueries();
		//delete2();
	update();
	//create();
	//list();
	//findOne();
	}

	@Transactional(readOnly = true)
	public void subQueries(){
		
		System.out.println("=====Consulta de nombres más cortos");
		List<Object[]> personsShorterName = repository.getShorterName();
		personsShorterName.forEach(person -> {
			System.out.println("Nombre: " + person[0] + ", Longitud: " + person[1]);
		});


		System.out.println("=====Consulta de última persona registrada");
		Optional<Person> lastPerson = repository.getLastRegistration();
		lastPerson.ifPresent(System.out::println);


		System.out.println("=====Consulta con where in");
		List<Person> persons = repository.getPersonsByIds(Arrays.asList(1L, 3L, 5L));
		persons.forEach(System.out::println);
	}

	@Transactional(readOnly = true)
	public void QueriesFunctionAggregations(){

		System.out.println("Total de personas: " + repository.totalPerson());
		System.out.println("Id mínimo: " + repository.minId());
		System.out.println("Id máximo: " + repository.maxId());

		System.out.println("=====Consulta de nombres y longitud de nombres");
		List<Object[]> personsNameLength = repository.getPersonNameLength();
		personsNameLength.forEach(person -> {
			System.out.println("Nombre: " + person[0] + ", Longitud: " + person[1]);
		});

		System.out.println("Longitud mínima de nombres: " + repository.getMinLengthName());
		System.out.println("Longitud máxima de nombres: " + repository.getMaxLengthName());


		System.out.println("=====Consulta de resumen de funciones de agregación");
		Object[] resume = (Object[]) repository.getResumeAggregationFunction();
		System.out.println("Id mínimo: " + resume[0]);
		System.out.println("Id máximo: " + resume[1]);
		System.out.println("Suma de ids: " + resume[2]);
		System.out.println("Promedio de longitud de nombres: " + resume[3]);
		System.out.println("Total de personas: " + resume[4]);


	}

	@Transactional(readOnly = true)
	public void personalizedQueriesBetween(){

		System.out.println("=====Consulta entre id 2 y 5");
		List<Person> persons = repository.findAllBetweenId(2, 5);
		persons.forEach(System.out::println);

		System.out.println("=====Consulta entre nombre A y H");
		List<Person> personsName = repository.findAllBetweenName("A" , "E");
		personsName.forEach(System.out::println);

		System.out.println("=====Consulta entre id 2 y 5");
		List<Person> personsId = repository.findByIdBetweenOrderByIdDesc(2L, 5L);
		personsId.forEach(System.out::println);

		System.out.println("=====Consulta entre nombre A y H");
		List<Person> personsNameBetween = repository.findByNameBetweenOrderByNameDescLastnameAsc("A" , "E");
		personsNameBetween.forEach(System.out::println);



		System.out.println("=====Consulta all ordered");
		List<Person> personsOrder = repository.getAllOrdered();
		personsOrder.forEach(System.out::println);

		System.out.println("=== consulta order y desc y asc");
		//findAllByOrderByNameAscLastnameDesc
		List<Person> personsOrderDesc = repository.findAllByOrderByNameAscLastnameDesc();
		personsOrderDesc.forEach(System.out::println);

	}


	@Transactional(readOnly = true)
	public void personalizedQueriesConcatUpperAndLowerCase(){

		System.out.println("=====Consulta nombres y apellidos");
		List<String> fullNames = repository.findAllFullNameConcat();
		fullNames.forEach(System.out::println);

		System.out.println("=====Consulta nombres y apellidos en mayúsculas");
		List<String> fullNamesUpper = repository.findAllFullNameConcatUpper();
		fullNamesUpper.forEach(System.out::println);

		System.out.println("=====Consulta nombres y apellidos en minúsculas");
		List<String> fullNamesLower = repository.findAllFullNameConcatLower();
		fullNamesLower.forEach(System.out::println);

		System.out.println("=====Consulta nombres y apellidos en mayúsculas y minúsculas");
		List<Object[]> personsData = repository.findAllPersonDataListCase();
		personsData.forEach(person -> {
			System.out.println("Id: " + person[0] + ", Nombre: " + person[1] + ", Apellido: " + person[2] + ", Lenguaje: " + person[3]);
		});
	}


	@Transactional(readOnly = true)
	public void personalizedQueriesDistinct(){

		System.out.println("===========Consulta con nombres de personas");

		List<String> names = repository.findAllNames();
		names.forEach(System.out::println);

		System.out.println("===========Consulta con nombres de personas distintos");
		List<String> namesDistinct = repository.findAllNamesDistinct();
		namesDistinct.forEach(System.out::println);

		System.out.println("======Consulta lenguajes de programación distintos======");
		List<String> programmingLanguages = repository.findAllProgrammingLanguagesDistinct();
		programmingLanguages.forEach(System.out::println);
		System.out.println("Total lenguajes de programación distintos: " + repository.findAllProgrammingLanguagesDistinctCount());
	}

	
	@Transactional(readOnly = true)
	public void personalizedQueries2(){

		System.out.println("==============Consulta por persona y lenguaje de programación================");
		List<Object[]> personsRegs = repository.findAllMixPerson();
		personsRegs.forEach(reg ->{
			System.out.println("programmingLanguage= " + reg[1] + ", person= " + reg[0]);


			System.out.println("==============Consulta instancia personalizada================");

			List<Person> persons = repository.findAllObjectPersonPersonalized();
			persons.forEach(System.out::println);


	
		});


		System.out.println("==============DTO DTO DTOConsulta por persona y lenguaje de programación================");
		List<PersonDto> personsDto = repository.findAllObjectPersonDto();
		personsDto.forEach(System.out::println);	
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
