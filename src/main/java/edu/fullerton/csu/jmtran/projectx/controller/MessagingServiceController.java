package edu.fullerton.csu.jmtran.projectx.controller;

import edu.fullerton.csu.jmtran.projectx.messaging.service.IMessagingService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessagingServiceController {
    @Autowired
    private List<IMessagingService> services;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/api/v0/messaging-services")
    public List<IMessagingService> getMessagingServices() {
        return this.services;
    }

    public List<IMessagingService> getServices() {
        return services;
    }

    public void setServices(List<IMessagingService> services) {
        this.services = services;
    }
}
