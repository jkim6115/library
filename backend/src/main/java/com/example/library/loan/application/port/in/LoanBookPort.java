package com.example.library.loan.application.port.in;

import com.example.library.loan.application.dto.LoanRequest;
import com.example.library.loan.application.dto.LoanResponse;

public interface LoanBookPort {

  LoanResponse execute(LoanRequest request);
}
