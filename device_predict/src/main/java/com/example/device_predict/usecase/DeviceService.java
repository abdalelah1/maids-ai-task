package com.example.device_predict.usecase;

import com.example.device_predict.adapters.DeviceRepository;
import com.example.device_predict.adapters.PricePredictionClient;
import com.example.device_predict.domain.Device;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;
    private final PricePredictionClient pricePredictionClient;

    public DeviceService(DeviceRepository deviceRepository, PricePredictionClient pricePredictionClient) {
        this.deviceRepository = deviceRepository;
        this.pricePredictionClient = pricePredictionClient;
    }

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public Optional<Device> getDeviceById(Long id) {
        return deviceRepository.findById(id);
    }

    public Device saveDevice(Device device) {
        return deviceRepository.save(device);
    }

    public Device predictAndSaveDevice(Device device) {
        Map<String, Object> importantFeatures = new HashMap<>();
        importantFeatures.put("ram", device.getRam());
        importantFeatures.put("px_width", device.getPxWidth());
        importantFeatures.put("px_height", device.getPxHeight());
        importantFeatures.put("battery_power", device.getBatteryPower());
        String predictedPrice = pricePredictionClient.predictPrice(importantFeatures);
        device.setPredictedPrice(predictedPrice);
        return deviceRepository.save(device);
    }
}