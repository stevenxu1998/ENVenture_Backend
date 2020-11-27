package org.enventure.demobackend.service;

import org.enventure.demobackend.domain.Question;
import org.enventure.demobackend.domain.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    public Student createStudent(Student student);
    public List<Student> getStudents();
    public Student getStudent(Long id);
    public void updateStudent(Long id, Student student);
    public void deleteStudent(Long id);

    List<Student> getStudentsByName(String firstName, String lastName);

//    Page<Student> findStudentsPaginated(Pageable pageable);
}
