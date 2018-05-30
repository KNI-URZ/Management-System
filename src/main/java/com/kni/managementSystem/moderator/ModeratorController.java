package com.kni.managementSystem.moderator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Marcin Mrukowicz on 2018-05-30.
 */
@RestController
public class ModeratorController {

    @Autowired
    private ModeratorRepository moderatorRepository;

    @RequestMapping(method = RequestMethod.POST, path = "/addModerator")
    private Moderator addContributor(@RequestBody Moderator moderator) {
        moderatorRepository.save(moderator);
        return moderator;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/deleteModerator")
    private Moderator deleteContributor(@RequestBody Moderator moderator) {
        moderatorRepository.delete(moderator);
        return moderator;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getAllModerators")
    private List<Moderator> getAllContributors() {
        return (List<Moderator>) moderatorRepository.findAll();
    }

}
