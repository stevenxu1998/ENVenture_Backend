package org.enventure.demobackend.DTO;

import java.util.List;

public class CourseDTO {
    private Long id;
    private String courseName;
    private List <String> Units;
    private int numberOfUnits;
    private int studentCount;
    private String teacherFirstName;
    private String teacherLastName;
    private String teacherEmail;
    private String adminFirstName;
    private String adminLastName;
    private String adminEmail;

    public CourseDTO(){
    }

    public Long getId(){
        return id;
    }

    public void setID(Long id){
        this.id = id;
    }

    public String getCourseName(){
        return courseName;
    }

    public void setCourseName(String courseName){
        this.courseName = courseName;
    }

    public List<String> getUnits(){
        return Units;
    }
    public void setUnits(List<String> Units){
        this.Units = Units;
    }

    public int getNumberOfUnits(){
        return numberOfUnits;
    }

    public void setNumberOfUnits(int numberOfUnits){
        this.numberOfUnits = numberOfUnits;
    }

    public int getStudentCount(){
        return studentCount;
    }

    public void setStudentCount(int studentCount){
        this.studentCount = studentCount;
    }

    public String getTeacherFirstName(){
        return teacherFirstName;
    }

    public void setTeacherFirstName(String teacherFirstName){
        this.teacherFirstName = teacherFirstName;
    }

    public String getTeacherLastName(){
        return teacherLastName;
    }

    public void setTeacherLastName(String teacherLastName){
        this.teacherLastName = teacherLastName;
    }

    public String getTeacherEmail(){
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail){
        this.teacherEmail = teacherEmail;
    }

    public String getAdminFirstName(){
        return adminFirstName;
    }

    public void setAdminFirstName(String adminFirstName){
        this.adminFirstName = adminFirstName;
    }

    public String getAdminLastName(){
        return adminLastName;
    }

    public void setAdminLastName(String adminLastName){
        this.adminLastName = adminLastName;
    }

    public String getAdminEmail(){
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail){
        this.adminEmail = adminEmail;
    }
}
