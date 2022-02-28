package com.prisma.library.core;

import com.prisma.library.core_api.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

  UserDTO toUserDTO(User user);

  User toEntity(UserDTO userDTO);
}
