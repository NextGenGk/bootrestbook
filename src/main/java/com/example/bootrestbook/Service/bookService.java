package com.example.bootrestbook.Service;

import com.example.bootrestbook.Dao.BookRepository;
import com.example.bootrestbook.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class bookService {

    @Autowired
    private BookRepository bookRepository;

//    private static List<Book> list = new ArrayList<>();
//
//    static {
//        list.add(new Book(12, "Java", "James Gosling"));
//        list.add(new Book(13, "C++", "Bjarne StrouStrup"));
//        list.add(new Book(14, "C", "Dennis Ritchie"));
//    }

    // get all books
    public List<Book> getAllBooks() {
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    // get single books by id
    public Book getBookById(int id) {
        Book book = null;
        try {
           // book = list.stream().filter(e -> e.getId() == id).findFirst().get();
           book = this.bookRepository.findById(id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return book;
    }

    // adding the book
    public Book addBook(Book book) {
        Book result = bookRepository.save(book);
        return result;
//        list.add(book);
//        return book;
    }

    // delete book
    public void deleteBook(int bId) {
        bookRepository.deleteById(bId);
//        list = list.stream().filter(book -> book.getId() != bId).collect(Collectors.toList());
    }

    // update book
    public void updateBook(Book book, int bookId) {
        book.setId(bookId);
        bookRepository.save(book);
//        list.stream().map(b -> {
//            if (b.getId() == bookId) {
//                b.setBookName(book.getBookName());
//                b.setAuthorName(book.getAuthorName());
//            }
//            return b;
//        }).collect(Collectors.toList());

    }
}