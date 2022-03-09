package com.kavin.DevicesDemo.controller;

import com.kavin.DevicesDemo.model.Device;
import com.kavin.DevicesDemo.service.DeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/devices")
public class DeviceController {

    private DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    //build create device REST API
    @PostMapping
    public ResponseEntity<Device> saveDevice(@RequestBody Device device){
        return new ResponseEntity<Device>(deviceService.saveDevice(device), HttpStatus.CREATED);
    }
}
