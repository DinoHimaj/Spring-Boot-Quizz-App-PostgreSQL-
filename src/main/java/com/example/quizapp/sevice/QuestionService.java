package com.example.quizapp.sevice;

import com.example.quizapp.dao.QuestionDAO;
import com.example.quizapp.model.Question;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDAO questionDAO;

    public List<Question> getAllQuestions() {
        return questionDAO.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDAO.findByCategory(category);
    }


    public String addQuestion(Question question) {
          questionDAO.save(question);
          return "Question added successfully";
    }

    @Transactional
    public ResponseEntity<String> removeQuestion(Integer id) {
        if (questionDAO.existsById(id)) {
            questionDAO.deleteById(id);
            return ResponseEntity.ok("Question removed successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
