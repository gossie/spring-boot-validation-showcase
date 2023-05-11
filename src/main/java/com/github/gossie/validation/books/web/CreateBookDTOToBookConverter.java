package com.github.gossie.validation.books.web;

import com.github.gossie.validation.books.core.Book;
import org.springframework.core.convert.converter.Converter;

public class CreateBookDTOToBookConverter implements Converter<CreateBookDTO, Book> {
    @Override
    public Book convert(CreateBookDTO source) {
        return new Book(null, source.name());
    }
}
