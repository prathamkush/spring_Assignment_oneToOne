package com.spring.assignment.Sept.SpringAssignment30Sept.repository;


import com.spring.assignment.Sept.SpringAssignment30Sept.entity.Learners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearnersRepository extends JpaRepository<Learners, Integer> {

}
