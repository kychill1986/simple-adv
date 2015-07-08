package com.yang.framework.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;

public class SMSUtil {

	private Logger logger = Logger.getLogger(getClass().getSimpleName());

	private static final String CID = "148";

	private static final String PASS = "3e634e4e";

	private static final String URL = "http://115.182.89.10:8080/sms/mt";

	private static SMSUtil instance = null;

	private SMSUtil() {
	}

	public static SMSUtil getInstance() {
		if (instance == null) {
			instance = new SMSUtil();
		}
		return instance;
	}

	/**
	 * 发送短信<br>
	 * <p>
	 * 
	 * @param content
	 *            发送内容
	 * @param mobile
	 *            发送手机号（如果有多个手机号，手机号之间用半角逗号分隔开，支持最多1000个号码批量下发）
	 * @return true：发送成功；false：发送失败
	 */
	public boolean sendMessage(String content, String mobile) {
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(URL);
		try {
			NameValuePair[] data = { new NameValuePair("cid", CID), new NameValuePair("pass", PASS), new NameValuePair("content", content), new NameValuePair("mobile", mobile) };
			method.setQueryString(data);

			int responseCode = client.executeMethod(method);
			if (responseCode == HttpStatus.SC_OK) {
				logger.info("发送短信 成功：" + method.getResponseBodyAsString());
				return true;
			}

		}
		catch (Exception e) {
			logger.error("发送短信失败：" + e.getMessage());
		}
		finally {
			if (method != null) {
				method.releaseConnection();
			}
			if (client != null) {
				client.getHttpConnectionManager().closeIdleConnections(0);
			}
		}
		return false;
	}
}
