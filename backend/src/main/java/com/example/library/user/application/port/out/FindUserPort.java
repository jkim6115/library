package com.example.library.user.application.port.out;

import com.example.library.user.domain.User;

public interface FindUserPort {

  User findById(Long userId);
}
