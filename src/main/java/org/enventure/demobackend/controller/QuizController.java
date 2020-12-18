package org.enventure.demobackend.controller;

import org.enventure.demobackend.domain.Quiz;
import org.enventure.demobackend.repository.QuizRepository;
import org.enventure.demobackend.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/quizzes")
@CrossOrigin(origins = "http://localhost:9000")
public class QuizController {

    @Autowired
    private QuizService quizService;
    private QuizRepository quizRepository;

    @GetMapping
    public List<Quiz> getAllQuizzes(){return quizService.getQuizzes();}

    @GetMapping("/{id}")
    public Quiz getQuiz (@PathVariable Long id){
        return quizService.getQuiz(id);
    }

    @PostMapping
    public void createQuiz (@RequestBody Quiz quiz){quizService.createQuiz(quiz);}

    //update
    @RequestMapping(value = "/quizzes/{id}", method = RequestMethod.PUT)
    public void updateQuiz(@PathVariable Long id){
        Quiz newQuiz = quizRepository.findById(id).get();
        quizService.updateQuiz(id, newQuiz);
    }

    @DeleteMapping("/{id}")
    public void deleteQuiz (@PathVariable("id") Long id){
        quizService.deleteQuiz(id);
    }


}
