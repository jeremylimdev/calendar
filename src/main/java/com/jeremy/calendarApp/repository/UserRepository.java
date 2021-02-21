package com.jeremy.calendarApp.repository;

import com.jeremy.calendarApp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}

