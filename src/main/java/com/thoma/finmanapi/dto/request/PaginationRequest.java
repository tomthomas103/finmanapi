package com.thoma.finmanapi.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginationRequest {
    private int number;
    private int size;

}