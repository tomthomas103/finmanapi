package com.thoma.finmanapi.mapper;

import org.mapstruct.Mapper;

import com.thoma.finmanapi.entity.DummyEntity;
import com.thoma.finmanapi.request.DummyReq;

@Mapper(componentModel = "spring")
public interface BaseDetailMapper {
	DummyEntity requestToEntity(DummyReq request);

	DummyReq entityToRequest(DummyEntity entity);
}
