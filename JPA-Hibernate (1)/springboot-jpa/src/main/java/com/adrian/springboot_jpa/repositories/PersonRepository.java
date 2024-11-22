package com.adrian.springboot_jpa.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.adrian.springboot_jpa.dto.PersonDto;
import com.adrian.springboot_jpa.entities.Person;

import java.util.List;
import java.util.Optional;


public interface PersonRepository extends CrudRepository<Person, Long> {


    @Query("select p from Person p where p.id in ?1")
    public List<Person> getPersonsByIds(List<Long> ids);

    @Query("select p.name, length(p.name) from Person p  where length(p.name) = (select min(length(p.name)) from Person p) ")
    public List<Object[]> getShorterName();

    @Query("select p from Person p where p.id=(select max(p.id) from Person p)")
    public Optional<Person> getLastRegistration();

    @Query("select min(p.id), max(p.id), sum(p.id) , avg(length(p.name)), count(p.id) from Person p")
    public Object getResumeAggregationFunction();

    @Query("select p.name, length(p.name) from Person p")
    public List<Object[]> getPersonNameLength();
    
    @Query("select min(length(p.name)) from Person p")
    public Integer getMinLengthName();

    @Query("select max(length(p.name)) from Person p")
    public Integer getMaxLengthName();
    
    @Query("select count(p) from Person p")
    Long totalPerson();

    @Query("select min(p.id) from Person p")
    Long minId();

    @Query("select max(p.id) from Person p")
    Long maxId();



    @Query("select p from Person p order by p.name , p.lastname desc")
    List<Person> getAllOrdered();

    List<Person> findAllByOrderByNameAscLastnameDesc();

    List<Person> findByIdBetweenOrderByIdDesc(Long c1, Long c2);

    List<Person> findByNameBetweenOrderByNameDescLastnameAsc(String c1, String c2);


    @Query("select p from Person p where p.name between ?1 and ?2 order by p.name")
    List<Person> findAllBetweenName(String c1, String c2);


    @Query("select p from Person p where p.id between ?1 and ?2 order by p.name desc")
    List<Person> findAllBetweenId(Integer c1, Integer c2);

    

   // @Query("select CONCAT(p.name, ' ', p.lastname) from Person p")
   @Query("select p.name || ' ' || p.lastname from Person p")
    List<String> findAllFullNameConcat();


    @Query("select p.id , upper(p.name), lower(p.lastname), p.programmingLanguage from Person p")
    List<Object[]> findAllPersonDataListCase();


    @Query("select upper(p.name || ' ' || p.lastname) from Person p")
    List<String> findAllFullNameConcatUpper();

    @Query("select lower(p.name || ' ' || p.lastname) from Person p")
    List<String> findAllFullNameConcatLower();


    @Query("select p.name from Person p")
    List<String> findAllNames();

    @Query("select distinct(p.name) from Person p")
    List<String> findAllNamesDistinct();


    @Query("select distinct(p.programmingLanguage) from Person p")
    List<String> findAllProgrammingLanguagesDistinct();

    @Query("select count(distinct(p.programmingLanguage)) from Person p")
    Long findAllProgrammingLanguagesDistinctCount();

    @Query("select new com.adrian.springboot_jpa.dto.PersonDto(p.name, p.lastname) from Person p")
    List<PersonDto> findAllObjectPersonDto();

    @Query("select new Person(p.name, p.lastname) from Person p")
    List<Person> findAllObjectPersonPersonalized();

    @Query("select p.name from Person p where p.id=?1")
    String getNameById(Long id);

    @Query("select concat(p.name, ' ', p.lastname) as fullname from Person p where p.id=?1")
    String getFullNameById(Long id);

    @Query("select p from Person p where p.id=?1")
    Optional<Person> findOne(Long id);

    @Query("select p from Person p where p.name=?1")
    Optional<Person> findOneName(String name);

    @Query("select p from Person p where p.name like %?1%")
    Optional<Person> findOneLikeName(String name);

    Optional<Person> findByName(String name);

    Optional<Person> findByNameContaining(String name);

    List<Person> findByProgrammingLanguage(String programmingLanguage);

    List<Person> findByProgrammingLanguageAndName(String programmingLanguage, String name);


    @Query("select p from Person p where p.programmingLanguage=?1 and p.name=?2")
    List<Person> buscarByProgrammingLanguage(String programmingLanguage, String name);

    @Query("select p, p.programmingLanguage from Person p")
    List<Object[]> findAllMixPerson();

    @Query("select p.name, p.programmingLanguage from Person p")
    List<Object[]> obtenerPersonData();

    @Query("select p.id, p.name, p.lastname, p.programmingLanguage from Person p")
    List<Object[]> obtenerPersonDataFullList();

    @Query("select p.id, p.name, p.lastname, p.programmingLanguage from Person p where p.id=?1")
    Object obtenerPersonDataFullById(Long id);


   @Query("select p.name, p.programmingLanguage from Person p where p.programmingLanguage=?1 and p.name=?2")
    List<Object[]> obtenerPersonData(String programmingLanguage, String name);

    @Query("select p.name, p.programmingLanguage from Person p where p.programmingLanguage=?1")
    List<Object[]> obtenerPersonDataByProgrammingLanguage(String programmingLanguage);
}
