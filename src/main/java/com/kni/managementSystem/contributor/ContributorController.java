package com.kni.managementSystem.contributor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Marcin Mrukowicz on 2018-01-31.
 */

@RestController
public class ContributorController {

    @Autowired
    ContributorRepository contributorRepository;

    @RequestMapping(method = RequestMethod.POST, path = "/addContributor")
    private Contributor addContributor(@RequestBody Contributor contributor) {
        contributorRepository.save(contributor);
        return contributor;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/deleteContributor")
    private Contributor deleteContributor(@RequestBody Contributor contributor) {
        contributorRepository.delete(contributor);
        return contributor;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/getAllContributors")
    private List<Contributor> getAllContributors() {
        return (List<Contributor>) contributorRepository.findAll();
    }
}
