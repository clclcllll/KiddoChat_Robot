package com.example.app.controller;

import com.example.app.entity.Device;
import com.example.app.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/device")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @PostMapping("/add")
    public Device addDevice(@RequestBody Device device) {
        return deviceService.addDevice(device);
    }

    @PostMapping("/update")
    public Device updateDevice(@RequestBody Device device) {
        return deviceService.updateDevice(device);
    }

    @PostMapping("/delete")
    public void deleteDevice(@RequestParam Long deviceId) {
        deviceService.deleteDevice(deviceId);
    }

    @GetMapping("/list")
    public List<Device> listDevices(@RequestParam Long userId) {
        return deviceService.listDevices(userId);
    }
}
