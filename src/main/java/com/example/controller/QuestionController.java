package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Question;
import com.example.exception.InvalidQuestionException;
import com.example.service.IQuestionService;

@RestController
@ControllerAdvice
public class QuestionController {

	@Autowired
	IQuestionService questionService;
	
	@PostMapping("/question")
	public Question createQuestion(@RequestBody Question ques) {
		return questionService.saveQuestion(ques);
	}
	
	@GetMapping("/question")
	public Iterable<Question> getAllQuestion() {
		return questionService.getAll();
	}
	@DeleteMapping("/question/{id}")
	public void deleteQuestion(@PathVariable Integer id) {
		 questionService.deleteQuestion(id);
	}
	
	@PutMapping("question/answer/{id}")
	public String addAnswer(@RequestBody Question ques ,@PathVariable Integer id) {
		return questionService.updateAnswers(ques,id);
	}
	@PutMapping("/question/increment/{id}")
	public String upvote(@RequestBody Question ques ,@PathVariable Integer id) {
		return questionService.upvote(ques,id);
	}
	@ExceptionHandler(value = InvalidQuestionException.class)
	   public ResponseEntity<Question> exception(RuntimeException runTimeException) {
	      return new ResponseEntity<Question>(HttpStatus.BAD_REQUEST);
	   }
}

