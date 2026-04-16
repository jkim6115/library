package com.example.library.loan.application;

import com.example.library.book.domain.Book;
import com.example.library.common.UseCase;
import com.example.library.loan.application.dto.LoanRequest;
import com.example.library.loan.application.dto.LoanResponse;
import com.example.library.loan.application.port.in.LoanBookPort;
import com.example.library.loan.application.port.out.LoadBookPort;
import com.example.library.loan.application.port.out.LoadUserPort;
import com.example.library.loan.application.port.out.SaveLoanPort;
import com.example.library.loan.application.port.out.UpdateBookStatusPort;
import com.example.library.loan.domain.Loan;
import com.example.library.loan.domain.LoanPolicy;
import com.example.library.user.domain.User;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class LoanBookUseCase implements LoanBookPort {

  private final LoadUserPort loadUserPort;
  private final LoadBookPort loadBookPort;
  private final SaveLoanPort saveLoanPort;
  private final UpdateBookStatusPort updateBookStatusPort;
  private final LoanPolicy loanPolicy;

  @Override
  public LoanResponse execute(LoanRequest request) {
    User user = loadUserPort.loadUser(request.getUserId());
    Book book = loadBookPort.loadBook(request.getBookId());

    loanPolicy.validateLoan(user, book);

    LocalDate loanDate = LocalDate.now();
    LocalDate dueDate = loanPolicy.calculateDueDate(loanDate);

    Loan loan = Loan.builder()
        .bookId(book.getId())
        .userId(user.getId())
        .workerId(request.getWorkerId())
        .loanDate(loanDate)
        .dueDate(dueDate)
        .build();

    Loan savedLoan = saveLoanPort.save(loan);

    updateBookStatusPort.markAsLoaned(request.getBookId());

    return LoanResponse.builder()
        .loanDate(savedLoan.getLoanDate())
        .dueDate(savedLoan.getDueDate())
        .build();
  }
}
