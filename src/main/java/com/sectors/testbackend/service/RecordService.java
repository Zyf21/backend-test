package com.sectors.testbackend.service;

import com.sectors.testbackend.converter.RecordMapper;
import com.sectors.testbackend.entity.Record;
import com.sectors.testbackend.dto.RecordDto;
import com.sectors.testbackend.exeption.ErrorCodes;
import com.sectors.testbackend.exeption.RestException;
import com.sectors.testbackend.reposiories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecordService {

    private final RecordRepository recordRepository;
    private final RecordMapper recordMapper;

    @Autowired
    public RecordService(final RecordRepository recordRepository,
                         final RecordMapper recordMapper) {
        this.recordRepository = recordRepository;
        this.recordMapper = recordMapper;
    }

    public void saveRecord(RecordDto recordDto) {
        Record record = recordMapper.convertToEntity(recordDto);
        recordRepository.save(record);
    }

    public void updateRecord(RecordDto recordDto, Long recordId) {
        Record recordFromDB = recordRepository.findById(recordId)
                .orElseThrow(() -> new RestException(ErrorCodes.RECORD_NOT_FOUND));
        recordRepository.save(recordMapper.updateEntityByDto(recordFromDB, recordDto));
    }
}
