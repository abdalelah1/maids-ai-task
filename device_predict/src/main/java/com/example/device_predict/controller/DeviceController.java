package com.example.device_predict.controller;


import com.example.device_predict.domain.Device;
import com.example.device_predict.usecase.DeviceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    private final DeviceService deviceService;

    public DeviceController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    // Retrieve a list of all devices
    @GetMapping
    public ResponseEntity<List<Device>> getAllDevices() {
        return ResponseEntity.ok(deviceService.getAllDevices());
    }

    // Retrieve details of a specific device by ID
    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long id) {
        Optional<Device> device = deviceService.getDeviceById(id);
        return device.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add a new device
    @PostMapping
    public ResponseEntity<Device> addDevice(@RequestBody Device device) {
        Device savedDevice = deviceService.saveDevice(device);
        return ResponseEntity.ok(savedDevice);
    }

    // Predict the price and save it
    @PostMapping("/predict/{deviceId}")
    public ResponseEntity<Device> predictPriceForDevice(@PathVariable Long deviceId) {
        Optional<Device> deviceOptional = deviceService.getDeviceById(deviceId);
        if (deviceOptional.isPresent()) {
            Device device = deviceOptional.get();
            Device updatedDevice = deviceService.predictAndSaveDevice(device);
            return ResponseEntity.ok(updatedDevice);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}