package com.example.bootrestbook.Controller;

import com.example.bootrestbook.Service.bookService;
import com.example.bootrestbook.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BooKController {

    @Autowired
    private bookService bookService;

    // get all book handler
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){
            List<Book> list = bookService.getAllBooks();
            if (list.size() == 0){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    // get single book handler

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id)
    {
        Book book = bookService.getBookById(id);
        if (book == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    // new book handler
    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book b = null;
        try {
            b = this.bookService.addBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        catch (Exception e){
            e.printStackTrace();
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // delete book handler
    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId){
       try {
           this.bookService.deleteBook(bookId);
           return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
       }
       catch (Exception e){
           e.printStackTrace();
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
    }

    // update book handler
    @PutMapping("/books/{bookId}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId){
        try {
            this.bookService.updateBook(book, bookId);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
