package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GPSService {
    double latitude = 52.02782;
    double longitude = 47.80070;
    double azimuth = 174.0;
    double instaSpeed = 25.0;

    @Autowired
    private DataPeekService dataPeekService;
}
