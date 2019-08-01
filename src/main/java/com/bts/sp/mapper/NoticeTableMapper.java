package com.bts.sp.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.bts.sp.vo.NoticeVO;
import com.bts.sp.vo.UserInfoVO;

@MapperScan
public interface NoticeTableMapper {
	//공지조회
	List<NoticeVO> selectNoticeList();
	//공지삭제
	Integer deleteNotice(Integer ntNum);
	//공지등록
	Integer insertNotice(NoticeVO nv);
	//조회수증가
	Integer updateNtCount(Integer ntNum);
}
