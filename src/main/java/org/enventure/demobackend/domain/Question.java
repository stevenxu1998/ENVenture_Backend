package org.enventure.demobackend.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   // @JsonProperty("question")
    private String qn;

    @OneToMany (mappedBy = "question", fetch = FetchType.EAGER)
    //joinTble(joinColumns = {joincolumn="", @inverseJoinColumn=""})
    private List<Answer> answerList;

    public Question() {
    }

    public Question(String sentence, List<Answer> answerList) {
        this.qn = sentence;
        this.answerList = answerList;
    }

    public String getQn() {
        return qn;
    }

    public void setQn(String sentence) {
        this.qn = sentence;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", sentence='" + qn + '\'' +
                ", answerList= '" + answerList +
                '}';
    }
}
