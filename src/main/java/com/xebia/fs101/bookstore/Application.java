package com.xebia.fs101.bookstore;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        BookStore bookStore = new BookStore();
        bookStore.addBook(new Book("Joshua Bloch", "Effective Java", LocalDate.of(2018, Month.JANUARY, 6), 412, Genre.TECHNOLOGY, "9780134685991", Language.ENGLISH));
        bookStore.addBook(new Book("Robert C. Martin", "Clean Code", LocalDate.of(2008, Month.AUGUST, 1), 464, Genre.TECHNOLOGY, "9780132350884", Language.ENGLISH));
        bookStore.addBook(new Book("Daniel Kahneman", "Thinking, Fast and Slow", LocalDate.of(2011, Month.OCTOBER, 25), 512, Genre.PSYCHOLOGY, "9780374275631", Language.ENGLISH));
        bookStore.addBook(new Book("Antoine de Saint-Exupéry", "The Little Prince", LocalDate.of(2000, Month.MAY, 15), 96, Genre.FICTION, "9780156012195", Language.FRENCH));
        bookStore.addBook(new Book("Günter Grass", "Die Blechtrommel", LocalDate.of(1993, Month.OCTOBER, 1), 778, Genre.FICTION, "978-3423118217", Language.GERMAN));

        List<Book> results = bookStore.search(new BookSearchClass.Builder()
                .withGenre(Genre.TECHNOLOGY)
                .withLanguage(Language.ENGLISH)
                .build());

        for (Book result : results)
            System.out.println(result);
    }
}
