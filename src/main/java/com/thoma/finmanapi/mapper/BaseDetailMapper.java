package com.thoma.finmanapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.thoma.finmanapi.entity.DummyEntity;
import com.thoma.finmanapi.request.DummyReq;

@Mapper(componentModel = "spring")
public interface BaseDetailMapper {

	BaseDetailMapper INSTANCE = Mappers.getMapper(BaseDetailMapper.class);

	DummyEntity requestToEntity(DummyReq request);

	DummyReq entityToRequest(DummyEntity entity);
}
