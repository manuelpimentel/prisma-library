package com.prisma.library.etl;

import com.prisma.library.core_api.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
interface UserETLMapper {

  @Mapping(
      target = "memberSince",
      dateFormat = "MM/dd/yyyy",
      nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  @Mapping(
      target = "memberTill",
      dateFormat = "MM/dd/yyyy",
      nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  UserDTO toDTO(User user);
}
