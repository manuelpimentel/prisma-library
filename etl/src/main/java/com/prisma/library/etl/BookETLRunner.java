package com.prisma.library.etl;

import static java.util.stream.Collectors.toList;

import com.prisma.library.core_api.BookDTO;
import com.prisma.library.core_api.LibraryService;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class BookETLRunner {

  private static final String CSV_FILE_NAME = "books.csv";

  private final CSVHandler csvHandler;
  private final BookETLMapper bookMapper;
  private final LibraryService libraryService;

  public void run() {
    List<String[]> rows = csvHandler.getRowsList(CSV_FILE_NAME);
    load(transform(rows));
  }

  private void load(List<BookDTO> books) {
    libraryService.loadBooks(books);
  }

  private List<BookDTO> transform(List<String[]> rows) {
    return rows.stream()
        .filter(row -> !Arrays.stream(row).allMatch(String::isBlank))
        .map(this::buildBook)
        .map(bookMapper::toDTO)
        .collect(toList());
  }

  private Book buildBook(String[] row) {
    return Book.builder().title(row[0]).author(row[1]).genre(row[2]).publisher(row[3]).build();
  }
}
