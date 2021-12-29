package com.example.bootrestbook.Dao;

import com.example.bootrestbook.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Integer> {
    public Book findById(int id);
}
