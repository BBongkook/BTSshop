package com.bts.sp.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("cart")
public class CartVO {
	private Integer cId;
	private String uiId;
	private Integer pNum;
	private Integer cAmount;
	private Integer cPrice;
	private String pName;
	private Integer pPrice;
	private String pImageUri;
}
