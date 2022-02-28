package com.prisma.library.etl;

import com.opencsv.bean.CsvBindByName;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
class Book {

  @CsvBindByName(column = "Title")
  String title;

  @CsvBindByName(column = "Author")
  String author;

  @CsvBindByName(column = "Genre")
  String genre;

  @CsvBindByName(column = "Published")
  String publisher;
}
