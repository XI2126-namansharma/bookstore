package com.xebia.fs101.bookstore;

import java.util.Objects;

public class BookSearchClass {
    private final String author;
    private final String title;
    private final Genre genre;
    private final Language language;

    private BookSearchClass(String author, String title, Genre genre, Language language) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.language = language;
    }

    private BookSearchClass(Builder builder) {
        author = builder.author;
        title = builder.title;
        genre = builder.genre;
        language = builder.language;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    public Language getLanguage() {
        return language;
    }

    public boolean matches(BookSearchClass searchSpec) {
        if (isEqualAndNotCaseSensitive(searchSpec.getAuthor(), this.getAuthor())) {
            return false;
        }
        if (Objects.nonNull(searchSpec.getGenre())
                && !Objects.equals(this.getGenre(), searchSpec.getGenre())) {
            return false;
        }
        if (isEqualAndNotCaseSensitive(searchSpec.getTitle(), this.getTitle())) {
            return false;
        }
        return !Objects.nonNull(searchSpec.getLanguage())
                || Objects.equals(this.getLanguage(), searchSpec.getLanguage());
    }

    private boolean isEqualAndNotCaseSensitive(String author, String s2) {
        return Objects.nonNull(author)
                && !Objects.equals(s2.toLowerCase(), author.toLowerCase());
    }

    public static final class Builder {
        private String author;
        private String title;
        private Genre genre;
        private Language language;

        public Builder() {
        }

        public Builder(Book book) {
            this.author = book.getAuthor();
            this.title = book.getTitle();
            this.language = book.getLanguage();
            this.genre = book.getGenre();
        }

        public Builder withAuthor(String val) {
            author = val;
            return this;
        }

        public Builder withTitle(String val) {
            title = val;
            return this;
        }

        public Builder withGenre(Genre val) {
            genre = val;
            return this;
        }

        public Builder withLanguage(Language val) {
            language = val;
            return this;
        }

        public BookSearchClass build() {
            return new BookSearchClass(this);
        }
    }
}
