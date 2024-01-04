package com.moataz.scrum_revision.service;


import com.moataz.scrum_revision.entities.Project;
import com.moataz.scrum_revision.entities.Sprint;
import com.moataz.scrum_revision.entities.User;

import java.util.List;

public interface IExamService {
    User addUser(User user);

    Project addProject(Project project);

    void assignProjectToDeveloper(int projectId, int devId);

    void assignProjectToScrumMaster(int projectId, String fName, String lName);

    List<Project> getProjectsByScrumMaster(String fName, String lName);

    void addSprintAndAssignToProject(Sprint sprint, int idProject);
}
