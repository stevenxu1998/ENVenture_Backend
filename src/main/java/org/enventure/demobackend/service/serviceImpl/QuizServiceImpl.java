package org.enventure.demobackend.service.serviceImpl;

import org.enventure.demobackend.domain.Quiz;
import org.enventure.demobackend.service.QuizService;
import org.enventure.demobackend.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Quiz createQuiz (Quiz quiz){ return quizRepository.save(quiz);}

    @Override
    public List<Quiz> getQuizzes() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz getQuiz (Long id){
        return quizRepository.findById(id).get();
    }

    @Override
    public void updateQuiz (Long id){

    }

    @Override
    public void deleteQuiz (Long id){
        quizRepository.deleteById(id);
    }
}
