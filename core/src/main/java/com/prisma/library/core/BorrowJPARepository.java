package com.prisma.library.core;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

interface BorrowJPARepository extends PagingAndSortingRepository<Borrow, String> {

  @Query(value = "SELECT b.* FROM borrow b", nativeQuery = true)
  List<Borrow> findDistinctBorrowers(Pageable pageable);
}
