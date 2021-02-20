package com.jeremy.calendar.repository;

import com.jeremy.calendar.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Integer> {
}
