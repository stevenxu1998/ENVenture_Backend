package org.enventure.demobackend.service.serviceImpl;

import org.enventure.demobackend.domain.Answer;
import org.enventure.demobackend.repository.AnswerRepository;
import org.enventure.demobackend.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    @Override
    public List<Answer> getQAnswers() {
        return answerRepository.findAll();
    }

    @Override
    public Answer getAnswer(Long id) {
//        return answerRepository.getOne(id);
        return answerRepository.findById(id).get();
    }

    @Override
    public void updateAnswer(Long id, Answer answer) {

        // Steve to do
        Answer newAnswer = answerRepository.findById(id).get();//set a variable for the new answer
        newAnswer.setQuestion(answer.getQuestion());
        answerRepository.save(newAnswer);//save it
    }

    @Override
    public void deleteAnswer(Long id) {
        answerRepository.deleteById(id);

    }
}
