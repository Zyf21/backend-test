package com.sectors.testbackend.controller;

import com.sectors.testbackend.dto.RecordDto;
import com.sectors.testbackend.entity.Record;
import com.sectors.testbackend.service.RecordService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/records")
public class RecordController {

    private final RecordService recordService;

    @Autowired
    public RecordController(final RecordService recordService) {
        this.recordService = recordService;
    }

    @PostMapping
    @Operation(summary = "Save new record")
    public void saveRecord(@RequestBody RecordDto recordDto) {
        recordService.saveRecord(recordDto);;
    }

    @PutMapping("/{recordId}")
    @Operation(summary = "Update record by id")
    public void updateRecord(@RequestBody RecordDto recordDto, @PathVariable Long recordId) {
        recordService.updateRecord(recordDto, recordId);
    }
}
