package com.prisma.library.core_api;

import com.prisma.library.core_api.BookDTO;
import com.prisma.library.core_api.BorrowDTO;
import com.prisma.library.core_api.UserDTO;
import java.util.List;
import lombok.Value;

@Value
public class LibraryWrapper {

  List<UserDTO> users;
  List<BookDTO> books;
  List<BorrowDTO> borrows;
}
