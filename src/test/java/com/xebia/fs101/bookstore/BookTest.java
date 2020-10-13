package com.xebia.fs101.bookstore;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;

public class BookTest {

    @Test
    public void should_return_true_when_book_matches_specification() {
        Book book = new Book("Joshua Bloch", "Effective Java", LocalDate.of(2018, Month.JANUARY, 6), 412, Genre.TECHNOLOGY, "9780134685991", Language.ENGLISH);

        assertThat(book.matches(new BookSearchClass.Builder().withLanguage(Language.ENGLISH).build())).isTrue();
    }

    @Test
    public void should_return_false_when_book_does_not_match_specification() {
        Book book = new Book("Joshua Bloch", "Effective Java", LocalDate.of(2018, Month.JANUARY, 6), 412, Genre.TECHNOLOGY, "9780134685991", Language.ENGLISH);

        assertThat(book.matches(new BookSearchClass.Builder().withLanguage(Language.FRENCH).build())).isFalse();
    }
}
