package com.thoma.finmanapi.dto.mapper;

import com.thoma.finmanapi.dto.response.UserResponse;
import com.thoma.finmanapi.entity.User;
import com.thoma.finmanapi.dto.request.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User getUserDetailFromReq(UserRequest userRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "username", ignore = true)
    @Mapping(target = "password", ignore = true)
    User getUserDetailForUpdate(UserRequest userRequest);

    UserResponse getUserResponse(User user);

    List<UserResponse> getUserResponse(List<User> user);


}
