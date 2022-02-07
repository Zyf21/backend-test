package com.sectors.testbackend.converter;


import com.sectors.testbackend.dto.SectorDto;
import com.sectors.testbackend.entity.Sector;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SectorMapper {

    List<SectorDto> convertToDto(List<Sector> sectors);

    @Mapping(target = "parentId", source = "parent.id")
    SectorDto convertToDto(Sector sector);

}
