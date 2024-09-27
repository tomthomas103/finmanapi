package com.thoma.finmanapi.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponse extends BaseResponse {
    String username;
    String email;
    String password;
    String name;
    String description;
    String preferences;
    private List<AccountResponse> accounts;
}
