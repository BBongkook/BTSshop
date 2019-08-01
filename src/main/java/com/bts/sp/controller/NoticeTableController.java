package com.bts.sp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bts.sp.service.NoticeTableService;
import com.bts.sp.vo.NoticeVO;


@CrossOrigin(origins = "*")
@RestController
public class NoticeTableController {

	@Resource
	private NoticeTableService nts;

	// 공지조회
	@GetMapping("/noticeList")
	public List<NoticeVO> selectNoticeList() {
		return nts.selectNoticeList();
	}
	
	// 공지등록
	@PostMapping("/insertNotice")
	public Integer insertNotice(@RequestBody NoticeVO nv) {
		System.out.println(nv);
		return nts.insertNotice(nv);
	}
	
	// 공지삭제
	@DeleteMapping("/deleteNotice/{ntNum}")
	public Integer deleteNotice(@PathVariable("ntNum") String ntNum) {
		Integer nt = Integer.parseInt(ntNum);
		System.out.println(nt);
		return nts.deleteNotice(nt);
	}
	// 공지수정
	@PutMapping("/updateNtCount/{ntNum}")
	public Integer updateNtCount(@PathVariable("ntNum") String ntNum) {
		Integer nt = Integer.parseInt(ntNum);
		return nts.updateNtCount(nt);
	}
		
	


		

}
