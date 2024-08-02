package com.thoma.finmanapi.service.impl;


import com.thoma.finmanapi.entity.User;
import com.thoma.finmanapi.mapper.UserMapper;
import com.thoma.finmanapi.repository.UserRepository;
import com.thoma.finmanapi.dto.request.UserRequest;
import com.thoma.finmanapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    UserMapper userMapper;

    @Override
    public User createUser(UserRequest userRequest){
        User user = userMapper.getUserDetailFromReq(userRequest);
        return  userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User findUser(User reqData) {
        return userRepo.findById(reqData.getId()).orElseThrow(NullPointerException::new);
    }

    @Override
    public User findByUsername(String username){
        return userRepo.findByUsername(username);
    }

    @Override
    public User  deleteUserById(Long id) {
        userRepo.deleteById(id);
        return null;
    }
}
