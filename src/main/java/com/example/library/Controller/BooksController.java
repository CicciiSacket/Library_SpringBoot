package com.example.library;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.library.Book;
import com.example.library.BooksController;
import com.example.library.BooksDAO;


@RestController
@RequestMapping(path = "/books")
public class BooksController {

    @Autowired
    private BooksDAO booksDAO;

    @GetMapping(path = "/", produces = "application/json")
    public BooksService getBooks() {
        return booksDAO.getAllBooks();
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Book book) {
        Integer id = booksDAO.getAllBooks().getBooks().size() + 1;
        book.setId(id);
        booksDAO.addBooks(book);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    
    @DeleteMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Integer> deleteBooks(@PathVariable Integer id) {
        booksDAO.removeBooks(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
