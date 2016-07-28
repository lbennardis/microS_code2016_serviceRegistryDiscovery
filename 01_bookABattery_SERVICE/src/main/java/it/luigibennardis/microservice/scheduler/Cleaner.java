package it.luigibennardis.microservice.scheduler;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Cleaner {

    private static final SimpleDateFormat dateFormat = 
        new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

    @Scheduled(fixedRate = 50000)
    public void sendMailToCustomers() {

        System.out.println("sendMailToCustomers Job ran at " 
            + dateFormat.format(new Date()));

    }
}