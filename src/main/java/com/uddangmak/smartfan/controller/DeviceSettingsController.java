package com.uddangmak.smartfan.controller;

import com.uddangmak.smartfan.dto.DeviceSettingsUpdateRequest;
import com.uddangmak.smartfan.entity.DeviceSettings;
import com.uddangmak.smartfan.service.DeviceSettingsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class DeviceSettingsController {
    private final DeviceSettingsService deviceSettingsService;

    public DeviceSettingsController(DeviceSettingsService deviceSettingsService) {
        this.deviceSettingsService = deviceSettingsService;
    }

    // 설정 파일 불러오기
    // GET /api/settings
    @GetMapping("/settings")
    public ResponseEntity<DeviceSettings> getSettings() {
        Long settingsId = 1L;
        return deviceSettingsService.findById(settingsId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 설정 파일 수정
    // POST /api/settings
    @PostMapping("/settings")
    public ResponseEntity<Map<String, Object>> updateSettings(@Valid @RequestBody DeviceSettingsUpdateRequest request) {
        try {
            Long settingsIdToUpdate = 1L; // 1로 고정
            DeviceSettings updatedSettings = deviceSettingsService.updateDeviceSettings(settingsIdToUpdate, request);

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Settings updated successfully");
            response.put("data", updatedSettings);

            return ResponseEntity.ok(response);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("message", "An error occurred: " + e.getMessage()));
        }
    }
}
