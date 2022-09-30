package com.spring.assignment.Sept.SpringAssignment30Sept.repository;


import com.spring.assignment.Sept.SpringAssignment30Sept.entity.Learners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LearnersRepository extends JpaRepository<Learners, Integer> {

    //********************* QUERIES *********************//


    // 1.findByEmailAddressAndLastname
    @Modifying
    @Query("SELECT l " +
            "FROM Learners l " +
            "WHERE l.learner_email = :learner_email AND l.learner_last_name = :learner_last_name")
    List<Learners> findByEmailAddressAndLastname(@Param("learner_email") String learner_email,
                                                 @Param("learner_last_name") String learner_last_name);




    // 2.findDistinctLearnerByLastnameOrFirstname
    @Modifying
    @Query("SELECT DISTINCT l " +
            "FROM Learners l " +
            "WHERE l.learner_last_name = :learner_last_name OR " +
                    " l.learner_first_name = :learner_first_name")
    List<Learners> findDistinctLearnerByLastnameOrFirstname(@Param("learner_last_name") String learner_last_name,
                                                            @Param("learner_first_name") String learner_first_name);




    // 3.findByLastnameIgnoreCase
    @Modifying
    @Query("SELECT l " +
            "FROM Learners l " +
            "WHERE UPPER(l.learner_last_name) = UPPER(:learner_last_name)")
    List<Learners> findByLastnameIgnoreCase(@Param("learner_last_name") String learner_last_name);




    // 4.findByLastnameOrderByFirstnameAsc
    @Modifying
    @Query("SELECT l " +
            "FROM Learners l " +
            "WHERE l.learner_last_name = :learner_last_name " +
            "ORDER BY l.learner_first_name ASC")
    List<Learners> findByLastnameOrderByFirstnameAsc(@Param("learner_last_name") String learner_last_name);
}