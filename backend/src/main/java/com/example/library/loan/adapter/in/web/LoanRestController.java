package com.example.library.loan.adapter.in.web;

import com.example.library.loan.application.dto.LoanRequest;
import com.example.library.loan.application.dto.LoanResponse;
import com.example.library.loan.application.port.in.LoanBookPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/loans")
public class LoanRestController {

  private final LoanBookPort loanBookPort;

  @PostMapping
  public ResponseEntity<LoanResponse> loan(@RequestBody LoanRequest request) {
    LoanResponse result = loanBookPort.execute(request);
    return ResponseEntity.ok(result);
  }
}
