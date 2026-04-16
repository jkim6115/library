package com.example.library.loan.application.port.out;

import com.example.library.loan.domain.Loan;

public interface SaveLoanPort {

  Loan save(Loan loan);
}
