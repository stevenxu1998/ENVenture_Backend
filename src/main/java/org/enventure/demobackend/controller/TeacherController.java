package org.enventure.demobackend.controller;

import org.enventure.demobackend.domain.Teacher;
import org.enventure.demobackend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher){
        Teacher teach = teacherService.createTeacher(teacher);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("reach-status", "reached very well");
        return new ResponseEntity<>(teach, httpHeaders, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    private void deleteTeacher(@PathVariable("id") Long id){ teacherService.deleteTeacher(id);}
}
