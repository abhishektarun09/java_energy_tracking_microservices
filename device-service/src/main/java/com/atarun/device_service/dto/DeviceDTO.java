package com.atarun.device_service.dto;

import com.atarun.device_service.model.DeviceType;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DeviceDTO {
    private Long id;
    private String name;
    private DeviceType type;
    private String location;
    private Long userId;
}
