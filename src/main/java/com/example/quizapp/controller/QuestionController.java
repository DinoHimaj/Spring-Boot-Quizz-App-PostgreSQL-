package com.example.quizapp.controller;

import com.example.quizapp.sevice.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/all")
    public String getAllQuestions(){
       // return questionService.getAllQuestions();

    }
}
