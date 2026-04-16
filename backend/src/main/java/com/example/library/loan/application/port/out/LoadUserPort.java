package com.example.library.loan.application.port.out;

import com.example.library.user.domain.User;

public interface LoadUserPort {

  User loadUser(Long userId);
}
