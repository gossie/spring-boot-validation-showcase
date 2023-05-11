package com.github.gossie.validation;

import com.github.gossie.validation.books.web.CreateBookDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootValidationShowcaseApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void createBooks() {
		var createResponse1 = restTemplate.postForEntity("/api/books", new CreateBookDTO("The Catcher in the Rye"), TestBookDTO.class);
		assertThat(createResponse1.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(createResponse1.getBody().getLinks())
				.hasSize(1)
				.contains(Link.of("/api/books/1", "self"));
		assertThat(createResponse1.getBody().getName()).isEqualTo("The Catcher in the Rye");

		var createResponse2 = restTemplate.postForEntity("/api/books", new CreateBookDTO(""), TestErrorDTO.class);
		assertThat(createResponse2.getStatusCode()).isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY);
		assertThat(createResponse2.getBody()).isEqualTo(new TestErrorDTO(Map.of("name", "Name must not be empty")));
	}

}
