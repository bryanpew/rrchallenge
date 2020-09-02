package com.redriver.challenge.repository;

import com.redriver.challenge.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByFirstname (String firstName);
    Optional<Student> findByLastname (String lastName);
    Optional<Student> findByLastnameAndFirstname(String firstname, String lastname);
    Optional<Student> findByLastnameOrFirstname(String firstname, String lastname);
}
