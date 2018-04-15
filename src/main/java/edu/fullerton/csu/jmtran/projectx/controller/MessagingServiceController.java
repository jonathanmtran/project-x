package edu.fullerton.csu.jmtran.projectx.controller;

import edu.fullerton.csu.jmtran.projectx.messaging.service.IMessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessagingServiceController {
    @Autowired
    private List<IMessagingService> services;

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
