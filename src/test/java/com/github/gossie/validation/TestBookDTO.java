package com.github.gossie.validation;

import org.springframework.hateoas.Link;

import java.util.List;
import java.util.Objects;

public class TestBookDTO {

    private String name;
    private List<Link> links;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestBookDTO that = (TestBookDTO) o;
        return Objects.equals(name, that.name) && Objects.equals(links, that.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, links);
    }
}
