package com.yang.framework.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.yang.framework.config.ConfigLoader;
import com.yang.framework.config.SystemConfig;

public class StartSystem implements ServletContextListener {

	private static final Log log = LogFactory.getLog(StartSystem.class);

	@Override
	public void contextDestroyed(ServletContextEvent event) {
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		log.info("halo admin server is starting....");
		ConfigLoader.startSystemConfig();
		ConfigLoader.listenForChanges();
		System.out.println(SystemConfig.getValue(ConfigKeys.DEPLOY_MODE));
		log.info("halo admin server is started....");
	}

}
