package com.prisma.library.core_api;

import java.util.Arrays;
import java.util.Objects;
import lombok.Value;

@Value
public class BookDTO {

  String title;
  String author;
  String genre;
  String publisher;

}
