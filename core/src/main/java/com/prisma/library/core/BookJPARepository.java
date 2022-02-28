package com.prisma.library.core;

import org.springframework.data.repository.CrudRepository;

interface BookJPARepository extends CrudRepository<Book, String> {}
