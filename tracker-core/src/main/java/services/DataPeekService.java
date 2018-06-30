package services;

import jdev.PointDTO;
import org.springframework.stereotype.Service;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

@Service
public class DataPeekService {
    private BlockingDeque<PointDTO> queue =  new LinkedBlockingDeque<>(100);
    PointDTO take() throws InterruptedException {
        return queue.take();
    }
    void put(PointDTO newpoint) throws InterruptedException {
        queue.put(newpoint);
    }

    public BlockingDeque<PointDTO> getQueue() {
        return queue;
    }
}