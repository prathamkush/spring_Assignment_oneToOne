package com.spring.assignment.Sept.SpringAssignment30Sept.controller;

import com.spring.assignment.Sept.SpringAssignment30Sept.entity.Courses;
import com.spring.assignment.Sept.SpringAssignment30Sept.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    CoursesService cservice;


    // 1.save ("/addCourse")
    @PostMapping
    public Courses addCourse(@RequestBody Courses course){
        return cservice.addCourse(course);
    }

    // 2.getbyid
    @GetMapping("/getCourseById/{course_id}")
    public Courses getCourseById(@PathVariable int course_id){
        return cservice.getCourseById(course_id);
    }

    // 3.returnAllCourses (use default path->  /courses)
    @GetMapping
    public List<Courses> getAllCourses(){
        return cservice.getAllCourses();
    }

    // 4.returnNumberOfCourses
    @GetMapping("/getTotalCourses")
    public int getTotalCourses(){
        return cservice.countCourses();
    }

    // 5.deletecoursebyid
    @DeleteMapping("/deleteCourse/{course_id}")
    public void deleteCourse(@PathVariable int course_id){
        cservice.deleteCourse(course_id);
    }

    // 6.CheckCourseExistence
    @GetMapping("/checkCourseExistence/{course_id}")
    public boolean checkCourseExistence(@PathVariable int course_id){
        return cservice.doesCourseExists(course_id);
    }
}
