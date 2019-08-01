package com.bts.sp.auth;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.bts.sp.vo.UserInfoVO;

import lombok.extern.slf4j.Slf4j;


@Component
public class MakeJWT {
	//생성일, 만료일, 솔트값을 넣어줄 변수를 만들어준다.
	private static Date ISSUE_DATE;
	private static Date EXPIRE_DATE;
	private static String SALT = "bts";

	// JWT를 만드는 메소드
	public static String makeJWT(UserInfoVO ui) {
		//현재 시간을 받아와 생성일에 대입 해준다 / 관리자일 경우 1일 일반유저일 경우 30분으로 만료시간을 설정했다.
		Calendar calendar = Calendar.getInstance();
		ISSUE_DATE = calendar.getTime();
		if("admin".equals(ui.getUiId())) {
			calendar.add(Calendar.DATE, 1);
			
		}else {
			calendar.add(calendar.MINUTE, 30);
		}
		EXPIRE_DATE = calendar.getTime();
		String jwt = JWT.create().withIssuer(ui.getUiId()).withIssuedAt(ISSUE_DATE).withExpiresAt(EXPIRE_DATE).sign(Algorithm.HMAC256(SALT));
		return jwt;
	}
	
	// 토큰을 체크하는 메소드
	public static void checkJWT(String token, UserInfoVO ui) {
		// 생성되어 갖고 있던 토큰과 비교하여 체크
		JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SALT)).withIssuer(ui.getUiId()).build();
		DecodedJWT decode = verifier.verify(token);
	}
}
