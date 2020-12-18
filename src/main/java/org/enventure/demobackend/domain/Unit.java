package org.enventure.demobackend.domain;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
//    @ElementCollection
//    @Column(name = "Sections")
//    private List<String> sections;
    //private List<String> fileNames;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Quiz> quizList;
    @ManyToOne(fetch = FetchType.EAGER)
    private Course course;

    public Unit(){

    }
    public Unit(List<String> sections, List<Quiz> quizList, List<String> fileNames, Course course){
        //this.sections = sections;
        this.quizList = quizList;
        //this.fileNames = fileNames;
        this.course = course;
    }

//    public List<String> getSection(){
//        return sections;
//    }
//
//     public void setSection(List<String> sections){
//        this.sections = sections;
//     }

     public Course getCourse(){return course;}

     public void setCourse(Course course){this.course = course;}

     public List<Quiz> getQuizList (){
        return quizList;
     }

     public void setQuizList(List<Quiz> quizList){
        this.quizList = quizList;
     }

     public String getName(){return name;}

     public void setName(String name){this.name = name;}

//     public List<String> getFileNames (){
//        return fileNames;
//     }
//
//     public void setFileNames (List<String> fileNames){
//        this.fileNames = fileNames;
//     }

     @Override
     public String toString (){
        return "Unit{" +
                "id" + id +
                ", name = '" + name +
                ", quizList = '" + quizList +
                '}';
     }
}
