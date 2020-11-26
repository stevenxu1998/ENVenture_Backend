package org.enventure.demobackend.service;

import org.enventure.demobackend.domain.Answer;
import org.enventure.demobackend.domain.Question;

import java.util.List;

public interface AnswerService {
    public Answer createAnswer(Answer answer);
    public List<Answer> getQAnswers();
    public Answer getAnswer(Long id);
    public void updateAnswer(Long id, Answer answer);
    public void deleteAnswer(Long id);
}
