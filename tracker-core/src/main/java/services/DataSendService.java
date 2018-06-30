package services;

import jdev.PointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.client.RestTemplate;

@Service
public class DataSendService {
    @Autowired
    private DataPeekService dataPeekService;
    RestTemplate restTemplate = new RestTemplate();

    @Scheduled(cron = "${cron.prop}")
    public void sendGPStoServer() throws InterruptedException, JsonProcessingException {
        int i = 0;
        for (PointDTO point:dataPeekService.getQueue()) {
            restTemplate.postForObject("http://localhost:8080", point, PointDTO.class);
            i++;
        }
    }
}