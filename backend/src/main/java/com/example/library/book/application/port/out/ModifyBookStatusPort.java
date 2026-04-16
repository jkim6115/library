package com.example.library.book.application.port.out;

import com.example.library.book.domain.BookStatus;

public interface ModifyBookStatusPort {

  void updateStatus(Long bookId, BookStatus status);
}
