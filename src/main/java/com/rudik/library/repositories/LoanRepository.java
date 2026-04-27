package com.rudik.library.repositories;

import com.rudik.library.models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LoanRepository extends JpaRepository<Loan, Integer> {
}
