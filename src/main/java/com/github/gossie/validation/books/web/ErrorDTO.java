package com.github.gossie.validation.books.web;

import java.util.Map;

record ErrorDTO(Map<String, String> fieldErrors) {
}
