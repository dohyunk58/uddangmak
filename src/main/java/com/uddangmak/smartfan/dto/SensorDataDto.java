package com.uddangmak.smartfan.dto;

import com.uddangmak.smartfan.entity.SensorData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SensorDataDto {
    private Float temp;
    private Float humid;
    private Integer brightness;

    public SensorDataDto(SensorData sensorData) {
        this.temp = sensorData.getTemp();
        this.humid = sensorData.getHumid();
        this.brightness = sensorData.getBrightness();
    }
}
