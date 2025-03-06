package com.tecnologiaefinancas.library;

import com.tecnologiaefinancas.library.controller.BookController;
import com.tecnologiaefinancas.library.entity.Book;
import com.tecnologiaefinancas.library.repository.BookRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookController bookController;

    private Book book;


    @BeforeEach
    void setup(){
        book = new Book("The Hobbit", "J.R.R Tolkien");
        book.setBookId(1L);
    }

    @Test
    void testGetAllBooks() {
        Pageable pageable = PageRequest.of(0,10);
        List<Book> books = Arrays.asList(book);
        Page<Book> bookPage = new PageImpl<>(books);

        when(bookRepository.findAll(pageable)).thenReturn(bookPage);

        ResponseEntity<Page<Book>> response = bookController.getAllBooks(0,10);

        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().getTotalElements());
        verify(bookRepository, times(1)).findAll(pageable);
    }

    @Test
    void testGetBookByIdFound() {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        ResponseEntity<Book> response = bookController.getBookById(1L);

        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getBookId());
        verify(bookRepository, times(1)).findById(1L);
    }

    @Test
    void testGetBookByIdNotFound() {
        when(bookRepository.findById(1L)).thenReturn(Optional.empty());

        ResponseEntity<Book> response = bookController.getBookById(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(bookRepository, times(1)).findById(1L);
    }

    @Test
    void testCreateBook() {
        when(bookRepository.save(book)).thenReturn(book);

        Book createBook = bookController.createBook(book);

        assertNotNull(createBook);
        assertEquals("The Hobbit", createBook.getTitle());
        verify(bookRepository, times(1)).save(book);
    }




}
