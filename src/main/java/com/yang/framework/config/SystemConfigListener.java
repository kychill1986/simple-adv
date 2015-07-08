package com.yang.framework.config;

import org.apache.log4j.Logger;

public class SystemConfigListener implements FileChangeListener {

	private static final Logger logger = Logger.getLogger(SystemConfigListener.class);

	public void fileChanged(String filename) {
		logger.info("Reloading " + filename);

		SystemConfig.init(SystemConfig.getValue(ConfigKeys.DEFAULT_CONFIG));
		ConfigLoader.listenForChanges();
	}
}