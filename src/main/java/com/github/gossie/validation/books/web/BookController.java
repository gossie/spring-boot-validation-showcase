package com.github.gossie.validation.books.web;

import com.github.gossie.validation.books.core.Book;
import com.github.gossie.validation.books.core.BookService;
import com.github.gossie.validation.books.core.BookValidationException;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;
    private final ConversionService conversionService;

    public BookController(BookService bookService, ConversionService conversionService) {
        this.bookService = bookService;
        this.conversionService = conversionService;
    }

    @PostMapping
    public ResponseEntity<BookDTO> createNewBook(@RequestBody CreateBookDTO dto) {
        var book = conversionService.convert(dto, Book.class);
        var saved = bookService.createBook(book);
        return ResponseEntity
                .created(URI.create("/api/books/" + saved.id()))
                .body(conversionService.convert(saved, BookDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getBooks() {
        var books = bookService.getBooks().stream()
                .map(book -> conversionService.convert(book, BookDTO.class))
                .toList();

        return ResponseEntity.ok(books);
    }

    @ExceptionHandler(BookValidationException.class)
    ResponseEntity<ErrorDTO> handleBookValidationException(BookValidationException cause) {
        return ResponseEntity
                .unprocessableEntity()
                .body(new ErrorDTO(cause.getFieldErrors()));
    }

}
