package com.prisma.library.etl;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class EtlCSVHandlerTest {

  @InjectMocks private CSVHandler csvHandler;

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void handle_random_file() {
    final String expectedMessage = "file not found! random.csv";
    assertThrows(
        IllegalArgumentException.class,
        () -> {
          csvHandler.getRowsList("random.csv");
        },
        expectedMessage);
  }
}
