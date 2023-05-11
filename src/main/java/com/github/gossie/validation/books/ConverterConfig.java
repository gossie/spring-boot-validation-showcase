package com.github.gossie.validation.books;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;

import java.util.Set;

@Configuration
public class ConverterConfig implements ApplicationListener<ContextRefreshedEvent> {

    private final Set<Converter<?, ?>> converters;
    private final ConversionService conversionService;

    public ConverterConfig(Set<Converter<?, ?>> converters, ConversionService conversionService) {
        this.converters = converters;
        this.conversionService = conversionService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        converters.forEach(converter -> ((GenericConversionService) conversionService).addConverter(converter));
    }
}
