package services;

import models.Project;

public interface IProjectService {
    public Project addProject(Project project);
    int getProjectByInvalidId(int projectID);


}
