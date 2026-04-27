package com.rudik.library.repositories;

import com.rudik.library.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByAuthor(String author);

    List<Book> findByTitle(String title);
    List<Book> findByAvailableTrue();
}
