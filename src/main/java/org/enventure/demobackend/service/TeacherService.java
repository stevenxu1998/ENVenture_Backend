package org.enventure.demobackend.service;

import org.enventure.demobackend.domain.Teacher;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface TeacherService {
    public Teacher createTeacher(Teacher teacher);
    public List<Teacher> getTeachers();
    public Teacher getTeacher(Long id);
    public void updateTeacher(Long id);
    public void deleteTeacher(Long id);

    List<Teacher> getTeachersByName(String firstName, String lastName);
}
