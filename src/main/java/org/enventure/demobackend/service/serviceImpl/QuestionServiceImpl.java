package org.enventure.demobackend.service.serviceImpl;

import org.enventure.demobackend.domain.Question;
import org.enventure.demobackend.repository.QuestionRepository;
import org.enventure.demobackend.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestion(Long id) {
        return questionRepository.getOne(id);
    }

    @Override
    public void updateQuestion(Long id, Question question) {

        // Steve to update
        Question newQuestion = questionRepository.findById(id).get();
        newQuestion.setAnswerList(newQuestion.getAnswerList());
        newQuestion.setQn(newQuestion.getQn());
        questionRepository.save(newQuestion);
    }

    @Override
    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }
}
