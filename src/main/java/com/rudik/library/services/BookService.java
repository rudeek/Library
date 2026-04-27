package com.rudik.library.services;

import com.rudik.library.exceptions.BookNotFoundException;
import com.rudik.library.exceptions.MemberNotFoundException;
import com.rudik.library.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rudik.library.repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService implements Manageable<Book>{
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public void add(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void remove(int id) {
        if(!bookRepository.existsById(id))
            throw new BookNotFoundException("Book not found: " + id);
        bookRepository.deleteById(id);
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found: " + id));
    }

    public List<Book> findByAuthor(String author){
        return bookRepository.findByAuthor(author);
    }

    public List<Book> findByTitle(String title){
        return bookRepository.findByTitle(title);
    }

    public List<Book> findAvailableBooks(){
        return bookRepository.findByAvailableTrue();
    }
}
