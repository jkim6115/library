package com.example.library.book.application.port.out;

import com.example.library.book.domain.Book;

public interface FindBookPort {

  Book findById(Long bookId);
}
