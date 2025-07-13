package com.uddangmak.smartfan.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "sensor_data")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SensorData {
    @Id
    private Long id;

    @Column(nullable = false)
    private Float temp;

    @Column(nullable = false)
    private Float humid;

    @Column(nullable = false)
    private Integer brightness;

    @Column(nullable = false)
    private LocalDateTime lastUpdatedAt;

    @PrePersist // Entity 영속화되기 전 실행
    protected void onCreate() {
        this.lastUpdatedAt = LocalDateTime.now();
    }

    @PreUpdate // Entity 업데이트되기 전 실행
    protected void onUpdate() {
        this.lastUpdatedAt = LocalDateTime.now();
    }

    public SensorData(Float temp, Float humid, Integer brightness) {
        this.temp = temp;
        this.humid = humid;
        this.brightness = brightness;
    }
}
