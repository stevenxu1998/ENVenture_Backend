package org.enventure.demobackend.controller;

import org.enventure.demobackend.domain.Answer;
import org.enventure.demobackend.domain.Course;
import org.enventure.demobackend.repository.CourseRepository;
import org.enventure.demobackend.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = "http://localhost:9000/")
public class CourseController {
    @Autowired
    private CourseService courseService;
    private CourseRepository courseRepository;

    @GetMapping
    public ResponseEntity<Course> response(){

        return new ResponseEntity<Course>(new Course("Java Programming by Smith"), HttpStatus.OK);
    }

    @GetMapping("/all")
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
    @RequestMapping(value = "/courses/{id}", method = RequestMethod.PUT)
    public void updateCourse(@PathVariable Long id){
        Course newCourse = courseRepository.findById(id).get();
        courseService.updateCourse(id, newCourse);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse (@PathVariable("id") Long id){courseService.deleteCourse(id);}
}
