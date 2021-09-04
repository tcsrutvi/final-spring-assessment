package com.example.service;

import com.example.entity.Question;

public interface IQuestionService {

	Question saveQuestion(Question ques);

	Iterable<Question> getAll();

	void deleteQuestion(Integer id);

	String updateAnswers(Question ques, Integer id);

	String upvote(Question ques, Integer id);

}
