package services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class DataSendService {
    @Autowired
    private DataPeekService dataPeekService;
    private static final Logger log = LoggerFactory.getLogger(DataSendService.class);
    private long previous;

    @Scheduled(cron = "${cron.prop}")
    public void sendGPStoServer() throws InterruptedException, JsonProcessingException {
        long current = System.currentTimeMillis();
        log.info((current - previous) + dataPeekService.take().toJson());
        previous = current;
    }
}
