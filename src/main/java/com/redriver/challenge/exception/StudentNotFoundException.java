package com.redriver.challenge.exception;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String name) {
        super("Could not find student " + name);
    }
}
