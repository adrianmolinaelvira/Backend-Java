package com.bosonit.formacion.ej7.crudvalidation.person.application;

import com.bosonit.formacion.ej7.crudvalidation.exceptions.UnprocessableEntityException;
import com.bosonit.formacion.ej7.crudvalidation.person.domain.Person;
import com.bosonit.formacion.ej7.crudvalidation.person.domain.PersonPage;
import com.bosonit.formacion.ej7.crudvalidation.person.domain.PersonSearchCriteria;
import com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller.output.PersonOutputDto;
import com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.repository.PersonCriteriaRepository;
import com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.repository.PersonRepository;
import com.bosonit.formacion.ej7.crudvalidation.student.infrastructure.repository.StudentRepository;
import com.bosonit.formacion.ej7.crudvalidation.teacher.infrastructure.repository.TeacherRepository;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;


import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PersonServiceImpTest {

    //@Mock crea una clase falsa.
    //@InjectMocks crea una instancia de la clase y le asinga los mocks que correspondan.

    @Mock
    private PersonRepository personRepository;
    @Mock
    private PersonCriteriaRepository personCriteriaRepository;
    @Mock
    private TeacherRepository teacherRepository;
    @Mock
    private StudentRepository studentRepository;
    @InjectMocks
    private PersonService personService = new PersonServiceImp();

    Person newPerson = null;
    PersonInputDto newPersonInputDto = null;

    @BeforeEach
    void setUp(){
        newPersonInputDto = new PersonInputDto("adrimo100", "12345", "Adrián", "Molina",
                "adrian@company.com", "adrian@personal.com", "Guadalajara",
                true,new Date(), null, null);
        newPerson = newPersonInputDto.transformIntoPerson();
    }

    @Test
    void canAddPerson() throws Exception {
        //given

        //when
        PersonOutputDto personOutputDto = personService.addPerson(newPersonInputDto);

        //then
        assertThat(personOutputDto).isNotNull();
    }

    @Test
    void canNotAddPerson() throws Exception {
        //given
        newPersonInputDto.setName(null);

        //when
        assertThrows(UnprocessableEntityException.class, () -> personService.addPerson(newPersonInputDto));

        //then
        verify(personRepository, never()).save(newPerson); //Verificamos que no se llame
    }

    @Test
    void canFindPersonById() throws Exception {
        //given
        int id = 1;


        given(personRepository.findById(id)).willReturn(Optional.of(newPerson));

        //when
        personService.findPersonById(id);

        //then
        verify(personRepository).findById(id); //Verificamos que ha sido llamado
    }

    @Test
    void canFindPersonByUsername() throws Exception {
        //given
        String username = "adrimo100";


        List<Person> peopleList = new ArrayList<>();
        peopleList.add(newPerson);

        given(personRepository.findByUsername(username)).willReturn(peopleList);

        //when
        personService.findPersonByUsername(username);

        //verify
        verify(personRepository).findByUsername(username);
    }

    @Test
    void canGetAllPeople() {
        //given

        //when
        personService.getAllPeople();

        //then
        verify(personRepository).findAll(); //Verificamos si findAll() ha sido llamado.
    }

    @Test
    void canUpdatePerson() throws Exception {
        //given
        int id = 1;

        given(personRepository.findById(id)).willReturn(Optional.of(newPerson));

        newPersonInputDto.setUsuario("Jorge10");
        newPersonInputDto.setName("Jorge");
        newPersonInputDto.setCity("Cuenca");

        Person updatedPerson = newPersonInputDto.transformIntoPerson();

        PersonOutputDto personOutputDtoExpected = new PersonOutputDto(updatedPerson);

        //When
        PersonOutputDto returnerPersonOutputDto = personService.updatePerson(id, newPersonInputDto);

        //Then
        assertThat(returnerPersonOutputDto.getUsuario()).isEqualTo(personOutputDtoExpected.getUsuario());
        assertThat(returnerPersonOutputDto.getName()).isEqualTo(personOutputDtoExpected.getName());
        assertThat(returnerPersonOutputDto.getCity()).isEqualTo(personOutputDtoExpected.getCity());
        assertThat(returnerPersonOutputDto.getPersonal_email()).isEqualTo(personOutputDtoExpected.getPersonal_email());
        assertThat(returnerPersonOutputDto.getCompany_email()).isEqualTo(personOutputDtoExpected.getCompany_email());
        assertThat(returnerPersonOutputDto.getCreated_date()).isEqualTo(personOutputDtoExpected.getCreated_date());
        assertThat(returnerPersonOutputDto.getSurname()).isEqualTo(personOutputDtoExpected.getSurname());
        assertThat(returnerPersonOutputDto.getTermination_date()).isEqualTo(personOutputDtoExpected.getTermination_date());
    }

    @Test
    void canNotUpdate(){
        //given
        int id = 1;

        given(personRepository.findById(id)).willReturn(Optional.of(newPerson));

        newPersonInputDto.setUsuario("Jorge10");
        newPersonInputDto.setName(null);
        newPersonInputDto.setCity("Cuenca");

        //when
        assertThrows(UnprocessableEntityException.class, () -> personService.updatePerson(id, newPersonInputDto));

        //then
        verify(personRepository, never()).save(newPersonInputDto.transformIntoPerson());
    }

    @Test
    void canDeletePerson() throws Exception {
        //given
        int id = 1;

        given(personRepository.findById(id)).willReturn(Optional.of(newPerson));
        willDoNothing().given(personRepository).delete(newPerson);

        //When
        personService.deletePerson(id);

        //Then
        verify(personRepository, times(1)).delete(newPerson); //Verificar que solo se ha llamado una vez
    }

    @Test
    void canGetPersonOptional() {
        //given
        PersonInputDto newPersonInputDto = new PersonInputDto("adrimo100", "12345", "Adrián", "Molina",
                "adrian@company.com", "adrian@personal.com", "Guadalajara",
                true,new Date(), null, null);
        Person newPerson = newPersonInputDto.transformIntoPerson();

        //when
        personService.getPersonOptional(1);

        //then
        verify(personRepository).findById(1);
    }

    @Test
    void canGetData() {
        //given
        Date actualDate = new Date();

        PersonPage personPage = new PersonPage(0, "username");
        PersonSearchCriteria personSearchCriteria = new PersonSearchCriteria("adrimo100",
                "Adrián", "Molina",  actualDate, "prev");

        Sort sort = Sort.by(personPage.getSortDirection(), personPage.getSortBy());
        Pageable pageable = PageRequest.of(personPage.getPageNumber(), personPage.getPageSize(), sort);

        List<Person> personList = new ArrayList<>();
        personList.add(newPerson);

        given(personCriteriaRepository.findAllWithFilters(personPage, personSearchCriteria)).willReturn(new PageImpl<>(
                personList, pageable, 1
        ));

        List<PersonOutputDto> personOutputDtoList = personList.stream().map(PersonOutputDto::new).collect(Collectors.toList());
        Page<PersonOutputDto> expectedPersonOutputDtoPage = new PageImpl<>(personOutputDtoList, pageable, 1);

        //when
        Page<PersonOutputDto> returnedPersonOutputDtoPage = personService.getData(personPage, personSearchCriteria);

        //then
        assertThat(returnedPersonOutputDtoPage.getContent()).isEqualTo(expectedPersonOutputDtoPage.getContent());
    }
}