package com.example.quizapp.sevice;

import com.example.quizapp.dao.QuestionDAO;
import com.example.quizapp.model.Question;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDAO questionDAO;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDAO.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(questionDAO.findByCategory(category), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

        }
    }

    public ResponseEntity<String> addQuestion(Question question) {
       try{ questionDAO.save(question);
           return new ResponseEntity<>("Question added successfully", HttpStatus.CREATED);
       }catch (Exception e){
           e.printStackTrace();
           return new ResponseEntity<>("Question not added", HttpStatus.BAD_REQUEST);
       }
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
