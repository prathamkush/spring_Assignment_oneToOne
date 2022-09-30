package com.spring.assignment.Sept.SpringAssignment30Sept.repository;

import com.spring.assignment.Sept.SpringAssignment30Sept.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRepository extends JpaRepository<Courses,Integer> {

}
