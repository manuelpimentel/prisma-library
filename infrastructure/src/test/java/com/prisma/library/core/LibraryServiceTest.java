package com.prisma.library.core;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.prisma.library.core_api.BookDTO;
import com.prisma.library.core_api.BorrowDTO;
import com.prisma.library.core_api.UserDTO;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class LibraryServiceTest {
  @InjectMocks private LibraryServiceImpl libraryService;
  @Mock private BorrowJPARepository borrowJPARepository;

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void load_books_null_title_expect_error() {
    List<BookDTO> books =
        Stream.of(new BookDTO(null, "author", "genre", "publisher")).collect(toList());
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          libraryService.loadBooks(books);
        });
  }

  @Test
  void load_borrows_null_user_expect_error() {
    List<BorrowDTO> borrows =
        Stream.of(new BorrowDTO(null, "book", LocalDate.now(), LocalDate.now())).collect(toList());
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          libraryService.loadBorrows(borrows);
        });
  }

  @Test
  void load_borrows_null_book_expect_error() {
    List<BorrowDTO> borrows =
        Stream.of(new BorrowDTO(null, "book", LocalDate.now(), LocalDate.now())).collect(toList());
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          libraryService.loadBorrows(borrows);
        });
  }

  @Test
  void load_users_null_id_expect_error() {
    List<UserDTO> users =
        Stream.of(UserDTO.builder().firstName("firsName").build()).collect(toList());
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          libraryService.loadUsers(users);
        });
  }
}
