package com.example.timedtask.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author wh
 * @description 示例：定时任务1
 * @date 2019/4/22
 */
@Component
public class SchedulersTask {

    private int count = 0;
    @Scheduled(cron = "*/6 * * * * ?")
    public void process(){
        System.out.println("this is task running one "+(count++));
    }

}
