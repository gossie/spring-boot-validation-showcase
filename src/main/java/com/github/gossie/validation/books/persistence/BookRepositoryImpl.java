package com.github.gossie.validation.books.persistence;

import com.github.gossie.validation.books.core.Book;
import com.github.gossie.validation.books.core.BookRepository;
import org.springframework.core.convert.ConversionService;

import java.util.List;

class BookRepositoryImpl implements BookRepository {

    private final BookEntityRepository bookEntityRepository;
    private final ConversionService conversionService;

    public BookRepositoryImpl(BookEntityRepository bookEntityRepository, ConversionService conversionService) {
        this.bookEntityRepository = bookEntityRepository;
        this.conversionService = conversionService;
    }

    @Override
    public Book createBook(Book book) {
        var entity = conversionService.convert(book, BookEntity.class);
        var saved = bookEntityRepository.save(entity);
        return conversionService.convert(saved, Book.class);
    }

    @Override
    public List<Book> getBooks() {
        return bookEntityRepository.findAll().stream()
                .map(entity -> conversionService.convert(entity, Book.class))
                .toList();
    }
}
