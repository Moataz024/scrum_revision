package com.moataz.scrum_revision.service;


import com.moataz.scrum_revision.entities.Project;
import com.moataz.scrum_revision.entities.Sprint;
import com.moataz.scrum_revision.entities.User;
import com.moataz.scrum_revision.repos.ProjectRepository;
import com.moataz.scrum_revision.repos.SprintRepository;
import com.moataz.scrum_revision.repos.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ExamService implements IExamService{

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    SprintRepository sprintRepository;
    @Autowired
    UserRepository userRepository;


    @Override
    public User addUser(User user){
        return userRepository.save(user);
    }


    @Override
    public Project addProject(Project project){
        sprintRepository.saveAll(project.getSprints());
        Project saved = projectRepository.save(project);
        project.getSprints().forEach(sprint -> {
            sprint.setProject(saved);
            sprintRepository.save(sprint);
        });
        return projectRepository.save(project);
    }


    @Override
    public void assignProjectToDeveloper(int projectId, int devId){
        Project p = projectRepository.findById(projectId).get();
        User u = userRepository.findById(devId).get();
        List<Project> projectList = new ArrayList<>();
        List<User> userList = new ArrayList<>();
        projectList.addAll(u.getDev_projects());
        userList.addAll(p.getUsers());
        projectList.add(p);
        userList.add(u);
        u.setDev_projects(projectList);
        p.setUsers(userList);
        projectRepository.save(p);
        userRepository.save(u);
    }


    @Override
    public void assignProjectToScrumMaster(int projectId, String fName, String lName){
        User u = userRepository.findUserByFNameAndLName(fName,lName);
        Project p = projectRepository.findById(projectId).get();
        p.setUser(u);
        List<Project> projects = new ArrayList<>(u.getSm_projects());
        projects.add(p);
        u.setSm_projects(projects);
        projectRepository.save(p);
        userRepository.save(u);
    }


    @Override
    public List<Project> getProjectsByScrumMaster(String fName, String lName){
        return projectRepository.findAllByUser(fName,lName);
    }


    @Override
    public void addSprintAndAssignToProject(Sprint sprint, int idProject){
        Project p = projectRepository.findById(idProject).get();
        List<Sprint> sprints = new ArrayList<>(p.getSprints());
        sprint.setProject(p);
        sprintRepository.save(sprint);
        sprints.add(sprint);
        projectRepository.save(p);
    }









}
