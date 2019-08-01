package com.bts.sp.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("notice")
public class NoticeVO {
	private Integer ntNum;
	private String ntTitle;
	private String ntContent;
	private String ntWriter;
	private String ntCredat;
	private Integer ntCount;
	

}
