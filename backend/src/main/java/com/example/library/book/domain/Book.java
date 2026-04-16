package com.example.library.book.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {

  Long id;
  BookStatus status;

  public boolean isAvailable() {
    return status == BookStatus.AVAILABLE;
  }
}
