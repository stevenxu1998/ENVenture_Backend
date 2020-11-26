package org.enventure.demobackend.service.serviceImpl;

import org.enventure.demobackend.domain.Student;
import org.enventure.demobackend.repository.StudentRepository;
import org.enventure.demobackend.service.StudentService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void updateStudent(Long id) {

        // see how to update
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);

    }

    @Override
    public List<Student> getStudentsByName(String firstName, String lastName) {
        return studentRepository.findStudentsByFirstNameOrLastName(firstName, lastName);
    }

//    @Override
//    public Page<Student> findStudentsPaginated(Pageable pageable) {
//
//        return null; // im plemet  k
//    }
}
