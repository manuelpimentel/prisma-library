package com.prisma.library.etl;

import com.prisma.library.core_api.BorrowDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
interface BorrowETLMapper {

  @Mapping(source = "borrower", target = "user")
  @Mapping(
      target = "to",
      dateFormat = "MM/dd/yyyy",
      nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  @Mapping(
      target = "from",
      dateFormat = "MM/dd/yyyy",
      nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  BorrowDTO toDTO(Borrow borrow);
}
