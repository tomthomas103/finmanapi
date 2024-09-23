package com.thoma.finmanapi.dto.response;


import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
public class BaseResponse {

    private Long id;

    private boolean active;

    private ZonedDateTime createdAt;

    private ZonedDateTime modifiedAt;
}
