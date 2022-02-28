package com.prisma.library.core_api;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class LibraryController {

  private final LibraryService libraryService;

  @GetMapping(value = "/borrowers")
  public ResponseEntity<List<UserDTO>> getBorrowers(
      @RequestParam(name = "size", required = false) Integer pageSize,
      @RequestParam(name = "number", required = false) Integer pageNumber) {
    PaginationRequestWrapper paginationRequestWrapper =
        new PaginationRequestWrapper(pageSize, pageNumber);
    return ResponseEntity.ok(libraryService.usersWhoBorrowed(paginationRequestWrapper));
  }
}
