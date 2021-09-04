package com.example.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min=2,message="answer should be gretaer the 2 characters")
	private String question;

	@Size(min=2,message="answer should be gretaer the 2 characters")
	private List<String> answers;
	
	private int vote;

	private int user_id;

	@JsonIgnore
	@ManyToOne
	private User user;

	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", answers=" + answers + ", vote=" + vote + ", u_id="
				+ user_id + ", user=" + user + "]";
	}

}
