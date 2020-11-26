package org.enventure.demobackend.service;

import org.enventure.demobackend.domain.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CourseService {
    public Course createCourse(Course course);
    public List<Course> getCourses();
    public Course getCourse(Long id);
    public void updateCourse(Long id);
    public void deleteCourse(Long id);
}
