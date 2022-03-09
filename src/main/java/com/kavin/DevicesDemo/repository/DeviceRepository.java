package com.kavin.DevicesDemo.repository;

import com.kavin.DevicesDemo.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository <Device, Long> {
}
