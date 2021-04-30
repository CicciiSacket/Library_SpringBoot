package com.example.library;

import java.util.ArrayList;
import java.util.List;

public class BooksService {

    private List<Book> booksList;

    public List<Book> getBooks() {
        if (booksList == null) {
            booksList = new ArrayList<>();
        }
        return booksList;
    }

    public void setBooks(List<Book> booksList) {
        this.booksList = booksList;
    }
}
