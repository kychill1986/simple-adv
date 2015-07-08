package com.yang.simple.redis;

abstract class KeyUtils {

	static final String USER = "user";

	static String userKey() {
		return USER;
	}

}