package com.yang.framework.config;




public class ConfigLoader {

	public static final String CONFIG_FILENAME = "sys.properties";;

	public static void startSystemConfig() {
		String configFile = Thread.currentThread().getContextClassLoader()
				.getResource(CONFIG_FILENAME).getFile();
		SystemConfig.init(configFile);
	}

	public static void listenForChanges() {
		int fileChangesDelay = SystemConfig
				.getIntValue(ConfigKeys.FILECHANGES_DELAY);

		if (fileChangesDelay > 0) {
			// System Properties
			FileMonitor.getInstance().addFileChangeListener(
					new SystemConfigListener(),
					SystemConfig.getValue(ConfigKeys.DEFAULT_CONFIG),
					fileChangesDelay);
		}
	}


}
