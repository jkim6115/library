package com.example.library.loan.application.port.out;

import com.example.library.book.domain.Book;

public interface LoadBookPort {

  Book loadBook(Long bookId);
}
