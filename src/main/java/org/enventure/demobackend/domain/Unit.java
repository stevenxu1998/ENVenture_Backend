package org.enventure.demobackend.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private List<String> section;
    @OneToMany( fetch = FetchType.EAGER)
    private List<Quiz> quizList;
    private List<String> fileNames;

    public Unit(){

    }
    public Unit(List<String> section, List<Quiz> quizList, List<String> fileNames){
        this.section = section;
        this.quizList = quizList;
        this.fileNames = fileNames;
    }

    public List<String> getSection(){
        return section;
    }

     public void setSection(List<String> section){
        this.section = section;
     }

     public List<Quiz> getQuizList (){
        return quizList;
     }

     public void setQuizList(List<Quiz> quizList){
        this.quizList = quizList;
     }

     public List<String> getFileNames (){
        return fileNames;
     }

     public void setFileNames (List<String> fileNames){
        this.fileNames = fileNames;
     }

     @Override
     public String toString (){
        return "Unit{" +
                "id" + id +
                ", Sections" + section +
                ", quizList = '" + quizList +
                ", fileNames = '" + fileNames +
                '}';
     }
}
