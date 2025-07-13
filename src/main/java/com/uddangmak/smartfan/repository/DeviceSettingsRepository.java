package com.uddangmak.smartfan.repository;

import com.uddangmak.smartfan.entity.DeviceSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceSettingsRepository extends JpaRepository<DeviceSettings, Long> {
}
