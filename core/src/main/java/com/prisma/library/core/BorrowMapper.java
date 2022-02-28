package com.prisma.library.core;

import com.prisma.library.core_api.BorrowDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BorrowMapper {
  @Mapping(source = "user", target = "user.id")
  @Mapping(source = "book", target = "book.title")
  @Mapping(target = "id", ignore = true)
  Borrow toEntity(BorrowDTO borrowDTO);
}
