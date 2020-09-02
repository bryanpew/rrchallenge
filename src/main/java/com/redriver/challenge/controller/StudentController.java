package com.redriver.challenge.controller;

import com.redriver.challenge.exception.StudentNotFoundException;
import com.redriver.challenge.model.Student;
import com.redriver.challenge.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/students")
    List<Student> all() {
        return repository.findAll();
    }

    @GetMapping(value = "/classroom")
    public List<Student>  getStudents (Model model){
        List<Student> studentList = repository.findAll();
        model.addAttribute("studentList", studentList);
        return studentList;
    }

    @GetMapping(value = "/students/{firstname}")
    Student findFirstName(@PathVariable String firstName)  {

        return repository.findByFirstname(firstName)
                .orElseThrow(() -> new StudentNotFoundException(firstName));
    }

    @GetMapping(value = "/students/{lastname}")
    Student findLastName(@PathVariable String lastName)  {

        return repository.findByLastname(lastName)
                .orElseThrow(() -> new StudentNotFoundException(lastName));
    }

    @GetMapping(value = "/students/searchAnd/{lastname}/{firstname}")
    Student findLastNameAndFirstName(@PathVariable String lastName,@PathVariable String firstName) {

        return repository.findByLastnameAndFirstname(lastName,firstName)
                .orElseThrow(() ->  new StudentNotFoundException(lastName));
    }

    @GetMapping(value = "/students/searchOr/{lastname}/{firstname}")
    Student findLastNameOrFirstName(@PathVariable String lastName,@PathVariable String firstName) {

        return repository.findByLastnameOrFirstname(lastName,firstName)
                .orElseThrow(() -> new StudentNotFoundException(lastName));
    }

    @PostMapping(value = "/students")
    Student newStudent(@RequestBody Student newStudent) {
        return repository.save(newStudent);
    }

    @PutMapping(value = "/students/{id}")
    Student replaceStudent(@RequestBody Student newStudent, @PathVariable Long id) {

        return repository.findById(id)
                .map(student -> {
                    student.setFirstname(newStudent.getFirstname());
                    student.setLastname(newStudent.getLastname());
                    student.setAge(newStudent.getAge());
                    return repository.save(student);
                })
                .orElseGet(() -> {
                    newStudent.setId(id);
                    return repository.save(newStudent);
                });
    }
}
