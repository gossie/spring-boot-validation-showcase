package com.github.gossie.validation.books.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface BookEntityRepository extends JpaRepository<BookEntity, Long> {
}
