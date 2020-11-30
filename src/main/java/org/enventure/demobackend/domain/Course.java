package org.enventure.demobackend.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int studentCount;
    //private List<String> announcements;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Unit> Unit;

    public Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentCount(){ return studentCount;}

    public void setStudentCount(int studentCount){this.studentCount = studentCount;}

    public Set<Unit> getUnit(){return Unit;}

    public void setUnit(Set<Unit> Unit){this.Unit = Unit;}

//    public List<String> getAnnouncements(){return announcements;}
//
//    public void setAnnouncements(List<String> announcements){this.announcements = announcements;}

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name +
                ", studentCount ='"+ studentCount +
                ", Unit = '"+ Unit +
                '}';
    }
}
