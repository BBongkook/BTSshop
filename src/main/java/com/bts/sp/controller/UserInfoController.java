package com.bts.sp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bts.sp.service.UserInfoService;
import com.bts.sp.vo.UserInfoVO;

@CrossOrigin(origins = "*")
@RestController
public class UserInfoController {

	@Resource
	private UserInfoService uis;

	// 유저 전체조회 로직.
	@GetMapping("/userlist")
	public List<UserInfoVO> selectUserInfoList() {
		return uis.selectUserInfoList();
	}
	// 아이디 중복확인 로직 + 단건조회
	@GetMapping("/userId/{uiId}")
	public UserInfoVO selectUserById(@PathVariable("uiId") String uiId) {
		return uis.selectUserById(uiId);
	}
	// 아이디 찾기 로직.
	@PostMapping("/userId")
	public UserInfoVO selectUserIdByNameEmail(@RequestBody UserInfoVO ui) {
		return uis.selectuserIdByNameEmail(ui);
		
	}
	//비밀번호 찾기 로직.
	@PostMapping("/findPwd")
	public UserInfoVO selectUserPwdByIdEmail(@RequestBody UserInfoVO ui) {
		return uis.selectUserPwdByIdEmail(ui);
	}
	// 로그인 로직.
	@PostMapping("/login")
	public UserInfoVO selectUserInfoByIdPwd(@RequestBody UserInfoVO ui) {
		return uis.selectUserInfoByIdPwd(ui);
	}
	// 회원가입 로직.
	@PostMapping("/signup")
	public Integer insertUser(@RequestBody UserInfoVO ui) {
		return uis.insertUser(ui);
	}
	// 회원탈퇴,삭제.
	@DeleteMapping("/deluser")
	public Integer deleteUser(@RequestBody String userNum) {
		return uis.deleteUser(userNum);
	}
	//회원정보 수정
	@PutMapping("/updateUser")
	public Integer updateUser(@RequestBody UserInfoVO ui) {
		return uis.updateUser(ui);
	}
}
