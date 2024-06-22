package com.kishore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kishore.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer>{
//we mention the class name/table name and the primary key type


}
