package com.moataz.scrum_revision.controller;


import com.moataz.scrum_revision.entities.Project;
import com.moataz.scrum_revision.entities.Sprint;
import com.moataz.scrum_revision.entities.User;
import com.moataz.scrum_revision.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExamController {

    @Autowired
    ExamService examService;

    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        return examService.addUser(user);
    }


    @PostMapping("/project")
    public Project addProject(@RequestBody Project project) {
        return examService.addProject(project);
    }


    @PutMapping("/dev/{projectId}/{devId}")
    public void assignProjectToDeveloper(@PathVariable("projectId") Integer projectId, @PathVariable("devId") Integer devId) {
        examService.assignProjectToDeveloper(projectId, devId);
    }


    @PutMapping("/sm/{projectId}/{fName}/{lName}")
    public void assignProjectToScrumMaster(@PathVariable("projectId") Integer projectId, @PathVariable("fName") String fName, @PathVariable("lName") String lName) {
        examService.assignProjectToScrumMaster(projectId, fName, lName);
    }

    @GetMapping("/project/{fName}/{lName}")
    public List<Project> getProjectsByScrumMaster(@PathVariable("fName") String fName, @PathVariable("lName") String lName) {
        return examService.getProjectsByScrumMaster(fName, lName);
    }

    @PutMapping("/sprint/{idProject}")
    public void addSprintAndAssignToProject(@RequestBody Sprint sprint, @PathVariable("idProject") int idProject) {
        examService.addSprintAndAssignToProject(sprint, idProject);
    }


}