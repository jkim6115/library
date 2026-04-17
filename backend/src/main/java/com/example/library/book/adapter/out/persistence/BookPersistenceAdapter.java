package com.example.library.book.adapter.out.persistence;

import com.example.library.book.application.port.out.FindBookPort;
import com.example.library.book.application.port.out.ModifyBookStatusPort;
import com.example.library.book.domain.Book;
import com.example.library.book.domain.BookStatus;
import com.example.library.common.PersistenceAdapter;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class BookPersistenceAdapter implements FindBookPort, ModifyBookStatusPort {

  private final BookMapper bookMapper;
  private final BookRepository bookRepository;

  @Override
  public Book findById(Long bookId) {
    BookEntity bookEntity = bookRepository.findById(bookId)
        .orElseThrow(EntityNotFoundException::new);

    return bookMapper.mapToBook(bookEntity);
  }

  @Override
  public void updateStatus(Long bookId, BookStatus status) {
    bookRepository.save(BookEntity.builder()
        .id(bookId)
        .status(status)
        .build());
  }
}
