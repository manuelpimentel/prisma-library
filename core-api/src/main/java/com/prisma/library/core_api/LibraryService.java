package com.prisma.library.core_api;

import java.util.List;

public interface LibraryService {

  void loadBooks(List<BookDTO> books);

  void loadBorrows(List<BorrowDTO> borrows);

  void loadUsers(List<UserDTO> users);

  List<UserDTO> usersWhoBorrowed(PaginationRequestWrapper pagination);
}
