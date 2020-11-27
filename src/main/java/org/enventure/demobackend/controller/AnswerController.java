package org.enventure.demobackend.controller;

import org.enventure.demobackend.domain.Answer;
import org.enventure.demobackend.domain.Question;
import org.enventure.demobackend.repository.AnswerRepository;
import org.enventure.demobackend.service.AnswerService;
import org.enventure.demobackend.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    @Autowired
    private AnswerService answerService;
    private AnswerRepository answerRepository;

    @GetMapping
    public List<Answer> getAllQuestions(){
        return answerService.getQAnswers(); // to correct Q
    }

    @GetMapping("/{id}")
    public Answer getAnswer(@PathVariable Long id){
        // exception handling
        return answerService.getAnswer(id);
    }

    @PostMapping
    public void createAnswer(@RequestBody Answer answer){ // data-binding
        answerService.createAnswer(answer);
    }

    //update
    @RequestMapping(value = "/answers/{id}", method = RequestMethod.PUT)
    public void updateAnswer(@PathVariable Long id){
        Answer newAnswer = answerRepository.findById(id).get();
        answerService.updateAnswer(id, newAnswer);
    }

    @DeleteMapping("/{id}")
    public void deleteAnswer (@PathVariable("id") Long id){
        answerService.deleteAnswer(id);
    }

}
