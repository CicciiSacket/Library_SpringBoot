package com.example.library;

import org.springframework.stereotype.Repository;
import com.example.library.BooksService;

@Repository
public class BooksDAO {

    private static BooksService list = new BooksService();

    static { list.getBooks().add(new Book(1,"Java Programming","W3School")); }
    
    public BooksService getAllBooks() {
        return list;
    }
    public void addBooks(Book book) {
        list.getBooks().add(book);
    }
}