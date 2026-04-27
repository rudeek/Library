package com.rudik.library.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Min(value = 0, message = "Year must be positive!")
    @Max(value = 2026, message = "Year can not be in the future")
    private int year;

    @NotBlank(message = "Title must not be blank!")
    @Size(min = 3, message = "Title must be at least 3 characters long!")
    private String title;

    @NotBlank(message = "Author must not be blank!")
    @Size(min = 3, message = "Author must be at least 3 characters long!")
    private String author;

    @NotNull(message = "Genre must not be null!")
    @Enumerated(EnumType.STRING)
    private Genre genre;

    private boolean available = true;

    protected Book() {}

    public Book(String title, String author, int year, Genre genre) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString(){
        return "Title: " + title + "\nAuthor: " + author + "\nYear: " + year + "\nGenre: " + genre + "\nAvailable: " + available;
    }
}
