package com.thoma.finmanapi.util;

import com.thoma.finmanapi.dto.request.BaseRequest;
import com.thoma.finmanapi.dto.response.BaseResponse;
import com.thoma.finmanapi.dto.response.PaginationResponse;
import com.thoma.finmanapi.entity.BaseEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public class BasicUtils {

    public static BaseResponse fillBasicResponse(BaseResponse response, BaseEntity entity) {
        response.setId(entity.getId());
        response.setCreatedAt(entity.getCreatedAt());
        response.setModifiedAt(entity.getModifiedAt());
        response.setActive(entity.isActive());
        return response;
    }

    public static BaseEntity fillBasicEntity(BaseEntity document, BaseRequest request) {
        return document;
    }

    public static <T,S>void setPaginationParameters(PaginationResponse<S> response, Page<T> pageData, List<S> data) {
        response.setData(data);
        response.setSize(pageData.getSize());
        response.setPageNumber(pageData.getNumber());
        response.setTotalPages(pageData.getTotalPages());
        response.setNumberOfElements(pageData.getNumberOfElements());
        response.setTotalElements(pageData.getTotalElements());
    }
}
