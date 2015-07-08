package com.yang.framework.util;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonUtil {

	public static String toJsonString(List<?> list) {
		JSONArray json = new JSONArray(list);
		return json.toString();
	}

	public static String toJsonString(Object obj) {
		JSONObject json = new JSONObject(obj);
		return json.toString();
	}
}
