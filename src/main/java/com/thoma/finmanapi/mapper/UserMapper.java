package com.thoma.finmanapi.mapper;

import com.thoma.finmanapi.entity.User;
import com.thoma.finmanapi.dto.request.UserRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User getUserDetailFromReq(UserRequest userRequest);

}
