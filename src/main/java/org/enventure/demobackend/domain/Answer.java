package org.enventure.demobackend.domain;

import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ans;
    @ManyToOne(fetch = FetchType.EAGER)
    private Question question;

    public Answer() {
    }

    public Answer(Question question) {
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id= '" + id +
//                ", question= '" + question +
                ", answer='"+ ans+
                '}';
    }
}
