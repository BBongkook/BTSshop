package com.bts.sp.auth;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

@Component
public class SHAEncoder {
	// 인코딩 타입과 케릭터셋 솔트 값을 넣을 변수 선언과 동시에 값을 넣어준다.
	private static final String ENCODE_TYPE="SHA-256";
	private static final String CHAR_SET="UTF-8";
	private static final String SALT="bts";
	
	public static String encode(String pwd) {
		try {
			MessageDigest md = MessageDigest.getInstance(ENCODE_TYPE);
			byte[] salts = SALT.getBytes(CHAR_SET);
			byte[] pwds = pwd.getBytes(CHAR_SET);
			byte[] bytes = new byte[salts.length+pwds.length];
			System.arraycopy(salts, 0, bytes, 0, salts.length);
			System.arraycopy(pwds, 0, bytes, salts.length, pwds.length);
			byte[] digestBytes = md.digest(bytes);
			StringBuffer sb = new StringBuffer();
			for(byte db:digestBytes) {
				int i = (db & 0xFF)+256;
				String s = Integer.toString(i,16).substring(1);
				sb.append(s);
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static boolean match(String pwd, String encodePwd) {
		
		return encodePwd.equals(encode(pwd));
	}
}
