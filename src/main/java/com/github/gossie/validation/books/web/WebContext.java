package com.github.gossie.validation.books.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebContext {

    @Bean
    CreateBookDTOToBookConverter createBookDTOToBookConverter() {
        return new CreateBookDTOToBookConverter();
    }

    @Bean
    BookToBookDTOConverter bookToBookDTOConverter() {
        return new BookToBookDTOConverter();
    }

}
