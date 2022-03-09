package com.kavin.DevicesDemo.controller;

import com.kavin.DevicesDemo.model.Device;
import com.kavin.DevicesDemo.service.DeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //build get all devices REST API
    @GetMapping
    public List<Device> getAllDevices(){
        return deviceService.getAllDevices();
    }

    //build get device by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable("id") long id){
        return new ResponseEntity<Device>(deviceService.getDeviceById(id), HttpStatus.OK);
    }
}
