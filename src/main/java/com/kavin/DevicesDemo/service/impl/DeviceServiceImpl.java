package com.kavin.DevicesDemo.service.impl;

import com.kavin.DevicesDemo.exception.ResourceNotFoundException;
import com.kavin.DevicesDemo.model.Device;
import com.kavin.DevicesDemo.repository.DeviceRepository;
import com.kavin.DevicesDemo.service.DeviceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @Override
    public Device getDeviceById(long id) {
        Optional<Device> device = deviceRepository.findById(id);
        if(device.isPresent()){
            return device.get();
        } else {
            throw new ResourceNotFoundException("Device", "ID", id);
        }

        //return deviceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Device", "ID", id));
    }
}
