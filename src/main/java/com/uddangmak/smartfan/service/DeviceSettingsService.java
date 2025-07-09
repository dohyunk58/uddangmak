package com.uddangmak.smartfan.service;

import com.uddangmak.smartfan.dto.DeviceSettingsUpdateRequest;
import com.uddangmak.smartfan.entity.DeviceSettings;
import com.uddangmak.smartfan.repository.DeviceSettingsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DeviceSettingsService {
    private final DeviceSettingsRepository deviceSettingsRepository;

    public DeviceSettingsService(DeviceSettingsRepository deviceSettingsRepository) {
        this.deviceSettingsRepository = deviceSettingsRepository;
    }

    public Optional<DeviceSettings> findById(Long id) {
        return deviceSettingsRepository.findById(id);
    }

    // 설정 업데이트
    @Transactional
    public DeviceSettings updateDeviceSettings(Long id, DeviceSettingsUpdateRequest request) {
        DeviceSettings existingSettings = deviceSettingsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Device settings with id " + id + " does not exist"));

        // 부분 업데이트
        if (request.getPowerOn() != null) {
            existingSettings.setPowerOn(request.getPowerOn());
        }
        if (request.getFanSpeed() != null) {
            existingSettings.setFanSpeed(request.getFanSpeed());
        }
        if (request.getFanRotation() != null) {
            existingSettings.setFanRotation(request.getFanRotation());
        }
        if (request.getMoodlightBrightness() != null) {
            existingSettings.setMoodlightBrightness(request.getMoodlightBrightness());
        }
        if (request.getMoodlightColor() != null) {
            existingSettings.setMoodlightColor(request.getMoodlightColor());
        }
        if (request.getAlarmEnabled() != null) {
            existingSettings.setAlarmEnabled(request.getAlarmEnabled());
        }
        if (request.getAlarmTime() != null) {
            existingSettings.setAlarmTime(request.getAlarmTime());
        }
        if (request.getSleepModeEnabled() != null) {
            existingSettings.setSleepModeEnabled(request.getSleepModeEnabled());
        }
        if (request.getSleepModeBeginTime() != null) {
            existingSettings.setSleepModeBeginTime(request.getSleepModeBeginTime());
        }
        if (request.getSleepModeEndTime() != null) {
            existingSettings.setSleepModeEndTime(request.getSleepModeEndTime());
        }
        if (request.getSleepModeSpeed() != null) {
            existingSettings.setSleepModeSpeed(request.getSleepModeSpeed());
        }
        if (request.getSleepModeBrightness() != null) {
            existingSettings.setSleepModeBrightness(request.getSleepModeBrightness());
        }
        if (request.getSleepModeColor() != null) {
            existingSettings.setSleepModeColor(request.getSleepModeColor());
        }

        return deviceSettingsRepository.save(existingSettings);
    }
}
