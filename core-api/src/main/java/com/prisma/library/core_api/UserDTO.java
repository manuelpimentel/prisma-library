package com.prisma.library.core_api;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserDTO {
  String id;
  String firstName;
  String lastName;
  LocalDate memberSince;
  LocalDate memberTill;
  String gender;
}
