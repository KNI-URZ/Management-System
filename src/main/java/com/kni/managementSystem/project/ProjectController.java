package com.kni.managementSystem.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
