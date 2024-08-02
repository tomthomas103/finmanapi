package com.thoma.finmanapi.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest extends BaseRequest{
    String username;
    String email;
    String password;
    String name;
    String description;
    String preferences;
}
