package services;

import jdev.PointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class GPSService {
    private double lat = 52.0278200;
    private double lon = 47.8007000;
    private double Speed = 25.0;
    private String autoID = "A037MP64";
    private double azimuth = 155.0;

    @Autowired
    private DataPeekService dataPeekService;

    @PostConstruct
    @Scheduled(cron = "${cron.prop}")
    private void init() throws Exception{
        dataPeekService.put(getGPS());
    }

    public PointDTO getGPS() {
        PointDTO point = new PointDTO();
        point.setLat(this.lat);
        point.setLon(this.lon);
        point.setSpeed(this.Speed);
        point.setAutoId(this.autoID);
        point.setAzimuth(this.azimuth);
        point.setTime(System.currentTimeMillis());
        lat = lat + 0.01;
        lon = lon + 0.01;
        return point;
    }
}

