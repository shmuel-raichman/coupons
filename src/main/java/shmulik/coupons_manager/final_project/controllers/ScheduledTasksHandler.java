// B"H
package shmulik.coupons_manager.final_project.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shmulik.coupons_manager.final_project.Scheduling.ScheduledTasks;

import java.util.Set;

@RestController
@RequestMapping("/test")
public class ScheduledTasksHandler {

    private static final String SCHEDULED_TASKS = "scheduledTasks";

    @Autowired
    private ScheduledAnnotationBeanPostProcessor postProcessor;

    @Autowired
    private ScheduledTasks scheduledTasks;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping(value = "/stopScheduler")
    public String stopSchedule() {
        postProcessor.postProcessBeforeDestruction(scheduledTasks, SCHEDULED_TASKS);
        return "OK";
    }

    @GetMapping(value = "/startScheduler")
    public String startSchedule() {
        postProcessor.postProcessAfterInitialization(scheduledTasks, SCHEDULED_TASKS);
        return "OK";
    }

    @GetMapping(value = "/listScheduler")
    public String listSchedules() throws JsonProcessingException {
        Set<ScheduledTask> setTasks = postProcessor.getScheduledTasks();
        if (!setTasks.isEmpty()) {
            return objectMapper.writeValueAsString(setTasks);
        } else {
            return "No running tasks !";
        }
    }
}