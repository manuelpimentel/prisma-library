package com.prisma.library.etl;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Borrow {

  @CsvBindByName(column = "Borrower")
  private String borrower;

  @CsvBindByName(column = "Book")
  private String book;

  @CsvBindByName(column = "borrowed from")
  private String from;

  @CsvBindByName(column = "borrowed to")
  private String to;
}
