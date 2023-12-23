package com.item.itemmanagementsystem.services;

import com.item.itemmanagementsystem.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User createUser(User user);

    Optional<User> getUserById(String id);
}
