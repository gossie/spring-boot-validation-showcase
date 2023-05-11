package com.github.gossie.validation.books.persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;

@Configuration
public class PersistenceContext {

    @Bean
    BookToBookEntityConverter bookToBookEntityConverter() {
        return new BookToBookEntityConverter();
    }

    @Bean
    BookEntityToBookConverter bookEntityToBookConverter() {
        return new BookEntityToBookConverter();
    }

    @Bean
    BookRepositoryImpl bookRepository(BookEntityRepository bookEntityRepository, ConversionService conversionService) {
        return new BookRepositoryImpl(bookEntityRepository, conversionService);
    }

}
