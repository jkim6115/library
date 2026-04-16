package com.example.library.loan.domain;

import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Loan {

  Long userId;
  Long bookId;
  Long workerId;
  LocalDate loanDate;
  LocalDate dueDate;
  LoanStatus status;

  @Builder
  public Loan(Long userId, Long bookId, Long workerId, LocalDate loanDate, LocalDate dueDate) {
    this.userId = userId;
    this.bookId = bookId;
    this.workerId = workerId;
    this.loanDate = loanDate;
    this.dueDate = dueDate;
    this.status = LoanStatus.LOANED;
  }
}
