package com.prisma.library.core_api;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PaginationRequestWrapper {
  int size;
  int number;
}
