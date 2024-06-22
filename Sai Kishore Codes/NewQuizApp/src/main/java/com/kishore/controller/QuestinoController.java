package com.kishore.controller;
import com.kishore.model.Question;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kishore.service.questionService;

@Controller
@RequestMapping("/question")
public class QuestinoController {
	@Autowired
	questionService qService;
	
	
	
	@GetMapping("/all")
	@ResponseBody
	public List<Question> getAllQuestions() {
		return qService.getAllQuestions();
	}

}
