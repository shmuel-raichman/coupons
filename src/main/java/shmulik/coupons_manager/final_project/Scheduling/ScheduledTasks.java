// B"H
package shmulik.coupons_manager.final_project.Scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ScheduledTasks {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy' T-'HH:mm:ss");
    private static final String scheduledTime = "0 * * * * ?";

    @Autowired
    static ThreadPoolTaskScheduler scheduler;

//    public void scheduleTaskWithFixedRate() {}
//
//    public void scheduleTaskWithFixedDelay() {}
//
//    public void scheduleTaskWithInitialDelay() {}

    @Scheduled(cron = scheduledTime)
    public void scheduleTaskWithCronExpression() {
        logger.info("Cron Task :: Execution Time - {} ", dateFormatter.format(LocalDateTime.now()) );
        logger.info("Current Thread : {}", Thread.currentThread().getName());
    }
}
