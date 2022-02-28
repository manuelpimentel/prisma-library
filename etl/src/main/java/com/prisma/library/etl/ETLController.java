package com.prisma.library.etl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("etl")
@RequiredArgsConstructor
class ETLController {

  private final BookETLRunner bookRunner;
  private final BorrowETLRunner borrowRunner;
  private final UserETLRunner userRunner;

  @GetMapping("/execute")
  public ResponseEntity executeETL() {
    bookRunner.run();
    userRunner.run();
    borrowRunner.run();
    return ResponseEntity.ok().build();
  }
}
