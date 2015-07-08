package com.yang.simple.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yang.simple.business.UserService;
import com.yang.simple.redis.UserRepository;

@Controller
public class SimpleController {
	
	@Autowired
	protected UserService userService;
	
	@Autowired
	protected UserRepository userRepository;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String hello() {
		test();
		return "hello world";
	}
	
	private void test(){
		System.out.println(userService.getAllUser());
		
		userRepository.saveUser("Chill");
		System.out.println(userRepository.getUser());
	}
}
