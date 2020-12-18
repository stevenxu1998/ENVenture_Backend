package org.enventure.demobackend.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   // @JsonProperty("question")
    private String qn;

    @OneToMany (mappedBy = "question", fetch = FetchType.EAGER)
    //joinTble(joinColumns = {joincolumn="", @inverseJoinColumn=""})
    private Set<Answer> answerList;

    @ManyToOne(fetch = FetchType.EAGER)
    private Quiz quiz;

    public Question() {
    }

    public Question(String sentence, Set<Answer> answerList) {
        this.qn = sentence;
        this.answerList = answerList;
    }

    public String getQn() {
        return qn;
    }

    public void setQn(String sentence) {
        this.qn = sentence;
    }

    public Set<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(Set<Answer> answerList) {
        this.answerList = answerList;
    }

    public Quiz getQuiz(){ return quiz;}

    public void setQuiz(Quiz quiz){this.quiz = quiz;}

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", sentence='" + qn + '\'' +
//                ", answerList= '" + answerList +
                '}';
    }
}
