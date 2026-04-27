package com.rudik.library.controllers;

import com.rudik.library.models.Loan;
import com.rudik.library.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {
    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService){
        this.loanService = loanService;
    }

    @DeleteMapping("/{id}")
    public void removeLoan(@PathVariable int id){
        loanService.remove(id);
    }

    @GetMapping("/{id}")
    public Loan getLoan(@PathVariable int id){
        return loanService.findById(id);
    }

    @GetMapping()
    public List<Loan> getAllLoans(){
        return loanService.findAll();
    }

    @PostMapping("/borrow")
    public void borrowBook(@RequestParam int bookId, @RequestParam int memberId){
        loanService.borrowBook(bookId,memberId);
    }

    @PutMapping("return/{loanId}")
    public void returnBook(@PathVariable int loanId){
        loanService.returnBook(loanId);
    }
}
