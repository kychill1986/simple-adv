package com.yang.simple.task;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UserTask {

	/** 日志记录器 */
	Logger logger = Logger.getLogger(getClass().getSimpleName());

	@Scheduled(fixedRate = 10 * 60 * 1000l, initialDelay = 5 * 1000l)
	public void themeTask() {
		logger.info("----------------------任务，开始----------------------");
		logger.info("----------------------任务，结束----------------------");
	}
	
}