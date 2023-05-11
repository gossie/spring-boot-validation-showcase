package com.github.gossie.validation.books.persistence;

import com.github.gossie.validation.books.core.Book;
import org.springframework.core.convert.converter.Converter;

class BookToBookEntityConverter implements Converter<Book, BookEntity> {
    @Override
    public BookEntity convert(Book source) {
        return new BookEntity(source.id(), source.name());
    }
}
