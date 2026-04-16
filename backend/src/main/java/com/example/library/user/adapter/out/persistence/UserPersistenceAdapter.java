package com.example.library.user.adapter.out.persistence;

import com.example.library.common.PersistenceAdapter;
import com.example.library.user.application.port.out.FindUserPort;
import com.example.library.user.domain.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class UserPersistenceAdapter implements FindUserPort {

  private final UserRepository userRepository;

  @Override
  public User findById(Long userId) {
    UserEntity userEntity = userRepository.findById(userId)
        .orElseThrow(EntityNotFoundException::new);

    // TODO: DB 연동 후 실제 조회로 교체
    throw new UnsupportedOperationException("DB 연동이 필요합니다.");
  }
}
