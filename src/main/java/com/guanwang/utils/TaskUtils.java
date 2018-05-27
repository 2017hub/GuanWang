package com.guanwang.utils;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TaskUtils {
    @Scheduled(fixedRate = 2000)
    public void task(){
        Date date=new Date();
        System.out.println(date);
    }
}
