package com.iotu.pmx.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SHA256加密工具类
 * @author hanchen
 *
 */
public class SHA256Util {
	private static final Logger log = LoggerFactory.getLogger(SHA256Util.class);
	/**生成盐值
	 * @return 32字节的字符串
	 */
	public static String getSalt(){
		byte[] bytes = new byte[32];
		try {
			SecureRandom sr =  SecureRandom.getInstance("SHA1PRNG");
			sr.nextBytes(bytes);
			return Hex.encodeHexString(bytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	/**将给定字符串按SHA256算法加密
	 * @param originalStr
	 * @return 加密后的字符串 256bit 
	 */
	public static String hash(String originalStr){

		try {
			return Hex.encodeHexString(MessageDigest.getInstance("SHA-256")
					.digest(originalStr.getBytes("UTF-8")));
		} catch (NoSuchAlgorithmException e) {
			log.error(e.getMessage());
			return null;
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage());
			return null;
		}
		
	}
}
