package com.bts.sp.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bts.sp.auth.MakeJWT;
import com.bts.sp.vo.UserInfoVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CheckJWTFilter implements Filter {

	// 유저가 요청시 백엔드에 요청 할 수 있는 url 매핑 주소
	private static final String[] USER_URI = { "/login","/insertCart","/updateUser","/productSearch","/deluser","/deleteCartuiId",
												"/productLists","/productDivide", "/sign", "/mypage", "/favicon","/mailSender", 
												"/resources","/insertProduct","/noticeList","/cartList","/updatePrice","/deleteCart","/userId","/findPwd" };
	
	// 관리자와 유저를 나누고 일반 유저의 url 매핑주소를 체크하는 메소드
	public boolean checkUri(String uri, String uiId) {
		if ("admin".equals(uiId)) {
			return true;
		} else {
			for (String excludeUri : USER_URI) {
				if (uri.indexOf(excludeUri) != -1) {
					return true;
				}
			}
			return false;
		}
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// servlet의 요청과 응답을 HttpServlet으로 바꿔준다.
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		res.setHeader("Access-Control-Allow-Origin", "*");
		res.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
		res.setHeader("Access-Control-Allow-Headers",
				"x-auth-id,x-auth-tokken,Origin,accept,X-Requested-With,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");
		//res.setHeader("Access-Control-Max-Age", "3600");

		Enumeration<String> headerNames = req.getHeaderNames();

		if (headerNames != null) {
			while (headerNames.hasMoreElements()) {
				String name = headerNames.nextElement();
				System.out.println("Header: " + name + " value:" + req.getHeader(name));
			}
		}
		// 요청 방식, 요청 주소, http 헤더에 있는 아이디와 토큰 값도 받아온다.
		String method = req.getMethod();
		String uri = req.getRequestURI();
		String uiId = req.getHeader("X-AUTH-ID");
		String tokken = req.getHeader("X-AUTH-TOKKEN");

		if (uiId != null) {
			if (checkUri(uri, uiId)) {
				try {
					UserInfoVO ui = new UserInfoVO();
					ui.setUiId(uiId);
					MakeJWT.checkJWT(tokken, ui);
				} catch (Exception e) {
					throw new ServletException("토큰키가 올바르지 않다.");
				}

			} else {
				throw new ServletException("올바른 요청이 아닙니다.");
			}
		}

		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
}
