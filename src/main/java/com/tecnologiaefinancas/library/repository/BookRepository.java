package com.tecnologiaefinancas.library.repository;

import com.tecnologiaefinancas.library.entity.Book;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long > {

}
