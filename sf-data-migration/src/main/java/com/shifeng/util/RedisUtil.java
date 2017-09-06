package com.shifeng.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
*    
* 项目名称：
* 类名称：RedisUtil   
* 类描述：   
* 创建人： 勇士
* 创建时间：2016年8月27日 09:32:04
*
 */
public   class RedisUtil {


	private static JedisPool jedisPool ;

	public JedisPool getJedisPool() {
		return jedisPool;
	}

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}

	/**
	 * 插入key-val键值数据
	 */
	public static void set(String key, String val) {

		try (Jedis jedis = jedisPool.getResource()) {
			jedis.set(key, val);
		}
		catch(Exception ex){
			ex.printStackTrace();
			throw ex;
		}

	}
	public static void set(byte[] key, byte[] val) {
		try (Jedis jedis = jedisPool.getResource()) {
			jedis.set(key, val);
		}
		catch(Exception ex){
			ex.printStackTrace();
			throw ex;
		}
	}
	/**
	 * 获取key-val数据
	 */
	public static String get(String key) {

		try (Jedis jedis = jedisPool.getResource()) {
			String val = jedis.get(key);

			return val;
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return "";
	}

	public static byte[] get(byte[] key) {
		try (Jedis jedis = jedisPool.getResource()) {
			return jedis.get(key);
		}
	}




	public static long del(String key) {
		try (Jedis jedis = jedisPool.getResource()) {
			return jedis.del(key);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public static  Long del(byte[] key) {
		try (Jedis jedis = jedisPool.getResource()) {
			return jedis.del(key);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return 0l;
		}
	}
	public  static Set<String> hkeys(String key){
		try (Jedis jedis = jedisPool.getResource()) {
			return jedis.hkeys(key);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}

	}
	public  static Long hdel(byte[] key, byte[]... fields) {
		try (Jedis jedis = jedisPool.getResource()) {
			return jedis.hdel(key,fields);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	/**
	 * 设置key的过期时间
	 */
	public  static long expire(String key, int seconds) {
		try (Jedis jedis = jedisPool.getResource()) {
			long rv = jedis.expire(key, seconds);
			return rv;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	/**
	 * 设置key的过期时间
	 */
	public  static long expire(byte[] key, int seconds) {
		try (Jedis jedis = jedisPool.getResource()) {
			long rv = jedis.expire(key, seconds);
			return rv;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
	}
	public static  String hmset(String key, Map<String, String> hash) {
		try (Jedis jedis = jedisPool.getResource()) {
			return jedis.hmset(key,hash);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}

	public static  String hmset(byte[] key, Map<byte[], byte[]> fields) {
		try (Jedis jedis = jedisPool.getResource()) {
			return jedis.hmset(key,fields);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	public static  List<byte[]> hmget(byte[] key, byte[]... fields) {
		try (Jedis jedis = jedisPool.getResource()) {
			return jedis.hmget(key,fields);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}
	public static  List<String> hmget(String key, String... fields){
		try (Jedis jedis = jedisPool.getResource()) {
			return jedis.hmget(key,fields);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}

	}
	public  static Set<byte[]> hkeys(byte[] key) {
		try (Jedis jedis = jedisPool.getResource()) {
			return jedis.hkeys(key);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}

	}
	public  static Long sadd(byte[] key, byte[] fields) {
		try (Jedis jedis = jedisPool.getResource()) {
			return jedis.sadd(key,fields);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return 0l;
		}
	}
	public  static long hset(byte[] var1, byte[] var2, byte[] var3) {
		try (Jedis jedis = jedisPool.getResource()) {
			return jedis.hset(var1,   var2,   var3);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return 0l;
		}
	}
	public  static long hset(String var1, String var2, String var3) {
		try (Jedis jedis = jedisPool.getResource()) {
			return jedis.hset(var1,   var2,   var3);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return 0l;
		}
	}
	public  static Set<byte[]> smembers(byte[] bytes) {
		try (Jedis jedis = jedisPool.getResource()) {
			return jedis.smembers(bytes);
		}
		catch(Exception ex){
			ex.printStackTrace();
			return null;
		}
	}



}