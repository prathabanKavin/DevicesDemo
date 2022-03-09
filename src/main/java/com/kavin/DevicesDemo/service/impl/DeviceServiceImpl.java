package com.kavin.DevicesDemo.service.impl;

import com.kavin.DevicesDemo.model.Device;
import com.kavin.DevicesDemo.repository.DeviceRepository;
import com.kavin.DevicesDemo.service.DeviceService;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceImpl implements DeviceService {

    private DeviceRepository deviceRepository;

    public DeviceServiceImpl(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    @Override
    public Device saveDevice(Device device) {
        return deviceRepository.save(device);
    }
}
