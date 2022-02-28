package com.prisma.library.core;

import org.springframework.data.repository.CrudRepository;

interface UserJPARepository extends CrudRepository<User, String> {}
