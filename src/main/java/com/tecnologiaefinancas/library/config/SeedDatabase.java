package com.tecnologiaefinancas.library.config;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.tecnologiaefinancas.library.entity.Book;
import org.bson.Document;

import java.util.Arrays;

public class SeedDatabase {
    public static void main(String[] args) {
        var client = MongoClients.create("mongodb://mongodb:27017");
        var database = client.getDatabase("librarydb");
        var collection = database.getCollection("books", Book.class);

        collection.drop();

        collection.insertMany(Arrays.asList(
                new Book(1L, "To Kill a Mockingbird", "Harper Lee"),
                new Book(2L, "1984", "George Orwell"),
                new Book(3L, "Moby-Dick", "Herman Melville"),
                new Book(4L, "The Great Gatsby", "F. Scott Fitzgerald"),
                new Book(5L, "Pride and Prejudice", "Jane Austen"),
                new Book(6L, "The Catcher in the Rye", "J.D. Salinger"),
                new Book(7L, "The Hobbit", "J.R.R. Tolkien"),
                new Book(8L, "Brave New World", "Aldous Huxley"),
                new Book(9L, "War and Peace", "Leo Tolstoy"),
                new Book(10L, "The Odyssey", "Homer")
        ));

        System.out.println("Database seeded!");
        client.close();
    }
}

