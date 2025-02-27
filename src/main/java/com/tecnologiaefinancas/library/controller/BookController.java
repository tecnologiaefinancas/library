package com.tecnologiaefinancas.library.controller;



import com.tecnologiaefinancas.library.entity.Book;
import com.tecnologiaefinancas.library.repository.BookRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    BookRepository bookRepository;


    @GetMapping
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }


    @PostConstruct
    public void init() {
        List<Book> books = Arrays.asList(
                new Book("The Great Gatsby", "F. Scott Fitzgerald"),
                new Book("1984", "George Orwell"),
                new Book("To Kill a Mockingbird", "Harper Lee"),
                new Book("Moby-Dick", "Herman Melville"),
                new Book("Pride and Prejudice", "Jane Austen"),
                new Book("War and Peace", "Leo Tolstoy"),
                new Book("The Catcher in the Rye", "J.D. Salinger"),
                new Book("The Hobbit", "J.R.R. Tolkien")
        );
        bookRepository.saveAll(books);
    }

}

