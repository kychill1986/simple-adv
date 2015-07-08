package com.yang.framework.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.Transaction;
import redis.clients.jedis.exceptions.JedisException;

public class JedisUtil {
	private static Log log = LogFactory.getLog(JedisUtil.class);

	private String address;
	private Jedis jedis;
	private ShardedJedis shardedJedis;

	JedisPoolConfig jpc;
	JedisPool pool;
	ShardedJedisPool shardedJedisPool;
	
	public JedisUtil(){
	}

	/**
	 * 初始化 Redis
	 */
	public void init() {
		if (address != null && jpc != null) {
			String[] addressArr = address.split(":");
			
			pool = new JedisPool(jpc, addressArr[0], Integer.parseInt(addressArr[1]), 100000);
			
			log.info("JedisUtil started  .....");
		} else {
			log.info("miss params JedisUtil init faily  .....");
		}
	}

	/**
	 * 关闭 Redis
	 */
	public void destory() {
		pool.destroy();
		
		log.info("JedisUtil destoryed  .....");
	}

	
	/*****************list******************************/
	/**
	 * redis的List集合 ，向key这个list添加元素
	 * 
	 * @param key
	 *            List别名
	 * @param string
	 *            元素
	 * @return
	 */
	public long rpush(String key, String string) {
		long ret = -1;
		try {
			jedis = pool.getResource();
			ret = jedis.rpush(key, string);
			pool.returnResource(jedis);
			
		} catch (Exception e) {
			log.info(e);
			if (jedis != null) {
				pool.returnBrokenResource(jedis);
			}
			throw new JedisException(e);
		} finally {
			if (jedis != null) {
				pool.returnBrokenResource(jedis);
			}
		}
		
		return ret;
	}
	
	public synchronized long lpush(String key, String string) {
		try {
			jedis = pool.getResource();
			long ret = jedis.lpush(key, string);
			pool.returnResource(jedis);
			return ret;
		} catch (Exception e) {
			log.info(e);
			if (jedis != null) {
				pool.returnBrokenResource(jedis);
			}
			throw new JedisException(e);
		} finally {
			if (jedis != null) {
				pool.returnBrokenResource(jedis);
			}
		}
	}
	
	public synchronized List<Object> lpushWithTrans(String key, List<String> infos) {
		try {
			jedis = pool.getResource();
			Transaction tx = jedis.multi();
			
			for (String string : infos) {
				tx.lpush(key, string);
			}
			
			List<Object> results = tx.exec();
			
			pool.returnResource(jedis);
			
			return results;
		} catch (Exception e) {
			log.info(e);
			if (jedis != null) {
				pool.returnBrokenResource(jedis);
			}
			throw new JedisException(e);
		} finally {
			if (jedis != null) {
				pool.returnBrokenResource(jedis);
			}
		}
	}
	
	public synchronized long lpushWithPipelined(String key, String string) {
		try {
			jedis = pool.getResource();
			Pipeline pipeline = jedis.pipelined();
			pipeline.lpush(key, string);
			
			List<Object> results = pipeline.syncAndReturnAll();
			
			pool.returnResource(jedis);
			
			long ret = 0;
			
			if (results != null && results.size() > 0) {
				ret = (Long) results.get(0);
			}
			
			return ret;
		} catch (Exception e) {
			log.info(e);
			if (jedis != null) {
				pool.returnBrokenResource(jedis);
			}
			throw new JedisException(e);
		} finally {
			if (jedis != null) {
				pool.returnBrokenResource(jedis);
			}
		}
	}
	
	public synchronized List<Object> lpushWithPipelined(String key, List<String> infos) {
		try {
			jedis = pool.getResource();
			Pipeline pipeline = jedis.pipelined();
			
			for (String string : infos) {
				pipeline.lpush(key, string);
			}
			
			List<Object> results = pipeline.syncAndReturnAll();
			
			pool.returnResource(jedis);
			
			return results;
		} catch (Exception e) {
			log.info(e);
			if (jedis != null) {
				pool.returnBrokenResource(jedis);
			}
			throw new JedisException(e);
		} finally {
			if (jedis != null) {
				pool.returnBrokenResource(jedis);
			}
		}
	}

	/**
	 * 获取key这个List，从第几个元素到第几个元素 LRANGE key start
	 * stop返回列表key中指定区间内的元素，区间以偏移量start和stop指定。
	 * 下标(index)参数start和stop都以0为底，也就是说，以0表示列表的第一个元素，以1表示列表的第二个元素，以此类推。
	 * 也可以使用负数下标，以-1表示列表的最后一个元素，-2表示列表的倒数第二个元素，以此类推。
	 * 
	 * @param key
	 *            List别名
	 * @param start
	 *            开始下标
	 * @param end
	 *            结束下标
	 * @return
	 */
	public List<String> lrange(String key, long start, long end) {
		try {
			jedis = pool.getResource();
			List<String> ret = jedis.lrange(key, start, end);
			pool.returnResource(jedis);
			return ret;
		} catch (Exception e) {
			log.info(e);
			if (jedis != null) {
				pool.returnBrokenResource(jedis);
			}
			throw new JedisException(e);
		}
	}

	/*****************string******************************/
	/**
	 * 向key赋值
	 * 
	 * @param key
	 * @param value
	 */
	public synchronized void set(String key, String value) {
		try {
			jedis = pool.getResource();
			jedis.set(key, value);
			pool.returnResource(jedis);
		} catch (Exception e) {
			log.info(e);
			if (jedis != null) {
				pool.returnBrokenResource(jedis);
			}
			throw new JedisException(e);
		}
	}

	/**
	 * 获取key的值
	 * 
	 * @param key
	 * @return
	 */
	public synchronized String get(String key) {
		try {
			jedis = pool.getResource();
			String value = jedis.get(key);
			pool.returnResource(jedis);
			return value;
		} catch (Exception e) {
			log.info(e);
			if (jedis != null) {
				pool.returnBrokenResource(jedis);
			}
			throw new JedisException(e);
		}
	}
	
	/**
	 * 给key赋值，并生命周期设置为seconds
	 * 
	 * @param key
	 * @param seconds
	 *            生命周期 秒为单位
	 * @param value
	 */
	public void setex(String key, int seconds, String value) {
		try {
			jedis = pool.getResource();
			jedis.setex(key, seconds, value);
			pool.returnResource(jedis);
		} catch (Exception e) {
			log.info(e);
			if (jedis != null) {
				pool.returnBrokenResource(jedis);
			}
			throw new JedisException(e);
		}
	}

	/**
	 * 为给定key设置生命周期
	 * 
	 * @param key
	 * @param seconds
	 *            生命周期 秒为单位
	 */
	public synchronized void expire(String key, int seconds) {
		try {
			jedis = pool.getResource();
			jedis.expire(key, seconds);
			pool.returnResource(jedis);
		} catch (Exception e) {
			log.info(e);
			if (jedis != null) {
				pool.returnBrokenResource(jedis);
			}
			throw new JedisException(e);
		}
	}
	
	/**
	 * 如果key已经存在并且是一个字符串，将value追加到key原来的值之后
	 * 
	 * @param key
	 * @param value
	 */
	public void append(String key, String value) {
		try {
			jedis = pool.getResource();
			jedis.append(key, value);
			pool.returnResource(jedis);
		} catch (Exception e) {
			log.info(e);
			if (jedis != null) {
				pool.returnBrokenResource(jedis);
			}
			throw new JedisException(e);
		}
	}
	
	/**
	 * 检查key是否存在
	 * 
	 * @param key
	 * @return
	 */
	public boolean exists(String key) {
		try {
			jedis = pool.getResource();
			boolean bool = jedis.exists(key);
			pool.returnResource(jedis);
			return bool;
		} catch (Exception e) {
			log.info(e);
			if (jedis != null) {
				pool.returnBrokenResource(jedis);
			}
			throw new JedisException(e);
		}
	}

	/**
	 * 返回key值的类型 none(key不存在),string(字符串),list(列表),set(集合),zset(有序集),hash(哈希表)
	 * 
	 * @param key
	 * @return
	 */
	public String type(String key) {
		try {
			jedis = pool.getResource();
			String type = jedis.type(key);
			pool.returnResource(jedis);
			return type;
		} catch (Exception e) {
			log.info(e);
			if (jedis != null) {
				pool.returnBrokenResource(jedis);
			}
			throw new JedisException(e);
		}
	}
	
	/*****************hash******************************/
	/**
	 * 将哈希表key中的域field的值设为value。
	 * 
	 * @param key
	 *            哈希表别名
	 * @param field键
	 * @param value
	 *            值
	 */
	public synchronized void hset(String key, String field, String value) {
		try {
			jedis = pool.getResource();
			jedis.hset(key, field, value);
			pool.returnResource(jedis);
		} catch (Exception e) {
			log.info(e);
			if (jedis != null) {
				pool.returnBrokenResource(jedis);
			}
			throw new JedisException(e);
		}
	}

	/**
	 * 从哈希表key中获取field的value
	 * 
	 * @param key
	 * @param field
	 */
	public synchronized String hget(String key, String field) {
		try {
			jedis = pool.getResource();
			String value = jedis.hget(key, field);
			pool.returnResource(jedis);
			return value;
		} catch (Exception e) {
			log.info(e);
			if (jedis != null) {
				pool.returnBrokenResource(jedis);
			}
			throw new JedisException(e);
		}
	}

	/**
	 * 将多个field - value(域-值)对设置到哈希表key中。
	 * 
	 * @param key
	 * @param map
	 */
	public synchronized void hmset(String key, Map<String, String> map) {
		try {
			jedis = pool.getResource();
			jedis.hmset(key, map);
			pool.returnResource(jedis);
		} catch (Exception e) {
			log.info(e);
			if (jedis != null) {
				pool.returnBrokenResource(jedis);
			}
			throw new JedisException(e);
		}
	}
	
	/**
	 * 
	 * @param key
	 * @param fields
	 * @return
	 */
	public synchronized List<String> hmget(String key, String... fields ) {
		try {
			jedis = pool.getResource();
			List<String> values = jedis.hmget(key, fields);
			pool.returnResource(jedis);
			return values;
		} catch (Exception e) {
			log.info(e);
			if (jedis != null) {
				pool.returnBrokenResource(jedis);
			}
			throw new JedisException(e);
		}
	}
	
	
	/**
	 * 返回哈希表key中，所有的域和值
	 * 
	 * @param key
	 * @return
	 */
	public Map<String, String> hgetAll(String key) {
		try {
			jedis = pool.getResource();
			Map<String, String> map = jedis.hgetAll(key);
			pool.returnResource(jedis);
			return map;
		} catch (Exception e) {
			log.info(e);
			if (jedis != null) {
				pool.returnBrokenResource(jedis);
			}
			throw new JedisException(e);
		}

	}
	
	

	/**
	 * 
	 * @param key
	 * @param field
	 * @return
	 */
	public boolean hexists(String key, String field) {
		try {
			jedis = pool.getResource();
			boolean bool = jedis.hexists(key, field);
			pool.returnResource(jedis);
			return bool;
		} catch (Exception e) {
			log.info(e);
			if (jedis != null) {
				pool.returnBrokenResource(jedis);
			}
			throw new JedisException(e);
		}
	}
	
	/**
	 * 
	 * @param key
	 * @param fields
	 * @return
	 */
	public long hdel(String key, String... fields) {
		try {
			jedis = pool.getResource();
			long number = jedis.hdel(key, fields);
			pool.returnResource(jedis);
			return number;
		} catch (Exception e) {
			log.info(e);
			if (jedis != null) {
				pool.returnBrokenResource(jedis);
			}
			throw new JedisException(e);
		}
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public long hlen(String key) {
		try {
			jedis = pool.getResource();
			long len = jedis.hlen(key);
			pool.returnResource(jedis);
			return len;
		} catch (Exception e) {
			log.info(e);
			if (jedis != null) {
				pool.returnBrokenResource(jedis);
			}
			throw new JedisException(e);
		}
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public Set<String> hkeys(String key) {
		try {
			jedis = pool.getResource();
			Set<String> set = jedis.hkeys(key);
			pool.returnResource(jedis);
			return set;
		} catch (Exception e) {
			log.info(e);
			if (jedis != null) {
				pool.returnBrokenResource(jedis);
			}
			throw new JedisException(e);
		}
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public List<String> hvals(String key) {
		try {
			jedis = pool.getResource();
			List<String> list = jedis.hvals(key);
			pool.returnResource(jedis);
			return list;
		} catch (Exception e) {
			log.info(e);
			if (jedis != null) {
				pool.returnBrokenResource(jedis);
			}
			throw new JedisException(e);
		}
	}

	
	/*****************set******************************/
	/**
	 * 返回哈希表key中，所有的域和值
	 * 
	 * @param key
	 * @return
	 */
	public Set<?> smembers(String key) {
		try {
			jedis = pool.getResource();
			Set<?> set = jedis.smembers(key);
			pool.returnResource(jedis);
			return set;
		} catch (Exception e) {
			log.info(e);
			if (jedis != null) {
				pool.returnBrokenResource(jedis);
			}
			throw new JedisException(e);
		}
	}

	/**
	 * 移除集合中的member元素
	 * 
	 * @param key
	 *            List别名
	 * @param field
	 *            键
	 */
	public void delSetObj(String key, String field) {
		try {
			jedis = pool.getResource();
			jedis.srem(key, field);
			pool.returnResource(jedis);
		} catch (Exception e) {
			log.info(e);
			if (jedis != null) {
				pool.returnBrokenResource(jedis);
			}
			throw new JedisException(e);
		}
	}

	/**
	 * 判断member元素是否是集合key的成员。是（true），否则（false）
	 * 
	 * @param key
	 * @param field
	 * @return
	 */
	public boolean isNotField(String key, String field) {
		try {
			jedis = pool.getResource();
			boolean bool = jedis.sismember(key, field);
			pool.returnResource(jedis);
			return bool;
		} catch (Exception e) {
			log.info(e);
			if (jedis != null) {
				pool.returnBrokenResource(jedis);
			}
			throw new JedisException(e);
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public JedisPoolConfig getJpc() {
		return jpc;
	}

	public void setJpc(JedisPoolConfig jpc) {
		this.jpc = jpc;
	}

	public Jedis getJedis() {
		return jedis;
	}

	public void setJedis(Jedis jedis) {
		this.jedis = jedis;
	}

	public ShardedJedis getShardedJedis() {
		return shardedJedis;
	}

	public void setShardedJedis(ShardedJedis shardedJedis) {
		this.shardedJedis = shardedJedis;
	}

	public JedisPool getPool() {
		return pool;
	}

	public void setPool(JedisPool pool) {
		this.pool = pool;
	}

	public ShardedJedisPool getShardedJedisPool() {
		return shardedJedisPool;
	}

	public void setShardedJedisPool(ShardedJedisPool shardedJedisPool) {
		this.shardedJedisPool = shardedJedisPool;
	}
}
