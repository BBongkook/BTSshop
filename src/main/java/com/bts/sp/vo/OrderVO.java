package com.bts.sp.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("order")
public class OrderVO {
	private Integer orNum;
	private String orDateTime;
	private Integer orTotalPrice;
	private Integer uiNum;
	private Integer pNum;
	private String pName;

}
