package com.github.gossie.validation.books.web;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.hateoas.Link;

import java.util.List;

record BookDTO(@JsonIgnore Long id, String name) {

    public List<Link> getLinks() {
        return List.of(
                Link.of("/api/books/" + id, "self")
        );
    }

}
