package com.bts.sp.controller;

import java.util.Properties;
import java.util.UUID;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bts.sp.auth.SHAEncoder;
import com.bts.sp.mapper.UserInfoMapper;
import com.bts.sp.vo.UserInfoVO;

@CrossOrigin(origins = "*")
@RestController
public class SendMailController {
	@Resource
	private UserInfoMapper uim;

	@PostMapping("/mailSender") 
	public String mailSender(@RequestBody UserInfoVO uv ,HttpServletRequest request) throws AddressException, MessagingException { 
		// 네이버일 경우 smtp.naver.com 을 입력합니다. 
		// Google일 경우 smtp.gmail.com 을 입력합니다. 
		String host = "smtp.gmail.com"; 
		
		// 비밀번호 찾기 시 메일을 보낼 계정의 메일주소와 비밀번호를 입력합니다.
		final String username = "testbts11@gmail.com"; 
		final String password = "dbsdbs1234!"; 

		
		String uEmail = uv.getUiEmail();
		int port=465; 
		// 포트번호 
		// 메일 내용 
		String recipient = uEmail; 
		//받는 사람의 메일주소를 갖고옵니다.
		
		String uiPwd="";
	    uiPwd = UUID.randomUUID().toString(); 
		String subject = "회원님의 임시 비밀번호는 " + uiPwd +  " 입니다."; 
		
		//임의의 비밀번호로 수정하기
		UserInfoVO user = new UserInfoVO();
		user.setUiPwd(SHAEncoder.encode(uiPwd));
		user.setUiEmail(uEmail);
		uim.updatePwd(user);
		
		//메일을 보낼시 아래의 스트링으로 메일이 보내집니다. 
		String body = username+"님으로 부터 메일을 받았습니다."; 
		//메일 내용 입력해주세요. 
		Properties props = System.getProperties(); 
		// 정보를 담기 위한 객체 생성 
		// SMTP 서버 정보 설정 
		
		props.put("mail.smtp.host", host); 
		props.put("mail.smtp.port", port); 
		props.put("mail.smtp.auth", "true"); 
		props.put("mail.smtp.ssl.enable", "true"); 
		props.put("mail.smtp.ssl.trust", host); 
		
		//Session 생성 
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			String un=username; 
			String pw=password; 
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() { 
				return new javax.mail.PasswordAuthentication(un, pw); 
				} 
			}); 
		session.setDebug(true); 
		//for debug 
		Message mimeMessage = new MimeMessage(session); 
		//MimeMessage 생성 
		mimeMessage.setFrom(new InternetAddress(username)); 
		//발신자 셋팅 , 보내는 사람의 이메일주소를 한번 더 입력합니다. 이때는 이메일 풀 주소를 다 작성해주세요. 
		mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); 
		//수신자셋팅
		//.TO 외에 .CC(참조) .BCC(숨은참조)
		mimeMessage.setSubject(subject); 
		//제목셋팅
		mimeMessage.setText(body); 
		//내용셋팅 
		Transport.send(mimeMessage); 
		//javax.mail.Transport.send()
		return "success";
		
		}
	}