package com.spring.assignment.Sept.SpringAssignment30Sept.controller;


import com.spring.assignment.Sept.SpringAssignment30Sept.entity.Courses;
import com.spring.assignment.Sept.SpringAssignment30Sept.entity.Learners;
import com.spring.assignment.Sept.SpringAssignment30Sept.service.CoursesService;
import com.spring.assignment.Sept.SpringAssignment30Sept.service.LearnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/learners")
public class LearnersController {

    @Autowired
    LearnersService lservice;

    @Autowired
    CoursesService cservice;


    // 1.save
    @PostMapping("/addLearner")
    public Learners addLearner(@RequestBody Learners learner){
        return lservice.addLearner(learner);
    }

    // 2.getbyid
    @GetMapping("/getLearnerById/{learner_id}")
    public Learners getLearnerById(@PathVariable int learner_id){
        return lservice.getLearnerById(learner_id);
    }

    // 3.returnAllLearners (use default path /learners)
    @GetMapping
    public List<Learners> getAllLearners(){
        return lservice.getAllLearners();
    }

    // 4.returnNumberOfLearners
    @GetMapping("/getTotalLearners")
    public int getTotalLearners(){
        return lservice.countLearners();
    }

    // 5.deletelearnerbyid
    @DeleteMapping("/deleteLearner/{learner_id}")
    public void deleteLearner(@PathVariable int learner_id){
        lservice.deleteLearner(learner_id);
    }

    // 6.CheckLearnerExistence
    @GetMapping("/checkLearnerExistence/{learner_id}")
    public boolean checkLearnerExistence(@PathVariable int learner_id){
        return lservice.doesLearnerExists(learner_id);
    }

    // 7.Put Mapping for grabbing course object into Learner
    @PutMapping("/{learner_id}/courses/{course_id}")
    public Learners assignDetails(@PathVariable int learner_id, @PathVariable int course_id){

        Courses course = cservice.getCourseById(course_id);

        //System.out.println(course);
        return lservice.assignCourse(learner_id,course);
    }








}
