package com.prisma.library.etl;

import static java.util.stream.Collectors.toList;

import com.prisma.library.core_api.LibraryService;
import com.prisma.library.core_api.UserDTO;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class UserETLRunner {

  private static final String CSV_FILE_NAME = "user.csv";

  private final CSVHandler csvHandler;
  private final UserETLMapper userETLMapper;
  private final LibraryService libraryService;

  public void run() {
    List<String[]> rows = csvHandler.getRowsList(CSV_FILE_NAME);
    load(transform(rows));
  }

  private void load(List<UserDTO> users) {
    libraryService.loadUsers(users);
  }

  private List<UserDTO> transform(List<String[]> rows) {
    return rows.stream()
        .filter(row -> !Arrays.stream(row).allMatch(String::isBlank))
        .map(this::buildUser)
        .map(userETLMapper::toDTO)
        .collect(toList());
  }

  private User buildUser(String[] row) {
    return User.builder()
        .lastName(row[0])
        .firstName(row[1])
        .memberSince(row[2].isEmpty() ? null : row[2])
        .memberTill(row[3].isEmpty() ? null : row[3])
        .gender(row[4])
        .build();
  }
}
