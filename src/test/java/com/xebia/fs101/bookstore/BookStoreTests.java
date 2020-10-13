package com.xebia.fs101.bookstore;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BookStoreTests {

    @Test
    public void should_be_able_to_search_many_books_present_in_bookstore_inventory() {
        BookStore bookStore = getBookStore();

        List<Book> foundBooks = bookStore.search(
                new BookSearchClass.Builder().withGenre(Genre.TECHNOLOGY).withLanguage(Language.ENGLISH).build());

        assertThat(foundBooks).hasSize(2);
        assertThat(foundBooks.get(0).getTitle()).isEqualTo("Effective Java");
        assertThat(foundBooks.get(1).getTitle()).isEqualTo("Clean Code");
    }

    @Test
    public void should_be_return_empty_list_when_search_criteria_does_not_match() {
        BookStore bookStore = getBookStore();

        List<Book> foundBooks = bookStore.search(
                new BookSearchClass.Builder().withGenre(Genre.TECHNOLOGY).withLanguage(Language.FRENCH).build());

        assertThat(foundBooks).isEmpty();
    }

    private BookStore getBookStore() {
        BookStore bookStore = new BookStore();
        bookStore.addBook(new Book("Joshua Bloch", "Effective Java", LocalDate.of(2018, Month.JANUARY, 6), 412, Genre.TECHNOLOGY, "9780134685991", Language.ENGLISH));
        bookStore.addBook(new Book("Robert C. Martin", "Clean Code", LocalDate.of(2008, Month.AUGUST, 1), 464, Genre.TECHNOLOGY, "9780132350884", Language.ENGLISH));
        bookStore.addBook(new Book("Daniel Kahneman", "Thinking, Fast and Slow", LocalDate.of(2011, Month.OCTOBER, 25), 512, Genre.PSYCHOLOGY, "9780374275631", Language.ENGLISH));
        bookStore.addBook(new Book("Antoine de Saint-Exupéry", "The Little Prince", LocalDate.of(2000, Month.MAY, 15), 96, Genre.FICTION, "9780156012195", Language.FRENCH));
        bookStore.addBook(new Book("Günter Grass", "Die Blechtrommel", LocalDate.of(1993, Month.OCTOBER, 1), 778, Genre.FICTION, "978-3423118217", Language.GERMAN));
        return bookStore;
    }
}