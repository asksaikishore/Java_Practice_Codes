package com.kishore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kishore.dao.QuestionDao;
import com.kishore.model.Question;

@Service
public class questionService {
	
	@Autowired
	QuestionDao qDao;

	public List<Question> getAllQuestions() {
		// TODO Auto-generated method stub
		return qDao.findAll();
	}
	
	
	

}
