CREATE TABLE IF NOT EXISTS device_settings (
    id INT AUTO_INCREMENT PRIMARY KEY,
    power_on BOOLEAN NOT NULL DEFAULT FALSE,
    fan_speed INT NOT NULL  DEFAULT 0,
    fan_rotation BOOLEAN NOT NULL  DEFAULT FALSE,
    moodlight_brightness INT NOT NULL DEFAULT 0,
    moodlight_color VARCHAR(255) NOT NULL DEFAULT '0,0,0',
    alarm_enabled BOOLEAN NOT NULL DEFAULT FALSE,
    alarm_time TIME,
    sleep_mode_enabled BOOLEAN NOT NULL DEFAULT FALSE,
    sleep_mode_begin_time TIME,
    sleep_mode_end_time TIME,
    sleep_mode_speed INT,
    sleep_mode_brightness INT,
    sleep_mode_color VARCHAR(255),
    last_updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS sensor_data (
    id INT PRIMARY KEY,
    temp REAL NOT NULL DEFAULT 0.0,
    humid REAL NOT NULL DEFAULT 0.0,
    brightness INT NOT NULL DEFAULT 0,
    last_updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO device_settings (
    id,
    power_on,
    fan_speed,
    fan_rotation,
    moodlight_brightness,
    moodlight_color,
    alarm_enabled,
    alarm_time,
    sleep_mode_enabled,
    sleep_mode_begin_time,
    sleep_mode_end_time,
    sleep_mode_speed,
    sleep_mode_brightness,
    sleep_mode_color
) VALUES (
    1,
    FALSE,
    0,
    FALSE,
    0,
    '0,0,0',
    FALSE,
    NULL,
    FALSE,
    NULL,
    NULL,
    NULL,
    NULL,
    NULL
);

INSERT INTO sensor_data (
    id,
    temp,
    humid,
    brightness
) VALUES (
    1,
    0.0,
    0.0,
    0
);