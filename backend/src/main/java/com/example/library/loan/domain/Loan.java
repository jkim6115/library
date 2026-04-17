package com.example.library.loan.domain;

import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Loan {

  Long userId;
  Long bookId;
  Long workerId;
  LocalDate loanDate;
  LocalDate dueDate;
  LoanStatus status;
}
