package com.xebia.fs101.bookstore;

import java.time.LocalDate;

public class Book {

    //Search parameter
    private final String author;
    private final String title;
    private final Genre genre;
    private final Language language;

    //Extra details
    private final LocalDate publishedOn;
    private final int pages;
    private final String isbn;

    public Book(String author, String title,
                LocalDate publishedOn, int pages,
                Genre genre, String isbn,
                Language language) {
        this.author = author;
        this.title = title;
        this.publishedOn = publishedOn;
        this.pages = pages;
        this.genre = genre;
        this.isbn = isbn;
        this.language = language;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getPublishedOn() {
        return publishedOn;
    }

    public int getPages() {
        return pages;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public Language getLanguage() {
        return language;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

    public boolean matches(BookSearchClass searchSpec) {
        BookSearchClass bookSearchClass = new BookSearchClass.Builder(this).build();
        return bookSearchClass.matches(searchSpec);
    }
}
