package com.sectors.testbackend.converter;

import com.sectors.testbackend.dto.RecordDto;
import com.sectors.testbackend.entity.Record;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RecordMapper {

    Record updateEntityByDto(@MappingTarget Record entity, RecordDto recordDto);

    Record convertToEntity(RecordDto request);
}
