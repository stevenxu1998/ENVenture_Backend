package org.enventure.demobackend.controller;

import org.enventure.demobackend.domain.Quiz;
import org.enventure.demobackend.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/quizzes")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping
    public List<Quiz> getAllQuizzes(){return quizService.getQuizzes();}

    @GetMapping("/{id}")
    public Quiz getQuiz (@PathVariable Long id){
        return quizService.getQuiz(id);
    }

    @PostMapping
    public void createQuiz (@RequestBody Quiz quiz){quizService.createQuiz(quiz);}

    //update

    @DeleteMapping("/{id}")
    public void deleteQuiz (@PathVariable("id") Long id){
        quizService.deleteQuiz(id);
    }


}
