package com.thoma.finmanapi.exception;

import java.util.Date;

public class ResourceNotFoundException  extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
