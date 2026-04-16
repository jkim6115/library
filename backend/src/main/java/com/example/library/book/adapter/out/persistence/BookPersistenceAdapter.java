package com.example.library.book.adapter.out.persistence;

import com.example.library.book.application.port.out.FindBookPort;
import com.example.library.book.application.port.out.ModifyBookStatusPort;
import com.example.library.book.domain.Book;
import com.example.library.book.domain.BookStatus;
import com.example.library.common.PersistenceAdapter;

@PersistenceAdapter
public class BookPersistenceAdapter implements FindBookPort, ModifyBookStatusPort {

  @Override
  public Book findById(Long bookId) {
    // TODO: DB 연동 후 실제 조회로 교체
    throw new UnsupportedOperationException("DB 연동이 필요합니다.");
  }

  @Override
  public void updateStatus(Long bookId, BookStatus status) {
    // TODO: DB 연동 후 실제 수정으로 교체
    throw new UnsupportedOperationException("DB 연동이 필요합니다.");
  }
}
