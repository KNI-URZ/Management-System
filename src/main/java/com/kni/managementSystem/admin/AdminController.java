package com.kni.managementSystem.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Marcin Mrukowicz on 2018-05-30.
 */

@RestController
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @RequestMapping(method = RequestMethod.POST, path = "/addAdmin")
    private void addAdmin(@RequestBody Admin admin) {
        adminRepository.save(admin);
    }

    @RequestMapping(method = RequestMethod.POST, path = "deleteAdmin")
    private void deleteAdmin(@RequestBody Admin admin) {
        adminRepository.delete(admin);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/getAdminById")
    private Admin getAdminById(@RequestBody Long id) {
        return adminRepository.getAdminById(id);
    }

}
