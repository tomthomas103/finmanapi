package com.thoma.finmanapi.service;

import com.thoma.finmanapi.entity.User;
import com.thoma.finmanapi.dto.request.UserRequest;

import java.util.List;

public interface UserService {

    User createUser(UserRequest userRequest);

    List<User> getAllUsers();

    User findUser(User reqData);

    User findByUsername(String username);

    User  deleteUserById(Long id);
}
