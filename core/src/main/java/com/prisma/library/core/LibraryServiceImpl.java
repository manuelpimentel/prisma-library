package com.prisma.library.core;

import static java.util.stream.Collectors.toList;

import com.prisma.library.core_api.BookDTO;
import com.prisma.library.core_api.BorrowDTO;
import com.prisma.library.core_api.LibraryService;
import com.prisma.library.core_api.PaginationRequestWrapper;
import com.prisma.library.core_api.UserDTO;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LibraryServiceImpl implements LibraryService {

  private final BorrowJPARepository borrowJPARepository;
  private final UserJPARepository userJPARepository;
  private final BookJPARepository bookJPARepository;
  private final UserMapper userMapper;
  private final BookMapper bookMapper;
  private final BorrowMapper borrowMapper;

  @Override
  public void loadBooks(List<BookDTO> bookList) {
    if (bookList.stream().anyMatch(book -> Objects.isNull(book.getTitle()))) {
      throw new IllegalArgumentException("Values cannot be null");
    }
    List<Book> books = bookList.stream().map(bookMapper::toEntity).collect(Collectors.toList());
    bookJPARepository.saveAll(books);
  }

  @Override
  public void loadBorrows(List<BorrowDTO> borrowList) {
    boolean idNull =
        borrowList.stream().anyMatch(borrow -> Objects.isNull(borrow.getBook()))
            || borrowList.stream().anyMatch(borrow -> Objects.isNull(borrow.getUser()));
    if (idNull) {
      throw new IllegalArgumentException("Values cannot be null");
    }
    List<Borrow> borrows =
        borrowList.stream().map(borrowMapper::toEntity).collect(Collectors.toList());
    borrowJPARepository.saveAll(borrows);
  }

  @Override
  public void loadUsers(List<UserDTO> userList) {
    if (userList.stream().anyMatch(user -> Objects.isNull(user.getId()))) {
      throw new IllegalArgumentException("Values cannot be null");
    }
    List<User> users = userList.stream().map(userMapper::toEntity).collect(Collectors.toList());
    userJPARepository.saveAll(users);
  }

  @Override
  public List<UserDTO> usersWhoBorrowed(PaginationRequestWrapper pagination) {
    if (pagination.getSize() == 0 || pagination.getNumber() == 0) {
      throw new IllegalArgumentException("Pagination size and/or number cannot be empty");
    }
    return borrowJPARepository
        .findDistinctBorrowers(PageRequest.of(pagination.getNumber(), pagination.getSize()))
        .stream()
        .map(Borrow::getUser)
        .map(userMapper::toUserDTO)
        .collect(toList());
  }
}
