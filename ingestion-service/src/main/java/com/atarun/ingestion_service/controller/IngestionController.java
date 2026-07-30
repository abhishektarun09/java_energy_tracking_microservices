package com.atarun.ingestion_service.controller;

import com.atarun.ingestion_service.dto.EnergyUsageDTO;
import com.atarun.ingestion_service.service.IngestionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ingestion")
public class IngestionController {
    private final IngestionService ingestionService;

    public IngestionController(IngestionService ingestionService) {
        this.ingestionService = ingestionService;
    }

    @PostMapping
    @ResponseStatus(org.springframework.http.HttpStatus.CREATED)
    public void ingestData(@RequestBody EnergyUsageDTO usageDto) {
        ingestionService.ingestEnergyUsage(usageDto);
    }
}
