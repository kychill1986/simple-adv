package com.yang.simple.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("systemConfig")
public class SystemConfig {

	@Value("${project.name}")
	private String projectName;

	public String getProjectName() {
		return projectName;
	}

}
