package com.yang.framework.config;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

public class SystemConstants {

	/**
	 * 从Spring的Web 应用根目录监听器获取根目录
	 */
	public static String SYS_ROOT_DIR = System.getProperty("halo-global.root");

	public static String DOWNLOAD_DIR = "\\WEB-INF\\download";

	public static String DOWNLOAD_DIR_REALPATH = SYS_ROOT_DIR + DOWNLOAD_DIR;

	public static File getRealDownloadDir(HttpServletRequest request) {
		String path = request.getSession().getServletContext().getRealPath(DOWNLOAD_DIR);
		return new File(path);
	}
}
