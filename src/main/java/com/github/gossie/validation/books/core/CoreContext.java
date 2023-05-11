package com.github.gossie.validation.books.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreContext {

    @Bean
    BookService bookService(BookRepository bookRepository) {
        return new BookService(bookRepository);
    }

}
