package com.bts.sp.vo;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
@Alias("product")
public class ProductVO {
	private Integer pNum;
	private String pName;
	private Integer pAmount;
	private Integer pPrice;
	private Integer pPriceTmp;
	private String pImageUri;
	private MultipartFile pImageFile;
	private String pCredat;
	private String pLarge;
	private String pMedium;
	private String pSmall;
	private String pContent;
	private Integer pCount;
	
	
}
