package com.rudik.library.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @NotNull
    private Book book;

    @ManyToOne
    @JoinColumn(name = "member_id")
    @NotNull
    private Member member;

    private LocalDate loanDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    private double fine = 0;

    protected Loan() {}

    public Loan(Book book, Member member){
        this.book = book;
        this.member = member;
        this.loanDate = LocalDate.now();
        this.dueDate = this.loanDate.plusDays(14);//на возврат даётся 2 недели
        returnDate = null;
    }

    public int getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDate getDueDate(){
        return dueDate;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        if(fine < 0)
            throw new IllegalArgumentException("Fine should be greater than 0!");
        this.fine = fine;
    }

    @Override
    public String toString(){
        return "Book: " + book.getTitle() + "\nMember: " + member.getName() + "\nLoan date: " + loanDate.toString() + "\nDue date: " + dueDate.toString() +  "\nReturn date: " + (returnDate != null ? returnDate : "not returned");
    }
}
