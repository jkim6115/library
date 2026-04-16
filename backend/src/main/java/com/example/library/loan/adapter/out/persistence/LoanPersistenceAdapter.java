package com.example.library.loan.adapter.out.persistence;

import com.example.library.common.PersistenceAdapter;
import com.example.library.loan.application.port.out.SaveLoanPort;
import com.example.library.loan.domain.Loan;

@PersistenceAdapter
public class LoanPersistenceAdapter implements SaveLoanPort {

  @Override
  public Loan save(Loan loan) {
    // TODO: DB 연동 후 실제 저장으로 교체
    throw new UnsupportedOperationException("DB 연동이 필요합니다.");
  }
}
