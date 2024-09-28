package com.thoma.finmanapi.service.impl;


import com.thoma.finmanapi.dto.response.UserResponse;
import com.thoma.finmanapi.entity.User;
import com.thoma.finmanapi.exception.ResourceNotFoundException;
import com.thoma.finmanapi.dto.mapper.UserMapper;
import com.thoma.finmanapi.repository.UserRepository;
import com.thoma.finmanapi.dto.request.UserRequest;
import com.thoma.finmanapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    UserMapper userMapper;

    /**
     * Create a new user in the system.
     *
     * @param userRequest details of the new user
     * @return the newly created user
     */
    @Override
    public User createUser(UserRequest userRequest) {
        User user = userMapper.getUserDetailFromReq(userRequest);
        return userRepo.save(user);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userMapper.getUserResponse(userRepo.findAll());
    }

    @Override
    public UserResponse updateUser(UserRequest userRequest) {
        User userOrg = findUser(userRequest.getUserId());
        User userReplica= userMapper.getUserDetailForUpdate(userRequest);

        if(!userReplica.getName().isBlank()){
            userOrg.setName(userReplica.getName());
        }
        if(!userReplica.getDescription().isBlank()){
            userOrg.setDescription(userReplica.getDescription());
        }
        if(!userReplica.getPreferences().isBlank()){
            userOrg.setPreferences(userReplica.getPreferences());
        }
        User userSave = userRepo.save(userOrg);
        return userMapper.getUserResponse(userSave);
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
