package com.example.library.loan.adapter.out.persistence;

import com.example.library.loan.domain.LoanStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "loans")
public class LoanEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(nullable = false)
  Long bookId;

  @Column(nullable = false)
  Long userId;

  @Column(nullable = false)
  Long workerId;

  @Column(nullable = false)
  LocalDate loanDate;

  @Column
  LocalDate dueDate;

  @Enumerated(EnumType.STRING)
  LoanStatus status;

  @Builder
  public LoanEntity(Long bookId, Long userId, Long workerId, LocalDate loanDate, LocalDate dueDate,
      LoanStatus status) {
    this.bookId = bookId;
    this.userId = userId;
    this.workerId = workerId;
    this.loanDate = loanDate;
    this.dueDate = dueDate;
    this.status = status;
  }
}
