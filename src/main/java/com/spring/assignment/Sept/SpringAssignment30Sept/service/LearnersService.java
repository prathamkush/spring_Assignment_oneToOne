package com.spring.assignment.Sept.SpringAssignment30Sept.service;

import com.spring.assignment.Sept.SpringAssignment30Sept.entity.Courses;
import com.spring.assignment.Sept.SpringAssignment30Sept.entity.Learners;
import com.spring.assignment.Sept.SpringAssignment30Sept.repository.LearnersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LearnersService {

    @Autowired
    LearnersRepository lrepo;




    // 1.(Saves the learner) Post/add the learner
    public Learners addLearner(Learners learner){
        return lrepo.save(learner);
    }

    // 2.(Return the learner with given id) Get learner by Id
    public Learners getLearnerById(int learner_id){
        Optional<Learners> tempLearner = lrepo.findById(learner_id);

        if(tempLearner.isEmpty()) throw new RuntimeException("Learner with id : "+learner_id+" NOT FOUND !!");

        return tempLearner.get();
    }

    // 3.(Returns all learners (rows)) Get all Learners
    public List<Learners> getAllLearners(){
        return lrepo.findAll();
    }


    // 4.(Return the number of Learners) Count all learners
    public int countLearners(){
        return (int) lrepo.count();
    }

    // 5.(Deletes a learner by ID) deletebyid
    public void deleteLearner(int learner_id){
        Optional<Learners> tempLearner = lrepo.findById(learner_id);

        if(tempLearner.isEmpty()) throw new RuntimeException("Learner with id : "+learner_id+" NOT FOUND !!");

        lrepo.delete(tempLearner.get());
    }

    // 6.(Indicate whether a learner with given ID exists)
    public boolean doesLearnerExists(int learner_id){

        Optional<Learners> tempLearner = lrepo.findById(learner_id);

        if(tempLearner.isEmpty()) return false;
        return true;
    }

    // 7.(Grabbing Course object into Learner)
    public Learners assignCourse(int learner_id, Courses course){
        Learners learner = lrepo.findById(learner_id).get();

        learner.setCourse(course);

        return lrepo.save(learner);
    }

}
