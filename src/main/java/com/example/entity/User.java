package com.example.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "User")
public class User {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		

		@NotEmpty(message = "First Name should not be Empty")
		@Size(min=3,message="First Name should have atleast 3 Letters")
		private String name;

		@Email(message="proper email format required")
		private String email;

		@OneToMany(cascade = CascadeType.ALL)
		@JoinColumn(name = "USER_ID")
		private Set<Question> question;
	}

