package com.example.library.user.adapter.out.persistence;

import com.example.library.user.domain.User;

public class UserMapper {

  User mapToUser(UserEntity userEntity) {
    return User.builder()
        .id(userEntity.getId())
        .status(userEntity.getStatus())
        .build();
  }
}
