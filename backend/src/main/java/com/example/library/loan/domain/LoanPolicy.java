package com.example.library.loan.domain;

import com.example.library.book.domain.Book;
import com.example.library.user.domain.User;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class LoanPolicy {

  private static final int DEFAULT_LOAN_DAYS = 15;

  public void validateLoan(
      User user,
      Book book
  ) {
    if (user.isSuspended()) {
      throw new IllegalStateException("대출 정지 회원입니다.");
    }

    if (!book.isAvailable()) {
      throw new IllegalStateException("대출 불가능한 도서입니다.");
    }
  }

  public LocalDate calculateDueDate(LocalDate loanDate) {
    return loanDate.plusDays(DEFAULT_LOAN_DAYS);
  }
}
