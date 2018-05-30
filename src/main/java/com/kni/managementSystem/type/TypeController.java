package com.kni.managementSystem.type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Marcin Mrukowicz on 2018-03-10.
 */

@RestController
public class TypeController {
    @Autowired
    TypeRepository typeRepository;

    @RequestMapping(method = RequestMethod.POST, path = "/addType")
    private Type addType(@RequestBody Type type) {
        typeRepository.save(type);
        return type;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/deleteType")
    private Type deleteType(@RequestBody Type type) {
        typeRepository.delete(type);
        return type;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/getAllTypes")
    private List<Type> getAllTypes() {
        return (List<Type>) typeRepository.findAll();
    }


}
