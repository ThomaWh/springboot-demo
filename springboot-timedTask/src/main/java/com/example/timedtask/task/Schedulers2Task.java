package com.example.timedtask.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wh
 * @description 示例：定时任务2
 * @date 2019/4/22
 */
@Component
public class Schedulers2Task {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 6000)
    public void reportCurrentTime(){
        System.out.println("Nwo Time :"+SIMPLE_DATE_FORMAT.format(new Date()));
    }
}
