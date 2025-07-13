package com.uddangmak.smartfan.controller;

import com.uddangmak.smartfan.dto.SensorDataDto;
import com.uddangmak.smartfan.service.SensorDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensor")
public class SensorDataController {
    private final SensorDataService sensorDataService;

    public SensorDataController(SensorDataService sensorDataService) {
        this.sensorDataService = sensorDataService;
    }

    @PostMapping
    public ResponseEntity<String> receiveSensorData(@RequestBody SensorDataDto sensorDataDto) {
        // 센서 데이터 저장
        sensorDataService.saveSensorData(sensorDataDto);

        // 응답 반환
        return new ResponseEntity<>("Sensor data received and saved successfully", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SensorDataDto>> getAllSensorData() {
        List<SensorDataDto> allData = sensorDataService.getAllSensorData();

        if (allData.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(allData);
    }
}
