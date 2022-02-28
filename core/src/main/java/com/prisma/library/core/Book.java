package com.prisma.library.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "book")
class Book {

  @Id private String title;

  @Column(name = "author")
  private String author;

  @Column(name = "genre")
  private String genre;

  @Column(name = "publisher")
  private String publisher;
}
