// B"H
package shmulik.coupons_manager.final_project.messages.logs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import shmulik.coupons_manager.final_project.Scheduling.ScheduledTasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logs {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
//    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy' T-'HH:mm:ss");

    public static void logMessage(String logType, String logTitle, String logMsg){
        switch (logType) {
            case "info":  logger.info("{} :: Execution Time - {} ",logTitle , dateTimeFormatter.format(LocalDateTime.now()));
                          logger.info("{} ::  {} ",logTitle , logMsg);
                break;
            case "error": logger.error("{} :: Execution Time - {} ",logTitle , dateTimeFormatter.format(LocalDateTime.now()));
                          logger.info("{} ::  {} ",logTitle , logMsg);
                break;
            case "warn": logger.warn("{} :: Execution Time - {} ",logTitle , dateTimeFormatter.format(LocalDateTime.now()));
                         logger.info("{} ::  {} ",logTitle , logMsg);
                break;
            case "debug": logger.debug("{} :: Execution Time - {} ",logTitle , dateTimeFormatter.format(LocalDateTime.now()));
                          logger.info("{} ::  {} ",logTitle , logMsg);
                break;
        }
    }

    public static void logMessage(String logType, String logTitle){
        switch (logType) {
            case "info":  logger.info("{} :: Execution Time - {} ",logTitle , dateTimeFormatter.format(LocalDateTime.now()));
                break;
            case "error": logger.error("{} :: Execution Time - {} ",logTitle , dateTimeFormatter.format(LocalDateTime.now()));
                break;
            case "warn": logger.warn("{} :: Execution Time - {} ",logTitle , dateTimeFormatter.format(LocalDateTime.now()));
                break;
            case "debug": logger.debug("{} :: Execution Time - {} ",logTitle , dateTimeFormatter.format(LocalDateTime.now()));
                break;
        }
    }
}
