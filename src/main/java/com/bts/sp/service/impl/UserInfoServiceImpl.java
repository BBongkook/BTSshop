package com.bts.sp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bts.sp.auth.MakeJWT;
import com.bts.sp.auth.SHAEncoder;
import com.bts.sp.mapper.UserInfoMapper;
import com.bts.sp.service.UserInfoService;
import com.bts.sp.vo.UserInfoVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {

	@Resource
	private UserInfoMapper uim;


	@Override
	public UserInfoVO selectUserInfoByIdPwd(UserInfoVO ui) {
		String ePwd = SHAEncoder.encode(ui.getUiPwd());
		ui.setUiPwd(ePwd);
		UserInfoVO uv = uim.selectUserInfoByIdPwd(ui);
		if (uv != null) {
			MakeJWT mjwt = new MakeJWT();
			String jwt = mjwt.makeJWT(uv);
			log.info("------------------------------------------------{}",jwt);
			uv.setUiToken(jwt);
			return uv;
		}
		return null;
	}
	
	//회원가입
	@Override
	public Integer insertUser(UserInfoVO ui) {
		ui.setUiPwd(SHAEncoder.encode(ui.getUiPwd()));
		return uim.insertUser(ui);
	}

	@Override
	public Integer deleteUser(String userNum) {
		if(userNum.indexOf("[")!=-1) {
			String userNumCut = userNum.substring(1,userNum.length()-1);
			String userNumArray[] = userNumCut.split(",");
			Integer cnt =0;
			for(int i=0; i<userNumArray.length; i++) {
				Integer convertUserNum = Integer.parseInt(userNumArray[i]);
				cnt += uim.deleteUser(convertUserNum);
			}
			if(cnt>0) {
				return cnt;
			}
		}else {
			Integer convertUserNum = Integer.parseInt(userNum);
			return uim.deleteUser(convertUserNum);
		}
		
		return null;
	}

	@Override
	public List<UserInfoVO> selectUserInfoList() {
		return uim.selectUserInfoList();
	}

	@Override
	public UserInfoVO selectUserById(String uiId) {
		return uim.selectUserById(uiId);
	}

	@Override
	public Integer updateUser(UserInfoVO ui) {
		if(ui.getUiPwd()!=null) {
			ui.setUiPwd(SHAEncoder.encode(ui.getUiPwd()));
		}		
		return uim.updateUser(ui);
	}


	@Override
	public UserInfoVO selectuserIdByNameEmail(UserInfoVO ui) {
		return uim.selectuserIdByNameEmail(ui);
	}

	@Override
	public UserInfoVO selectUserPwdByIdEmail(UserInfoVO ui) {
		
		
		return uim.selectUserPwdByIdEmail(ui);
	}
	
	
}
