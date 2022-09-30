package com.spring.assignment.Sept.SpringAssignment30Sept.service;

import com.spring.assignment.Sept.SpringAssignment30Sept.entity.Courses;
import com.spring.assignment.Sept.SpringAssignment30Sept.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursesService {

    @Autowired
    CoursesRepository crepo;


    // 1.(Saves the course) Post/add the course
    public Courses addCourse(Courses course){
        return crepo.save(course);
    }

    // 2.(Return the course with given id) Get course by Id
    public Courses getCourseById(int course_id){
        Optional<Courses> tempCourse = crepo.findById(course_id);

        if(tempCourse.isEmpty()) throw new RuntimeException("Learner with id : "+course_id+" NOT FOUND !!");

        return tempCourse.get();
    }

    // 3.(Returns all Courses (rows)) Get all Courses
    public List<Courses> getAllCourses(){
        return crepo.findAll();
    }


    // 4.(Return the number of Courses) Count all Courses
    public int countCourses(){
        return (int) crepo.count();
    }

    // 5.(Deletes a course by ID) deletebyid
    public void deleteCourse(int course_id){
        Optional<Courses> tempCourse = crepo.findById(course_id);

        if(tempCourse.isEmpty()) throw new RuntimeException("Course with id : "+course_id+" NOT FOUND !!");

        crepo.delete(tempCourse.get());
    }

    // 6.(Indicate whether a course with given ID exists)
    public boolean doesCourseExists(int course_id){

        Optional<Courses> tempCourse = crepo.findById(course_id);

        if(tempCourse.isEmpty()) return false;
        return true;
    }
}
