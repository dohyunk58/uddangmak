package com.uddangmak.smartfan.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class DeviceSettingsUpdateRequest {

    private Boolean powerOn;

    private Integer fanSpeed;

    private Boolean fanRotation;

    private Integer moodlightBrightness;

    private String moodlightColor;

    private Boolean alarmEnabled;

    private LocalTime alarmTime;

    private Boolean sleepModeEnabled;

    private LocalTime sleepModeBeginTime;

    private LocalTime sleepModeEndTime;

    private Integer sleepModeSpeed;

    private Integer sleepModeBrightness;

    private String sleepModeColor;
}
