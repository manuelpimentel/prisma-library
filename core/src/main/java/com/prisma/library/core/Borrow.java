package com.prisma.library.core;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "borrow")
class Borrow {

  @Id @GeneratedValue private Long id;

  @JoinColumn(name = "fk_user")
  @ManyToOne(targetEntity = User.class)
  private User user;

  @JoinColumn(name = "fk_book")
  @ManyToOne(targetEntity = Book.class)
  private Book book;

  @Column(name = "borrow_from")
  private LocalDate from;

  @Column(name = "borrow_to")
  private LocalDate to;
}
