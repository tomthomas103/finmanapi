package com.thoma.finmanapi.request;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseRequest {

    String reqId;
    boolean isActive;
    boolean isDeleted;

    public BaseRequest() {
        if (reqId == null) {
            reqId = UUID.randomUUID().toString();
        }
    }
}
