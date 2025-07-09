package com.uddangmak.smartfan.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "device_settings")
@Getter
@Setter
@NoArgsConstructor
public class DeviceSettings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "device_id", nullable = false, length = 255)
    private String deviceId;

    @Column(name = "power_on", nullable = false)
    private boolean powerOn;

    @Column(name = "fan_speed", nullable = false)
    private int fanSpeed;

    @Column(name = "fan_rotation", nullable = false)
    private boolean fanRotation;

    @Column(name = "moodlight_brightness", nullable = false)
    private int moodlightBrightness;

    @Column(name = "moodlight_color", nullable = false, length = 11) // 0,0,0 ~ 255,255,255의 RGB형식
    private String moodlightColor;

    @Column(name = "alarm_enabled", nullable = false)
    private boolean alarmEnabled;

    @Column(name = "alarm_time")
    private LocalTime alarmTime;

    @Column(name = "sleep_mode_enabled", nullable = false)
    private boolean sleepModeEnabled;

    @Column(name = "sleep_mode_begin_time")
    private LocalTime sleepModeBeginTime;

    @Column(name = "sleep_mode_end_time")
    private LocalTime sleepModeEndTime;

    @Column(name = "sleep_mode_speed")
    private Integer sleepModeSpeed;

    @Column(name = "sleep_mode_brightness")
    private Integer sleepModeBrightness;

    @Column(name = "sleep_mode_color", length = 11)
    private String sleepModeColor;

    @Column(name = "last_updated_at", nullable = false)
    private LocalDateTime lastUpdatedAt;
}
