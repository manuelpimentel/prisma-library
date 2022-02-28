package com.prisma.library.core_api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class LibraryControllerTest {

  @InjectMocks private LibraryController libraryController;
  @Mock private LibraryService libraryService;

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void get_borrowers_with_pagination() {
    ResponseEntity responseEntity = libraryController.getBorrowers(1, 1);
    final HttpStatus statusCode = responseEntity.getStatusCode();
    assertEquals(HttpStatus.OK, statusCode);
  }

  @Test
  void getBorrowers_with_null_pagination_expect_null_pointer() {
    assertThrows(
        NullPointerException.class,
        () -> {
          libraryController.getBorrowers(null, null);
        });
  }
}
