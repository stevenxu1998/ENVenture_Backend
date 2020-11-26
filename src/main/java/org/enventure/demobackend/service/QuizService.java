package org.enventure.demobackend.service;

import org.enventure.demobackend.domain.Quiz;

import java.util.List;

public interface QuizService {
    public Quiz createQuiz (Quiz quiz);
    public List<Quiz>getQuizzes();
    public Quiz getQuiz(Long id);
    public void updateQuiz(Long id);
    public void deleteQuiz(Long id);

}
