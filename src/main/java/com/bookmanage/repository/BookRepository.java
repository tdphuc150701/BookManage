package com.bookmanage.repository;

import java.util.Optional;

import com.bookmanage.entity.BookEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
	 Optional<BookEntity> findById(Long id);
}
