package com.example.library.loan.adapter.out.persistence;

import com.example.library.common.PersistenceAdapter;
import com.example.library.loan.application.port.out.SaveLoanPort;
import com.example.library.loan.domain.Loan;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class LoanPersistenceAdapter implements SaveLoanPort {

  private final LoanRepository loanRepository;

  @Override
  public Loan save(Loan loan) {
    loanRepository.save(LoanEntity.builder()
        .userId(loan.getUserId())
        .bookId(loan.getBookId())
        .workerId(loan.getWorkerId())
        .loanDate(loan.getLoanDate())
        .dueDate(loan.getDueDate())
        .status(loan.getStatus())
        .build());

    return loan;
  }
}
