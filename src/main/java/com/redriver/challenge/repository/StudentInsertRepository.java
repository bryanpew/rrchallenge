package com.redriver.challenge.repository;

import com.redriver.challenge.model.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class StudentInsertRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void insertWithEntityManager(Student student) {
        this.entityManager.persist(student);
    }
}
