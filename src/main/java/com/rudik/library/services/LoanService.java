package com.rudik.library.services;

import com.rudik.library.exceptions.*;
import com.rudik.library.models.Book;
import com.rudik.library.models.Loan;
import com.rudik.library.models.Member;
import com.rudik.library.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class LoanService{
    private final LoanRepository loanRepository;
    private final BookService bookService;
    private final MemberService memberService;
    private static final double FINE_PER_DAY = 1.0;

    @Autowired
    public LoanService(LoanRepository loanRepository, BookService bookService, MemberService memberService){
        this.loanRepository = loanRepository;
        this.bookService = bookService;
        this.memberService = memberService;
    }

    public void remove(int id) {
        if(!loanRepository.existsById(id))
            throw new LoanNotFoundException("Loan not found: " + id);
        loanRepository.deleteById(id);
    }

    public Loan findById(int id) {
        return loanRepository.findById(id)
                .orElseThrow(() -> new LoanNotFoundException("Loan not found: " + id));
    }

    public List<Loan> findAll(){
        return loanRepository.findAll();
    }

    public void borrowBook(int bookId, int memberId){
        Book book = bookService.findById(bookId);
        Member member = memberService.findById(memberId);

        if(!book.isAvailable())
            throw new BookNotAvailableException("Book not available: " + book.getId());

        book.setAvailable(false);
        bookService.add(book);

        Loan loan = new Loan(book, member);
        loanRepository.save(loan);
    }

    public void returnBook(int loanId){
        Loan loan = findById(loanId);

        if(loan.getReturnDate() != null)
            throw new IllegalStateException("Book already returned");

        loan.setReturnDate(LocalDate.now());
        long daysLate = Math.max(0, ChronoUnit.DAYS.between(loan.getDueDate(), loan.getReturnDate()));

        if(daysLate > 0){
            double fine = daysLate * FINE_PER_DAY;
            loan.setFine(fine);
            memberService.increaseBalance(loan.getMember().getId(), fine);
        }

        loan.getBook().setAvailable(true);
        bookService.add(loan.getBook());

        loanRepository.save(loan);
    }
}
