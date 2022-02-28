package com.prisma.library.etl;

import com.prisma.library.core_api.BookDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface BookETLMapper {

  BookDTO toDTO(Book book);

}
