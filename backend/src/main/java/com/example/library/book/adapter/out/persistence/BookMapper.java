package com.example.library.book.adapter.out.persistence;

import com.example.library.book.domain.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

  Book mapToBook(BookEntity bookEntity) {
    return Book.builder()
        .id(bookEntity.getId())
        .status(bookEntity.getStatus())
        .build();
  }
}
