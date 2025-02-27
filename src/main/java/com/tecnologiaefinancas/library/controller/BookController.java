package com.tecnologiaefinancas.library.controller;


import com.tecnologiaefinancas.library.entity.Book;
import com.tecnologiaefinancas.library.repository.BookRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    private List<Book> books = new ArrayList<>();

    @GetMapping
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        books.add(book);
        return book;
    }

    @PostConstruct
    public void init() { books.add(new Book(1L, "The Great Gatsby", "F. Scott Fitzgerald")); books.add(new Book(2L, "1984", "George Orwell")); books.add(new Book(3L, "To Kill a Mockingbird", "Harper Lee")); }
}

