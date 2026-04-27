package com.rudik.library.controllers;

import com.rudik.library.models.Book;
import com.rudik.library.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping
    public void addBook(@RequestBody @Valid Book book){
        bookService.add(book);
    }

    @DeleteMapping("/{id}")
    public void removeBook(@PathVariable int id){
        bookService.remove(id);
    }

    @GetMapping
    public List<Book> getAvailableBooks(){
        return bookService.findAvailableBooks();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable int id){
        return bookService.findById(id);
    }

    @GetMapping("/author/{author}")
    public List<Book> findByAuthor(@PathVariable String author){
        return bookService.findByAuthor(author);
    }

    @GetMapping("/title/{title}")
    public List<Book> findByTitle(@PathVariable String title){
        return bookService.findByTitle(title);
    }
}
