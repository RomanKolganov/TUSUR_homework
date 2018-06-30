package server.controllers;

import jdev.PointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.services.CreateFileService;

@RestController
public class ServerController {
    private Logger logger = LoggerFactory.getLogger(ServerController.class);
    private long previous;

    @Autowired
    private
    CreateFileService createFileService;

    @RequestMapping(value = "points", method = RequestMethod.POST)
    public @ResponseBody
    PointDTO createPoint(@RequestBody PointDTO point) {
        long current = System.currentTimeMillis();
        logger.info((current - previous) +"AutoId" + point.getAutoId() + " lon = " + point.getLon() + " lat = " + point.getLat());
        createFileService.writeInFile((current - previous) +"AutoId" + point.getAutoId() + " lon = " + point.getLon() + " lat = " + point.getLat());
        return point;
    }
}