package br.com.erudio.integrationtests.repositories;

import br.com.erudio.integrationtests.testcontainers.AbstractIntegrationTest;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonRepositoryTest extends AbstractIntegrationTest {

    @Autowired
    public PersonRepository personRepository;

    private static Person person;

    @BeforeAll
    public static void setup() {
        person = new Person();
    }

    @Test
    @Order(0)
    public void testFindByName() throws JsonProcessingException {

        Pageable pageable = PageRequest.of(0,6, Sort.by(Sort.Direction.ASC, "firstName"));
        person = personRepository.findPersonsByName("Ayr", pageable).getContent().get(0);

        assertNotNull(person.getId());
        assertNotNull(person.getFirstName());
        assertNotNull(person.getLastName());
        assertNotNull(person.getAddress());
        assertNotNull(person.getGender());

        assertEquals(2, person.getId());

        assertEquals("Ayrton", person.getFirstName());
        assertEquals("Senna", person.getLastName());
        assertEquals("São Paulo - Brasil", person.getAddress());
        assertEquals("Male", person.getGender());
        assertTrue(person.getEnabled());
    }

    @Test
    @Order(1)
    public void testDisabledPerson() throws JsonProcessingException {

        personRepository.disabledPerson(2L);
        Pageable pageable = PageRequest.of(0,6, Sort.by(Sort.Direction.ASC, "firstName"));
        person = personRepository.findPersonsByName("Ayr", pageable).getContent().get(0);

        assertNotNull(person.getId());
        assertNotNull(person.getFirstName());
        assertNotNull(person.getLastName());
        assertNotNull(person.getAddress());
        assertNotNull(person.getGender());

        assertEquals(2, person.getId());

        assertEquals("Ayrton", person.getFirstName());
        assertEquals("Senna", person.getLastName());
        assertEquals("São Paulo - Brasil", person.getAddress());
        assertEquals("Male", person.getGender());
        assertFalse(person.getEnabled());
    }


}
