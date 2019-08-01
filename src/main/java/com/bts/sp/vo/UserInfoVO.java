package com.bts.sp.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("ui")
public class UserInfoVO {
	private Integer uiNum;
	private String uiName;
	private String uiId;
	private String uiPwd;
	private Integer uiTrans;
	private String uiEmail;
	private Integer uiZipcode;
	private String uiAddr;
	private String uiAddr2;
	private String uiPhone;
	private String uiAuth;
	private String uiToken;
}
