package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dao.AppUserDAO;
import vo.AppUserVO;

@RestController
@SpringBootApplication(scanBasePackages = {"dao"})
@CrossOrigin(origins = "*")
public class AppUserController {

	@Autowired
	AppUserDAO dao;
	
	@RequestMapping(value="/user/{type}", method=RequestMethod.POST)
	@ResponseBody
	public void getUser(@PathVariable(value="type") String type,@RequestBody AppUserVO vo) {
		if(type.equals("signup")) {
			dao.signup(vo);
			System.out.println("회원가입 성공");
		}
	}
}
