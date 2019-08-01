package com.bts.sp.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.bts.sp.vo.UserInfoVO;

@MapperScan
public interface UserInfoMapper {
	// 유저리스트 조회
	List<UserInfoVO> selectUserInfoList();
	// 로그인
	UserInfoVO selectUserInfoByIdPwd(UserInfoVO ui);
	// 아이디 찾기
	UserInfoVO selectuserIdByNameEmail(UserInfoVO ui);
	// 비밀번호 찾기
	UserInfoVO selectUserPwdByIdEmail(UserInfoVO ui);
	// 임의 비밀번호 수정
	Integer updatePwd(UserInfoVO ui);
	// 회원가입
	Integer insertUser(UserInfoVO ui);
	// 회원탈퇴
	Integer deleteUser(Integer rn);
	// 마이페이지 정보수정
	Integer updateUser(UserInfoVO ui);
	// 아이디별 유저정보 조회
	UserInfoVO selectUserById(String uiId);
}
