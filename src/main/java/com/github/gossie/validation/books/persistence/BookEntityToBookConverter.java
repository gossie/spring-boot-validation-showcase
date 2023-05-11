package com.github.gossie.validation.books.persistence;

import com.github.gossie.validation.books.core.Book;
import org.springframework.core.convert.converter.Converter;

class BookEntityToBookConverter implements Converter<BookEntity, Book> {
    @Override
    public Book convert(BookEntity source) {
        return new Book(source.getId(), source.getName());
    }
}
