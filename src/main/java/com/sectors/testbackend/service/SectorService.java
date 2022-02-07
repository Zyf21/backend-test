package com.sectors.testbackend.service;

import com.sectors.testbackend.converter.SectorMapper;
import com.sectors.testbackend.dto.SectorDto;
import com.sectors.testbackend.entity.Sector;
import com.sectors.testbackend.exeption.ErrorCodes;
import com.sectors.testbackend.exeption.RestException;
import com.sectors.testbackend.reposiories.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SectorService {

    private final SectorRepository sectorRepository;
    private final SectorMapper sectorMapper;

    @Autowired
    public SectorService(SectorRepository sectorRepository, SectorMapper sectorMapper) {
        this.sectorRepository = sectorRepository;
        this.sectorMapper = sectorMapper;
    }

    public List<SectorDto> findAllSectors() {
        List<Sector> sectors = sectorRepository.findAllByParentNull();
        return sectorMapper.convertToDto(sectors);
    }

    public SectorDto getSectorById(Long sectorId) {
        Sector sector = sectorRepository.findById(sectorId)
                .orElseThrow(() -> new RestException(ErrorCodes.SECTOR_NOT_FOUND));
        return sectorMapper.convertToDto(sector);
    }
}
