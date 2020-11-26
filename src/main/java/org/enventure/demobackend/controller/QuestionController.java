package org.enventure.demobackend.controller;

import org.enventure.demobackend.domain.Question;
import org.enventure.demobackend.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping
    public List<Question> getAllQuestions(){
        return questionService.getQuestions();
    }

    @GetMapping("/{id}")
    public Question getQuestion(@PathVariable Long id){
        // exception handling
        return questionService.getQuestion(id);
    }

    @PostMapping
    public void createQuestion(@RequestBody Question question){ // data-binding
        questionService.createQuestion(question);
    }

    // delete
    @DeleteMapping("/{id}")//id is a path variable
    public void deleteStudent(@PathVariable("id") long id){
        questionService.deleteQuestion(id);
    }

    // update

    // postMultiple

}
