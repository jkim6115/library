package com.example.library.loan.adapter.out.external;

import com.example.library.book.application.port.out.FindBookPort;
import com.example.library.book.application.port.out.ModifyBookStatusPort;
import com.example.library.book.domain.Book;
import com.example.library.book.domain.BookStatus;
import com.example.library.loan.application.port.out.LoadBookPort;
import com.example.library.loan.application.port.out.UpdateBookStatusPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookQueryAdapter implements LoadBookPort, UpdateBookStatusPort {

  private final FindBookPort findBookPort;
  private final ModifyBookStatusPort modifyBookStatusPort;

  @Override
  public Book loadBook(Long bookId) {
    return findBookPort.findById(bookId);
  }

  @Override
  public void markAsLoaned(Long bookId) {
    modifyBookStatusPort.updateStatus(bookId, BookStatus.LOANED);
  }
}
