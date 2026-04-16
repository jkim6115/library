package com.example.library.loan.adapter.out.external;

import com.example.library.loan.application.port.out.LoadUserPort;
import com.example.library.user.application.port.out.FindUserPort;
import com.example.library.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserQueryAdapter implements LoadUserPort {

  private final FindUserPort findUserPort;

  @Override
  public User loadUser(Long userId) {
    return findUserPort.findById(userId);
  }
}
