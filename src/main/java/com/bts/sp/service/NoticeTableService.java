package com.bts.sp.service;

import java.util.List;

import com.bts.sp.vo.NoticeVO;
import com.bts.sp.vo.UserInfoVO;

public interface NoticeTableService {
	// 공지조회
	List<NoticeVO> selectNoticeList();
	// 공지삭제
	Integer deleteNotice(Integer ntNum);
	// 공지등록
	Integer insertNotice(NoticeVO nv);
	// 조회수증가
	Integer updateNtCount(Integer ntNum);
	

}
