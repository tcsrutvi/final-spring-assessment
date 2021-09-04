package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Question;
import com.example.exception.UserNotFoundException;
import com.example.repository.IQuestionRepository;

@Service
public class QuestionService implements IQuestionService {

	@Autowired
	IQuestionRepository questionRepo;
	
	@Override
	public Question saveQuestion(Question ques) {	
		return questionRepo.save(ques);
	}

	@Override
	public Iterable<Question> getAll() {
		return questionRepo.findAll();
	}

	@Override
	public void deleteQuestion(Integer id) {
		Optional<Question> question = questionRepo.findById(id);
		if(!question.isPresent()) {
			throw new UserNotFoundException("appointment does not exist");
		}
		 questionRepo.deleteById(id);
	}

	@Override
	public String updateAnswers(Question ques, Integer id) {
		Optional<Question> question = questionRepo.findById(id);
		if(!question.isPresent()) {
			throw new UserNotFoundException("appointment does not exist");
		}
		List<String> ans=ques.getanswers();
		question.get().setAnswers(ans);
		return "added "+ans+" to the question "+question.get().getQuestion();
	}

	@Override
	public String upvote(Question ques, Integer id) {
		Optional<Question> question = questionRepo.findById(id);
		if(!question.isPresent()) {
			throw new UserNotFoundException("appointment does not exist");
		}
		int vote=  question.get().getVote();
		question.get().setVote(vote+1);
		return null;
	}
		
}