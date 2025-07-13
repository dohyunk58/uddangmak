package com.uddangmak.smartfan.service;

import com.uddangmak.smartfan.dto.SensorDataDto;
import com.uddangmak.smartfan.entity.SensorData;
import com.uddangmak.smartfan.repository.SensorDataRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class SensorDataService {
    private final SensorDataRepository sensorDataRepository;

    public SensorDataService(SensorDataRepository sensorDataRepository) {
        this.sensorDataRepository = sensorDataRepository;
    }

    public void saveSensorData(SensorDataDto sensorDataDto) {
        Optional<SensorData> existingSensorData = sensorDataRepository.findById(1L);

        SensorData sensorData;
        if (existingSensorData.isPresent()) {
            sensorData = existingSensorData.get();
            sensorData.setTemp(sensorDataDto.getTemp());
            sensorData.setHumid(sensorDataDto.getHumid());
            sensorData.setBrightness(sensorDataDto.getBrightness());
        } else {
            // 기존 데이터가 없으면 새로 생성
            sensorData = new SensorData(
                sensorDataDto.getTemp(),
                sensorDataDto.getHumid(),
                sensorDataDto.getBrightness()
            );
            sensorData.setId(1L); // 명시적으로 ID를 1로 설정
        }
        sensorDataRepository.save(sensorData);
    }

    @Transactional(readOnly = true)
    public List<SensorDataDto> getAllSensorData() {
        return sensorDataRepository.findAll()
            .stream()
            .map(sensorData -> new SensorDataDto(
                sensorData.getTemp(),
                sensorData.getHumid(),
                sensorData.getBrightness()
            ))
            .collect(Collectors.toList());
    }
}
