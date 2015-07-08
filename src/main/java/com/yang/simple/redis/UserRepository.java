package com.yang.simple.redis;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class UserRepository {

	@Resource
	private RedisTemplate<String, String> jedisTemplate;

	/** add Operate start **/
	public void saveUser(String value) {
		getValueOperations().set(KeyUtils.userKey(), value);
	}

	/** get Operate start **/
	public String getUser() {
		return getValueOperations().get(KeyUtils.userKey());
	}

	/** delete Operate start **/

	/** base Operate start **/
	private ValueOperations<String, String> getValueOperations() {
		return jedisTemplate.opsForValue();
	}
}
