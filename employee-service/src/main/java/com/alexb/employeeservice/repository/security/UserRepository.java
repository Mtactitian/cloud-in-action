package com.alexb.employeeservice.repository.security;

import com.alexb.employeeservice.security.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends Repository<User, Integer> {

    @Query(value = "select u from User u join fetch u.roles where u.name = :name")
    Optional<User> getByName(@Param(value = "name") String name);
}