package com.example.quizapp.controller;

import com.example.quizapp.model.Question;
import com.example.quizapp.sevice.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;


    @GetMapping("/all")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>>getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity <String> postQuestion(@RequestBody Question question){
       return questionService.addQuestion(question);
    }

    @DeleteMapping("remove/{id}")

    public ResponseEntity<String> removeQuestion(@PathVariable Integer id) {

        return questionService.removeQuestion(id);

    }


//    @GetMapping("test")
//        public String test(){
//            return "Hello World";
//        }

}
