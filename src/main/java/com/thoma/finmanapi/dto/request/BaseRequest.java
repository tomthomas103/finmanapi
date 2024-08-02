package com.thoma.finmanapi.dto.request;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseRequest {

    String reqId;

    public BaseRequest() {
        if (reqId == null) {
            reqId = UUID.randomUUID().toString();
        }
    }
}
