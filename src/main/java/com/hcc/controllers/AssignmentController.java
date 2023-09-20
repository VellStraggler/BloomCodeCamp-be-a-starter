package com.hcc.controllers;

import com.hcc.entities.Assignment;
import com.hcc.entities.User;
import com.hcc.repositories.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {

    @Autowired
    AssignmentRepository repository;

    @Autowired
    public AssignmentController(AssignmentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
//    ResponseEntity<?> getAssignments() {
    Assignment getAssignments() {
        return new Assignment("submitted",999,"github.com",
                "main", "youtube.com",
                new User(new Date(), "docker", "docker"),
                new User(new Date(), "docker", "docker"));
    }

    @GetMapping("/{id}")
    ResponseEntity<?> getAssignmentsById(@RequestHeader Integer id) {
        return ResponseEntity.ok("");
    }

    @PutMapping("/{id}")
    ResponseEntity<?> putAssignmentById(@RequestHeader Integer id) {
        return ResponseEntity.ok((String)("putAssignmentById request recognized with id " + id));
    }

    @PostMapping("/{id}")
    ResponseEntity<?> postAssignment(@RequestHeader Integer id, @RequestBody Assignment assignment) {
        return ResponseEntity.ok((String)("postAssignment with id " + id + " and assignment " + assignment.toString()));
    }
}
