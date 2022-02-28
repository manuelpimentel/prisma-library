package com.prisma.library.core_api;

import java.time.LocalDate;
import lombok.Value;

@Value
public class BorrowDTO {

  String user;
  String book;
  LocalDate from;
  LocalDate to;
}
