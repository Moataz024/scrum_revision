package com.moataz.scrum_revision.configuration;

import com.moataz.scrum_revision.entities.Project;
import com.moataz.scrum_revision.entities.Sprint;
import com.moataz.scrum_revision.repos.ProjectRepository;
import com.moataz.scrum_revision.repos.SprintRepository;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Aspect
@Slf4j
@Component
public class ExecutionTimeAspect {

    @Autowired
    SprintRepository sprintRepository;

    @After("execution(void com.moataz.scrum_revision.service.ExamService.*(..))")
    public void afterAjoutReservationExcecution(JoinPoint joinPoint){
       log.info("Method executed : " + joinPoint.getSignature().getName());
    }
    @Scheduled(cron = "*/30 * * * * *")
    public void getProjectsCurrentSprints(){
        List<Sprint> sprints = sprintRepository.findAll();
        sprints.forEach(sprint -> {
            if(sprint.getStartDate().before(new Date())){
                log.info(sprint.getProject().toString());
                log.info(sprint.toString());
            }
        });
    }
}
