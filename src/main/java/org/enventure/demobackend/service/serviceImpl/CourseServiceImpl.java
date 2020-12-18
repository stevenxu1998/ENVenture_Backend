package org.enventure.demobackend.service.serviceImpl;

import org.enventure.demobackend.DTO.CourseDTO;
import org.enventure.demobackend.domain.Admin;
import org.enventure.demobackend.domain.Course;
import org.enventure.demobackend.domain.Teacher;
import org.enventure.demobackend.repository.CourseRepository;
import org.enventure.demobackend.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course createCourse (Course course){ return courseRepository.save(course);}

    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourse (Long id){
        return courseRepository.findById(id).get();
    }

    @Override
    public void updateCourse (Long id, Course course){
        Course newCourse = courseRepository.findById(id).get();
        //newCourse.setAnnouncements(newCourse.getAnnouncements());
        newCourse.setName(newCourse.getName());
        newCourse.setStudentCount(newCourse.getStudentCount());
        courseRepository.save(newCourse);
    }

    @Override
    public void deleteCourse (Long id){
        courseRepository.deleteById(id);
    }

    @Override
    public CourseDTO convertToCourseDTO(Course course, Admin admin, Teacher teacher){
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setID(course.getId());
        courseDTO.setCourseName(course.getName());
        courseDTO.setStudentCount(course.getStudentCount());
        //courseDTO.setUnits();
        courseDTO.setNumberOfUnits(course.getNumberOfUnits());
        courseDTO.setTeacherFirstName(teacher.getFirstName());
        courseDTO.setTeacherLastName(teacher.getLastName());
        courseDTO.setTeacherEmail(teacher.getEmail());
        courseDTO.setAdminFirstName(admin.getFirstName());
        courseDTO.setAdminLastName(admin.getLastName());
        courseDTO.setAdminEmail(admin.getEmail());
        return courseDTO;
    }
}
