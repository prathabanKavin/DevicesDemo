package com.kavin.DevicesDemo.controller;

import com.kavin.DevicesDemo.model.Device;
import com.kavin.DevicesDemo.service.DeviceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/devices/")
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

    //build update device by id REST API
    @PutMapping("{id}")
    public ResponseEntity<Device> updateDevice(@PathVariable("id") long id, @RequestBody Device device){
        return new ResponseEntity<Device>(deviceService.updateDevice(device, id), HttpStatus.OK);
    }

    //build delete employee by id REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDevice(@PathVariable("id") long id){
        deviceService.deleteDevice(id);
        return new ResponseEntity<String>("Device deleted successfully!", HttpStatus.OK);
    }
}
