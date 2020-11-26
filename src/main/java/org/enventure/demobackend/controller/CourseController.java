package org.enventure.demobackend.controller;

import org.enventure.demobackend.domain.Course;
import org.enventure.demobackend.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<Course> response(){

        return new ResponseEntity<Course>(new Course("Java Programming by Smith"), HttpStatus.OK);
    }

    @GetMapping
    public List<Course> getAllCourses(){
        return courseService.getCourses();
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable Long id){
        return courseService.getCourse(id);
    }

    @PostMapping
    public void createCourse (@RequestBody Course course){ courseService.createCourse(course);}

    //updateCourse

    @DeleteMapping("/{id}")
    public void deleteCourse (@PathVariable("id") Long id){courseService.deleteCourse(id);}
}
