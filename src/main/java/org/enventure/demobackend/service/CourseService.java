package org.enventure.demobackend.service;

import org.enventure.demobackend.DTO.CourseDTO;
import org.enventure.demobackend.domain.Admin;
import org.enventure.demobackend.domain.Course;
import org.enventure.demobackend.domain.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CourseService {
    public Course createCourse(Course course);
    public List<Course> getCourses();
    public Course getCourse(Long id);
    public void updateCourse(Long id, Course course);
    public void deleteCourse(Long id);
    public CourseDTO convertToCourseDTO(Course course, Admin admin, Teacher teacher);
}
