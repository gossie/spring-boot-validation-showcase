package com.github.gossie.validation.books.web;

import com.github.gossie.validation.books.core.Book;
import org.springframework.core.convert.converter.Converter;

class BookToBookDTOConverter implements Converter<Book, BookDTO> {
    @Override
    public BookDTO convert(Book source) {
        return new BookDTO(source.id(), source.name());
    }
}
