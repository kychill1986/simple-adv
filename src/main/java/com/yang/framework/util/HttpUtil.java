package com.yang.framework.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.log4j.Logger;

public class HttpUtil {

	/** 日志记录器 */
	private static Logger log = Logger.getLogger(HttpUtil.class);

	public static String postStream(String url, NameValuePair[] parameters) {
		PostMethod postMethod = new PostMethod(url);
		HttpClient client = new HttpClient();
		String result = null;

		try {
			postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");

			postMethod.addParameters(parameters);

			client.getHttpConnectionManager().getParams().setConnectionTimeout(50000);// 设置连接时间
			int status = client.executeMethod(postMethod);
			if (status == HttpStatus.SC_OK) {
				result = postMethod.getResponseBodyAsString();
			} else {
				log.info("fail -- " + status);
				log.info(postMethod.getResponseBodyAsString());
			}
		}
		catch (Exception e) {
			log.error("Post 请求出现异常" + e);
		}
		finally {
			// 释放连接
			postMethod.releaseConnection();
			client.getHttpConnectionManager().closeIdleConnections(0);
		}
		return result;
	}

	public static String get(String url) throws Exception {
		GetMethod getMethod = new GetMethod(url);
		HttpClient client = new HttpClient();
		String result = null;

		try {
			getMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");

			client.getHttpConnectionManager().getParams().setConnectionTimeout(50000);// 设置连接时间
			int status = client.executeMethod(getMethod);
			if (status == HttpStatus.SC_OK) {
				InputStream inputStream = getMethod.getResponseBodyAsStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
				StringBuffer stringBuffer = new StringBuffer();
				String str = "";
				while ((str = br.readLine()) != null) {
					stringBuffer.append(str);
				}
				result = stringBuffer.toString();
			} else {
				log.info("fail -- " + status);
			}
		}
		catch (Exception e) {
			log.error("Get 请求出现异常" + e);
			throw new Exception();
		}
		finally {
			// 释放连接
			getMethod.releaseConnection();
			client.getHttpConnectionManager().closeIdleConnections(0);
		}
		return result;
	}

}
