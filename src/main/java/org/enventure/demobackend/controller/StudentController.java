package org.enventure.demobackend.controller;

import org.enventure.demobackend.domain.Quiz;
import org.enventure.demobackend.domain.Student;
import org.enventure.demobackend.exception.MyResourceNotFoundException;
import org.enventure.demobackend.repository.StudentRepository;
import org.enventure.demobackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    private StudentRepository studentRepository;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student stud = studentService.createStudent(student);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("reach-status", "reached very well");
        return new ResponseEntity<>(stud, httpHeaders,HttpStatus.CREATED);

    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.FOUND);
    }
    @DeleteMapping("/{id}")//id is a path variable
    public void deleteStudent(@PathVariable("id") long id){
        studentService.deleteStudent(id);
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.PUT)
    public void updateStudent(@PathVariable Long id){
        Student newStudent = studentRepository.findById(id).get();
        studentService.updateStudent(id, newStudent);
    }

    @GetMapping(value="/name", params={"firstName", "lastName"})//request parameters, get the difference between them
//    @RequestMapping(value="/name", params={"firstName", "lastName"})
    public ResponseEntity<List<Student>> getStudentsByName(@RequestParam(defaultValue = "", required = false, name = "fName") String firstName,
                                                           @RequestParam(required = false, name="lName") String lastName){
        Optional<List<Student>> students = Optional.ofNullable(studentService.getStudentsByName(firstName, lastName));
        return new ResponseEntity<>(students.orElse(null), HttpStatus.FOUND); // handle dynamic properly
    }

    @GetMapping(params={"page", "size"})
    public Page<Student> findStudentsPaginated(@RequestParam(value = "page", required = false) int page,
                                                              @RequestParam(name="size", required = false) int size,
                                                              UriComponentsBuilder uriBuilder,
                                                              HttpServletResponse response)
            {

//        Page<Student> resultPage = studentService.findStudentsPaginated(Pageable.unpaged());


        return null;
    }

}
