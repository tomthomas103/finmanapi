package com.thoma.finmanapi.dto.response;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PaginationResponse<T> {

    private long totalElements;
    private int totalPages;
    private int size;
    private int pageNumber;
    private int numberOfElements;
    private List<T> data;


}
