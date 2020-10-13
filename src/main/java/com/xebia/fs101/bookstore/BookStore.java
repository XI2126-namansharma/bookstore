package com.xebia.fs101.bookstore;

import java.util.ArrayList;
import java.util.List;

public class BookStore {

    private final List<Book> books;

    public BookStore() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public List<Book> search(BookSearchClass searchSpec) {
        List<Book> results = new ArrayList<>();
        for (Book book : books)
            if (book.matches(searchSpec))
                results.add(book);
        return results;
    }
}