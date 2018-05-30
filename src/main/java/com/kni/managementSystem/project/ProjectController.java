package com.kni.managementSystem.project;

import com.kni.managementSystem.contributor.Contributor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Marcin Mrukowicz on 2018-01-31.
 */

@RestController
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @RequestMapping(method = RequestMethod.POST, path = "/addProject")
    private Project addProject(@RequestBody Project project) {
        projectRepository.save(project);
        return project;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/deleteProject")
    private Project deleteProject(@RequestBody Project project) {
        projectRepository.delete(project);
        return project;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/getProjectByName")
    private Project getProjectByName(@RequestBody String name) {
        return projectRepository.findOneByName(name);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/getAllProjectsByContributor")
    private List<Project> getAllProjectsByContributor(@RequestBody Contributor contributor){
        return projectRepository.findAllByContributor(contributor);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getAllProjects")
    private List<Project> getAllProjects() {
        return (List<Project>) projectRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getAllArchivedProjects")
    private List<Project> getAllArchivedProjects() {
        return projectRepository.findAllByIsArchived(true);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getAllActiveProjects")
    private List<Project> getAllActiveProjects() {
        return projectRepository.findAllByIsArchived(false);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/archiveProject")
    private Project archiveProject(@RequestBody Project project) {
        project.setArchived(true);
        projectRepository.save(project);
        return project;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/archiveProjects")
    private List<Project> archiveProjects(@RequestBody List<Project> projects) {
        for (Project p : projects) {
            p.setArchived(true);
            projectRepository.save(p);
        }
        return projects;
    }
}
