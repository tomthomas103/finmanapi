package com.thoma.finmanapi.request;

import java.util.Random;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseRequest {

    Long id;
    boolean isActive;

    public BaseRequest() {
        if (id == null) {
            id = new Random().nextLong();
        }
    }
}
