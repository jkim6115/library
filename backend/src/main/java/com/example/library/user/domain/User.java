package com.example.library.user.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

  Long id;
  UserStatus status;

  public boolean isSuspended() {
    return status == UserStatus.SUSPENDED;
  }
}
