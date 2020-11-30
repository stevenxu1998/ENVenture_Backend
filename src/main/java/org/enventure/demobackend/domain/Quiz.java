package org.enventure.demobackend.domain;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.List;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long mark;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Question> questionList;
    //private List<Answer> correctAnswerList;
    @ManyToOne(fetch = FetchType.EAGER)
    private Unit unit;

    public Quiz(){

    }

    public Quiz(List<Question> questionList, Long mark){
        this.questionList = questionList;
        //this.correctAnswerList = correctAnswerList;
        this.mark = mark;
    }

    public List<Question> getQuestionList(){
        return questionList;
    }

    public void setQuestionList(List<Question> questionList){
        this.questionList = questionList;
    }

//    public List<Answer> getCorrectAnswerList(){
//        return correctAnswerList;
//    }

//    public void setCorrectAnswerList(List<Answer> correctAnswerList){
//        this.correctAnswerList = correctAnswerList;
//    }
    public Unit getUnit(){return unit;}

    public void setUnit(Unit unit){this.unit = unit;}

    public Long getMark(){
        return mark;
    }

    public void setMark(Long mark){
        this.mark = mark;
    }

    @Override
    public String toString (){
        return "Quiz{" +
                "id" + id +
                ", questionList='" + questionList +
                '}';
    }
}
