package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Question;

public interface IQuestionRepository extends CrudRepository<Question, Integer>  {

}
