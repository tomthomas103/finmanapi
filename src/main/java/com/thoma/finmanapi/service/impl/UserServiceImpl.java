package com.thoma.finmanapi.service.impl;


import com.thoma.finmanapi.entity.User;
import com.thoma.finmanapi.exception.ResourceNotFoundException;
import com.thoma.finmanapi.mapper.UserMapper;
import com.thoma.finmanapi.repository.UserRepository;
import com.thoma.finmanapi.dto.request.UserRequest;
import com.thoma.finmanapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    UserMapper userMapper;

    @Override
    public User createUser(UserRequest userRequest) {
        User user = userMapper.getUserDetailFromReq(userRequest);
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User findUser(Long id) {
        return userRepo.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("User not found with id = " + id));
    }

    @Override
    public User findUserByUsername(String username) {
       return findByUsername(username);
    }

    @Override
    public Boolean deleteUser(String username) {
        User user = findByUsername(username);
        user.setDeleted(true);
        userRepo.save(user);
        return true;
    }

    private User findByUsername(String username){
        return  Optional.ofNullable(userRepo.findByUsername(username)).orElseThrow(()
                -> new ResourceNotFoundException("User not found with username = " + username));
    }

}
