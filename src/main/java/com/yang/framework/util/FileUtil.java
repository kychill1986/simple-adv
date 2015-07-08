package com.yang.framework.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

public class FileUtil {
	public static void deleteDirectory(String path) throws IOException{
		if (path != null && !"".equals(path)) {
			deleteDirectory(new File(path));
		}
	}
	
	public static void deleteDirectory(File file) throws IOException{
		FileUtils.deleteDirectory(file);
	}
	
	public static void deleteFile(String path){
		if (path != null && !"".equals(path)) {
			deleteFile(new File(path));
		}
	}
	
	public static void deleteFile(File file){
		FileUtils.deleteQuietly(file);
	}
	
	public static String getFilePrefix(String fileName){
		if(StringUtils.isNotBlank(fileName)){
			return fileName.substring(fileName.lastIndexOf("."), fileName.length());
		}
		return null;
	}
}
