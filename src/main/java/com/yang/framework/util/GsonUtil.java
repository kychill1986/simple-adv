package com.yang.framework.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {

	public static String toJson(Object object){
		Gson gs = new GsonBuilder().disableHtmlEscaping().create();
		
		return gs.toJson(object);
	}
}
