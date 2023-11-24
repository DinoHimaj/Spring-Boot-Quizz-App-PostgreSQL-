package com.example.quizapp.sevice;

import com.example.quizapp.dao.QuestionDAO;
import com.example.quizapp.dao.QuizDAO;
import com.example.quizapp.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

    @Autowired
    QuizDAO quizDao;
    @Autowired
    QuestionDAO questionDao;

    public static ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> questions = QuestionDAO.findRandomQuestions(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
    }
}
