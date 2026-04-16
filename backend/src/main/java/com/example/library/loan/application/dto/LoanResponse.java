package com.example.library.loan.application.dto;

import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoanResponse {

  LocalDate loanDate;
  LocalDate dueDate;

  @Builder
  public LoanResponse(LocalDate loanDate, LocalDate dueDate) {
    this.loanDate = loanDate;
    this.dueDate = dueDate;
  }
}
