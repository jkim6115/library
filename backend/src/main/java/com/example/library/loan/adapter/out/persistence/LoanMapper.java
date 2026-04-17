package com.example.library.loan.adapter.out.persistence;

import com.example.library.loan.domain.Loan;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {

  Loan mapToLoan(LoanEntity loanEntity) {
    return Loan.builder()
        .userId(loanEntity.getUserId())
        .bookId(loanEntity.getBookId())
        .loanDate(loanEntity.getLoanDate())
        .dueDate(loanEntity.getDueDate())
        .status(loanEntity.getStatus())
        .build();
  }
}
