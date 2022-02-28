package com.prisma.library.core;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "client")
public class User {

  @Id private String id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "member_since")
  private LocalDate memberSince;

  @Column(name = "member_till")
  private LocalDate memberTill;

  @Column(name = "gender")
  private String gender;
}
