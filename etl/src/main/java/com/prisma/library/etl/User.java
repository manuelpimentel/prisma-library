package com.prisma.library.etl;

import java.text.SimpleDateFormat;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
class User {

  String firstName;
  String lastName;
  String memberSince;
  String memberTill;
  String gender;

  public String getId() {
    return String.format("%s,%s", this.lastName, this.firstName);
  }
}
