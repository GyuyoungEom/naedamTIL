package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dao.TodoDAO;
import vo.TodoVO2;

@RestController
@SpringBootApplication(scanBasePackages = {"dao"})
@CrossOrigin(origins = "*")
public class TodoController {
	
	@Autowired(required=true)
	TodoDAO dao;
	
	@RequestMapping(value="/todo")
	public List<TodoVO2> getTodo(){
		return dao.getList();
	}
	
	@RequestMapping(value="/todo/insert/{content}", method=RequestMethod.POST)
	public List<TodoVO2> insertTodo(@PathVariable("content")String content) {
		dao.insertTodo(content);
		return dao.getList();
	}
	
	@RequestMapping(value="/todo/deleteAll", method=RequestMethod.POST)
	public void deleteAll() {
		dao.deleteAllTodo();
	}
	
	@RequestMapping(value="/todo/delete/{id}", method=RequestMethod.POST)
	public List<TodoVO2> deleteOne(@PathVariable("id")int id) {
		dao.deleteTodo(id);
		return dao.getList();
	}
	
	@RequestMapping("/todo/size")
	public int size() {
		return dao.todoSize();
	}
}
