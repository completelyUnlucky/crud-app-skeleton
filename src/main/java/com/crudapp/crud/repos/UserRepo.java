package com.crudapp.crud.repos;

import com.crudapp.crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
