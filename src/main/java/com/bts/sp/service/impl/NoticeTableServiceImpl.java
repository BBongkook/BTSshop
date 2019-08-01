package com.bts.sp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bts.sp.mapper.NoticeTableMapper;
import com.bts.sp.service.NoticeTableService;
import com.bts.sp.vo.NoticeVO;
import com.bts.sp.vo.UserInfoVO;

@Service
public class NoticeTableServiceImpl implements NoticeTableService {
	@Resource
	private NoticeTableMapper ntm;
	
	// 공지조회
	@Override
	public List<NoticeVO> selectNoticeList() {
		return ntm.selectNoticeList();
	}
	
	// 공지등록
	@Override
	public Integer insertNotice(NoticeVO nv) {
		return ntm.insertNotice(nv);
	}
	
	// 공지삭제
	@Override
	public Integer deleteNotice(Integer ntNum) {
		return ntm.deleteNotice(ntNum);
	}
	// 공지조회수
	@Override
	public Integer updateNtCount(Integer ntNum) {
		return ntm.updateNtCount(ntNum);
	}








	



	

}
