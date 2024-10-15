package com.example.device_predict.adapters;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class PricePredictionClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String pythonApiUrl = "http://127.0.0.1:5000/predict";

    public String predictPrice(Map<String, Object> importantFeatures) {
        try {
            Map<String, Object> response = restTemplate.postForObject(pythonApiUrl, importantFeatures, Map.class);
            return response != null ? response.get("price_range").toString() : null;
        } catch (Exception e) {
            throw new RuntimeException("Failed to predict price", e);
        }
    }
}
