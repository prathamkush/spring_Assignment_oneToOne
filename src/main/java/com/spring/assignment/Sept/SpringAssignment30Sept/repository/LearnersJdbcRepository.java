package com.spring.assignment.Sept.SpringAssignment30Sept.repository;


import com.spring.assignment.Sept.SpringAssignment30Sept.entity.Learners;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public class LearnersJdbcRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // READING TABLE DATA (ROWS)
    public List<Learners> getAllLearners(){
        String getAllLearnersQuery = "SELECT * FROM Learners";
        // JDBCTEMPLATE => Query => Database => Result Set => Row Mapped => Player.Class => List<Object>
        return jdbcTemplate.query(getAllLearnersQuery, new BeanPropertyRowMapper<>(Learners.class));
    }

    // READ (GET BY learner ID)
    public Learners getLearnerById(int learner_id){
        String getLearnerQuery = "SELECT * FROM Learners WHERE learner_id = ?";

        return jdbcTemplate.queryForObject(getLearnerQuery,new BeanPropertyRowMapper<>(Learners.class),new Object[]{learner_id});

    }

    // Create (insert)

    public int insertLearner(Learners learner){
        String insertLearnerQuery = "INSERT INTO Learners VALUES(?,?,?,?)";

        return jdbcTemplate.update(insertLearnerQuery, new Object[]{
                learner.getLearner_first_name(),
                learner.getLearner_last_name(),
                learner.getLearner_email(),
                learner.getLearner_password()
        });
    }

    // Update a certain ROW (via Learners id)

    public int updateLearner(Learners learner){
        String updateQuery = "UPDATE Learners "+" SET learner_first_name = ?," +
                " learner_last_name = ?, learner_email = ?, learner_password = ? " + " WHERE learner_id = ?";


        return jdbcTemplate.update(updateQuery, new Object[]{
                learner.getLearner_first_name(),
                learner.getLearner_last_name(),
                learner.getLearner_email(),
                learner.getLearner_password(),
                learner.getLearner_id()
        });
    }

    // Delete operation (by id)
    public int deleteLearner(int learner_id){
        String deleteQuery = "DELETE FROM Learner "+" WHERE learner_id = ?";

        return jdbcTemplate.update(deleteQuery, new Object[]{learner_id});
    }

}
