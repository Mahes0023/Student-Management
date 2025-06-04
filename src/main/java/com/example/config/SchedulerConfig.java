package com.example.config;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class SchedulerConfig
{
    @Scheduled(fixedRate = 60000)
    public void printHeartBeat()
    {
        System.out.println("Student service is running...");
    }
}
