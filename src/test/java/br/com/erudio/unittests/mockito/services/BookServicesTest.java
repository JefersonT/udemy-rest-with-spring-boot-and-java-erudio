package br.com.erudio.unittests.mockito.services;

import br.com.erudio.data.vo.v1.BookVO;
import br.com.erudio.exceptions.RequiredObjectIsNullException;
import br.com.erudio.model.Book;
import br.com.erudio.repositories.BookRepository;
import br.com.erudio.services.BookServices;
import br.com.erudio.unittests.mapper.mocks.MockBooks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class BookServicesTest {

    MockBooks input;

    @InjectMocks
    private BookServices bookServices;

    @Mock
    BookRepository bookRepository;

    @BeforeEach
    void setUpMocks() {
        input = new MockBooks();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() {
        Book entity = input.mockEntity(1);
        entity.setId(1L);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(entity));

        var result = bookServices.findById(1L);
        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/books/v1/1>;rel=\"self\"]"));

        assertEquals("Author Test1", result.getAuthor());
        assertEquals("Title Test1", result.getTitle());
        assertNotNull(result.getLaunchDate());
        assertEquals(1D, result.getPrice());

    }

    @Test
    void testFindAll() {
        List<Book> list = input.mockEntityList();

        when(bookRepository.findAll()).thenReturn(list);

        var books = bookServices.findAll();

        assertNotNull(books);
        assertEquals(14, books.size());

        var bookOne = books.get(1);

        assertNotNull(bookOne);
        assertNotNull(bookOne.getKey());
        assertNotNull(bookOne.getLinks());

        assertTrue(bookOne.toString().contains("links: [</api/books/v1/1>;rel=\"self\"]"));

        assertEquals("Author Test1", bookOne.getAuthor());
        assertEquals("Title Test1", bookOne.getTitle());
        assertNotNull(bookOne.getLaunchDate());
        assertEquals(1D, bookOne.getPrice());

        var personFour = books.get(4);

        assertNotNull(personFour);
        assertNotNull(personFour.getKey());
        assertNotNull(personFour.getLinks());

        assertTrue(personFour.toString().contains("links: [</api/books/v1/4>;rel=\"self\"]"));

        assertEquals("Author Test4", personFour.getAuthor());
        assertEquals("Title Test4", personFour.getTitle());
        assertNotNull(personFour.getLaunchDate());
        assertEquals(4D, personFour.getPrice());

        var personSeven = books.get(7);

        assertNotNull(personSeven);
        assertNotNull(personSeven.getKey());
        assertNotNull(personSeven.getLinks());

        assertTrue(personSeven.toString().contains("links: [</api/books/v1/7>;rel=\"self\"]"));

        assertEquals("Author Test7", personSeven.getAuthor());
        assertEquals("Title Test7", personSeven.getTitle());
        assertNotNull(personSeven.getLaunchDate());
        assertEquals(7D, personSeven.getPrice());
    }

    @Test
    void testCreate() {
        Book entity = input.mockEntity(1);

        Book persisted = entity;
        persisted.setId(1L);

        BookVO vo = input.mockVO(1);
        vo.setKey(1L);

        when(bookRepository.save(entity)).thenReturn(persisted);

        var result = bookServices.create(vo);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/books/v1/1>;rel=\"self\"]"));

        assertEquals("Author Test1", result.getAuthor());
        assertEquals("Title Test1", result.getTitle());
        assertNotNull(result.getLaunchDate());
        assertEquals(1D, result.getPrice());
    }

    @Test
    void testCreateWithNullBook() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            bookServices.create(null);
        });

        String expectedMessage = "It is not allowed to persist a null object!";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testUpdate() {

        Book entity = input.mockEntity(1);

        Book persisted = entity;
        persisted.setId(1L);

        BookVO vo = input.mockVO(1);
        vo.setKey(1L);

        when(bookRepository.findById(1L)).thenReturn(Optional.of(entity));
        when(bookRepository.save(entity)).thenReturn(persisted);

        var result = bookServices.update(vo);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</api/books/v1/1>;rel=\"self\"]"));

        assertEquals("Author Test1", result.getAuthor());
        assertEquals("Title Test1", result.getTitle());
        assertNotNull(result.getLaunchDate());
        assertEquals(1D, result.getPrice());
    }

    @Test
    void testUpdateWithNullBook() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            bookServices.update(null);
        });

        String expectedMessage = "It is not allowed to persist a null object!";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testDelete() {
        Book entity = input.mockEntity(1);
        entity.setId(1L);
        when(bookRepository.findById(1L)).thenReturn(Optional.of(entity));

        bookServices.delete(1L);
    }
}