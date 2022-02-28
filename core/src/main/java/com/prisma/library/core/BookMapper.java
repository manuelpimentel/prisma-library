package com.prisma.library.core;

import com.prisma.library.core_api.BookDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
  Book toEntity(BookDTO bookDTO);
}
