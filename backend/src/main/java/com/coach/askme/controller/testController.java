package com.coach.askme.controller;

import com.coach.askme.model.Person;
import com.coach.askme.repo.personRepo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "User API")
@RestController
@Controller
@RequestMapping("/test")
public class testController {

    @Autowired
    personRepo personRepo;


    @GetMapping("")
    public List<Person> getPerson(){
//        Person p = new Person();
//        p.setName("hihi");
//        personRepo.insert(p);
        List<Person> list = personRepo.findAll();

        return list;
    }


}
