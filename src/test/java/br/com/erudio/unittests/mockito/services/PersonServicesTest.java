package br.com.erudio.unittests.mockito.services;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.exceptions.RequiredObjectIsNullException;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;
import br.com.erudio.services.PersonServices;
import br.com.erudio.unittests.mapper.mocks.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class PersonServicesTest {

    MockPerson input;

    @InjectMocks
    private PersonServices personServices;

    @Mock
    PersonRepository personRepository;

    @BeforeEach
    void setUpMocks() {
        input = new MockPerson();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() {
        Person entity = input.mockEntity(1);
        entity.setId(1L);
        when(personRepository.findById(1L)).thenReturn(Optional.of(entity));

        var result = personServices.findById(1L);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));

        assertEquals("Addres Test1", result.getAddress());
        assertEquals("Female", result.getGender());
        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());

    }

//    @Test
//    void testFindAll() {
//        List<Person> list = input.mockEntityList();
//
//        when(personRepository.findAll()).thenReturn(list);
//
//        var people = personServices.findAll(pageable);
//
//        assertNotNull(people);
//        assertEquals(14, people.size());
//
//        var personOne = people.get(1);
//
//        assertNotNull(personOne);
//        assertNotNull(personOne.getKey());
//        assertNotNull(personOne.getLinks());
//
//        assertTrue(personOne.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));
//
//        assertEquals("Addres Test1", personOne.getAddress());
//        assertEquals("Female", personOne.getGender());
//        assertEquals("First Name Test1", personOne.getFirstName());
//        assertEquals("Last Name Test1", personOne.getLastName());
//
//        var personFour = people.get(4);
//
//        assertNotNull(personFour);
//        assertNotNull(personFour.getKey());
//        assertNotNull(personFour.getLinks());
//
//        assertTrue(personFour.toString().contains("links: [</api/person/v1/4>;rel=\"self\"]"));
//
//        assertEquals("Addres Test4", personFour.getAddress());
//        assertEquals("Male", personFour.getGender());
//        assertEquals("First Name Test4", personFour.getFirstName());
//        assertEquals("Last Name Test4", personFour.getLastName());
//
//        var personSeven = people.get(7);
//
//        assertNotNull(personSeven);
//        assertNotNull(personSeven.getKey());
//        assertNotNull(personSeven.getLinks());
//
//        assertTrue(personSeven.toString().contains("links: [</api/person/v1/7>;rel=\"self\"]"));
//
//        assertEquals("Addres Test7", personSeven.getAddress());
//        assertEquals("Female", personSeven.getGender());
//        assertEquals("First Name Test7", personSeven.getFirstName());
//        assertEquals("Last Name Test7", personSeven.getLastName());
//    }

    @Test
    void testCreate() {
        Person entity = input.mockEntity(1);

        Person persisted = entity;
        persisted.setId(1L);

        PersonVO vo = input.mockVO(1);
        vo.setKey(1L);

        when(personRepository.save(entity)).thenReturn(persisted);

        var result = personServices.create(vo);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));

        assertEquals("Addres Test1", result.getAddress());
        assertEquals("Female", result.getGender());
        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
    }

    @Test
    void testCreateWithNullPerson() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            personServices.create(null);
        });

        String expectedMessage = "It is not allowed to persist a null object!";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testUpdate() {
        Person entity = input.mockEntity(1);

        Person persisted = entity;
        persisted.setId(1L);

        PersonVO vo = input.mockVO(1);
        vo.setKey(1L);

        when(personRepository.findById(1L)).thenReturn(Optional.of(entity));
        when(personRepository.save(entity)).thenReturn(persisted);

        var result = personServices.update(vo);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/person/v1/1>;rel=\"self\"]"));

        assertEquals("Addres Test1", result.getAddress());
        assertEquals("Female", result.getGender());
        assertEquals("First Name Test1", result.getFirstName());
        assertEquals("Last Name Test1", result.getLastName());
    }

    @Test
    void testUpdateWithNullPerson() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            personServices.update(null);
        });

        String expectedMessage = "It is not allowed to persist a null object!";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testDelete() {
        Person entity = input.mockEntity(1);
        entity.setId(1L);
        when(personRepository.findById(1L)).thenReturn(Optional.of(entity));

        personServices.delete(1L);
    }
}