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

    @Override
    public Device updateDevice(Device device, long id) {
        //we need to check whether device with given id is existing or not in a database

        Device device2 = deviceRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Device", "Id", id));
        device2.setName(device.getName());
        device2.setStatus(device.getStatus());
        device2.setModel(device.getModel());
        device2.setEnrolledTime(device.getEnrolledTime());

        //save existing device to DB
        deviceRepository.save(device2);
        return device2;
    }

    @Override
    public void deleteDevice(long id) {
        //check whether a device with given id is existing or not in a database
        deviceRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Device", "Id", id));
        deviceRepository.deleteById(id);
    }


}
