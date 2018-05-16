package com.wux.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
	private static final char[] HEX_CHARS =
			{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
	private static char[] encodeHex(byte[] bytes) {
		char chars[] = new char[32];
		for (int i = 0; i < chars.length; i = i + 2) {
			byte b = bytes[i / 2];
			chars[i] = HEX_CHARS[(b >>> 0x4) & 0xf];
			chars[i + 1] = HEX_CHARS[b & 0xf];
		}
		return chars;
	}

	/**
	 * spring方法
	 * @param target
	 * @return md5值
	 */
	public static String getMD5(String target) {
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] digestBytes = digest.digest(target.getBytes());
		char[] chars = encodeHex(digestBytes);
		return new String(chars);
	}
	
	public static String getMD5(String password, String salt){
		String target = salt + password;
		StringBuilder stringBuilder = new  StringBuilder();
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] digestBytes = digest.digest(target.getBytes());
		for (byte digestByte : digestBytes) {
			int b = digestByte & 0xff;
			if(b < 0x10){  // 字节为一位时，补零
				stringBuilder.append("0");
			}
			stringBuilder.append(Integer.toHexString(b));
		}
		return stringBuilder.toString();
	}
	/**
	 * 返回长度为count的随机字符串
	 * @param count salt length
	 * @return salt
	 */
	public static String getSalt(int count){
		char[] chars = "abcdefghijklmnopqrstuvwxyz1234567890".toCharArray();
		char[] salt = new char[count];
		for (int i = 0; i < salt.length ; i++) {
			int x = (int)(Math.random() * chars.length);
			salt[i] = chars[x];
		}
		return String.valueOf(salt);
	}

}
