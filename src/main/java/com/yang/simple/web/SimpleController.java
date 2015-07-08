package com.yang.simple.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yang.simple.business.UserService;
import com.yang.simple.config.ConfigProperties;

@RestController
public class SimpleController {
	
	@Bean(name = "com.yang.simple.config.ConfigBean")
	@ConditionalOnMissingBean
	public ConfigProperties configProperties() {
		return new ConfigProperties();
	}
	
	@Autowired
	protected ConfigProperties properties;
	
	@Autowired
	protected UserService userService;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String hello() {
		System.out.println(userService.getAllUser());
		return "hello world: " + properties.getName();
	}
	
}
