package com.item.itemmanagementsystem.repository;

import com.item.itemmanagementsystem.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
