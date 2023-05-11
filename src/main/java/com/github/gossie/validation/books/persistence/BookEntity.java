package com.github.gossie.validation.books.persistence;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "books")
class BookEntity{
        @Id
        @GeneratedValue
        private Long id;

        private String name;

    public BookEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public BookEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
