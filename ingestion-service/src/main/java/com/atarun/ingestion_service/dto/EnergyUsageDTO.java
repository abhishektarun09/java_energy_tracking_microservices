package com.atarun.ingestion_service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.Instant;

@Builder
public record EnergyUsageDTO(
    Long deviceId,
    double energyConsumed,
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    Instant timestamp)
{}
