package com.study.shedlock.task;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ScheduleTask {

    @Scheduled(cron = "0/30 * * * * ?")
    @SchedulerLock(name = "scheduleTask", lockAtMostFor = "29s", lockAtLeastFor = "29s")
    public void scheduleTask() {
        log.info("Scheduled task is running...");
    }

    @Scheduled(cron = "0/30 * * * * ?")
    @SchedulerLock(name = "scheduleTask", lockAtMostFor = "29s", lockAtLeastFor = "29s")
    public void scheduleTask2() {
        log.info("Scheduled task2 is running...");
    }
}
