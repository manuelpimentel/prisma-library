package com.prisma.library.etl;

import static java.util.stream.Collectors.toList;

import com.prisma.library.core_api.BorrowDTO;
import com.prisma.library.core_api.LibraryService;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class BorrowETLRunner {

  private static final String CSV_FILE_NAME = "borrowed.csv";

  private final CSVHandler csvHandler;
  private final BorrowETLMapper borrowETLMapper;
  private final LibraryService libraryService;

  public void run() {
    List<String[]> rows = csvHandler.getRowsList(CSV_FILE_NAME);
    load(transform(rows));
  }

  private void load(List<BorrowDTO> borrows) {
    libraryService.loadBorrows(borrows);
  }

  private List<BorrowDTO> transform(List<String[]> rows) {
    return rows.stream()
        .filter(row -> !Arrays.stream(row).allMatch(String::isBlank))
        .map(this::buildBorrow)
        .map(borrowETLMapper::toDTO)
        .collect(toList());
  }

  private Borrow buildBorrow(String[] row) {
    return Borrow.builder()
        .borrower(row[0])
        .book(row[1])
        .from(row[2].isEmpty() ? null : row[2])
        .to(row[3].isEmpty() ? null : row[3])
        .build();
  }
}
