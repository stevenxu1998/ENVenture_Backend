package org.enventure.demobackend.service;

import org.enventure.demobackend.domain.Question;

import java.util.List;

public interface QuestionService {
    public Question createQuestion(Question question);
    public List<Question>getQuestions();
    public Question getQuestion(Long id);
    public void updateQuestion(Long id);
    public void deleteQuestion(Long id);

}
