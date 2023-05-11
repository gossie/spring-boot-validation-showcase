package com.github.gossie.validation.books.core;

import java.util.HashMap;
import java.util.List;

public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(Book book) {
        validateBook(book);
        return bookRepository.createBook(book);
    }

    private void validateBook(Book book) {
        var fieldErrors = new HashMap<String, String>();

        if (book.name() == null || book.name().isBlank()) {
            fieldErrors.put("name", "Name must not be empty");
        }

        if (!fieldErrors.isEmpty()) {
            throw new BookValidationException("book could not be saved", fieldErrors);
        }
    }

    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }

}
