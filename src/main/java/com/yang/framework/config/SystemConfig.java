package com.yang.framework.config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SystemConfig {

    private static final Log log = LogFactory.getLog(SystemConfig.class);

    private static SystemConfig instance = null;

    private static Properties configs = new Properties();

    private SystemConfig() {
    }

    public static synchronized SystemConfig getInstance() {

        if (instance == null) {
            instance = new SystemConfig();
        }
        return instance;
    }

    public static void init(String configFile) {

        instance = new SystemConfig();
        instance.loadConfig(configFile);
    }

    private void loadConfig(String configFile) {
        log.info("load system config...");
        try {
            SystemConfig.configs = new Properties();
            configs.put(ConfigKeys.DEFAULT_CONFIG, configFile);
            FileInputStream input = new FileInputStream(configFile);
            configs.load(input);
            input.close();

        }
        catch (IOException e) {
            log.error("system config loaded error.");
            throw new RuntimeException(e);
        }
    }
    
    public static void writeConifg(String configFile){
    	FileOutputStream out = null;
    	
    	try {
    		out = new FileOutputStream(configFile);
    		configs.store(out, "");
    		out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
    }

    public static String getValue(String key) {
        return configs.getProperty(key);
    }
    
    public static String getValue(String key, String defualt) {
    	String value = configs.getProperty(key);
    	if(StringUtils.isBlank(value)){
    		value = defualt;
    	}
    	return value;
    }

    public static void setValue(String key, String value) {
        configs.setProperty(key, value);
    }

    public static int getIntValue(String field) {
        return Integer.parseInt(getValue(field));
    }
	
    public static long getLongValue(String field) {
        return Long.parseLong(getValue(field));
    }
	public static boolean getBooleanValue(String field) {
		return Boolean.parseBoolean(getValue(field));
	}
	
}
