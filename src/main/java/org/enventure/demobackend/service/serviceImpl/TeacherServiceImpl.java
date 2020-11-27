package org.enventure.demobackend.service.serviceImpl;

import org.enventure.demobackend.domain.Student;
import org.enventure.demobackend.domain.Teacher;
import org.enventure.demobackend.repository.TeacherRepository;
import org.enventure.demobackend.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher createTeacher (Teacher teacher){ return teacherRepository.save(teacher);}

    @Override
    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacher (Long id){
        return teacherRepository.findById(id).get();
    }

    @Override
    public void updateTeacher (Long id, Teacher teacher){
        Teacher newTeacher = teacherRepository.findById(id).get();
        newTeacher.setEmail(newTeacher.getEmail());
        newTeacher.setFirstName(newTeacher.getFirstName());
        newTeacher.setLastName(newTeacher.getLastName());
        teacherRepository.save(newTeacher);
    }

    @Override
    public void deleteTeacher (Long id){
        teacherRepository.deleteById(id);
    }

    @Override
    public List<Teacher> getTeachersByName(String firstName, String lastName) {
        return teacherRepository.findTeachersByFirstNameOrLastName(firstName, lastName);
    }

}
