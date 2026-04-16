package com.example.library.loan.application.port.out;

public interface UpdateBookStatusPort {

  void markAsLoaned(Long bookId);
}
