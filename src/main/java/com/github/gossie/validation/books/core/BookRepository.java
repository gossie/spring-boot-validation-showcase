package com.github.gossie.validation.books.core;

import java.util.List;

public interface BookRepository {

    Book createBook(Book book);

    List<Book> getBooks();

}
