package com.kavin.DevicesDemo.service;

import com.kavin.DevicesDemo.model.Device;

import java.util.List;

public interface DeviceService {
    Device saveDevice(Device device);
    List<Device> getAllDevices();
    Device getDeviceById(long id);
}
