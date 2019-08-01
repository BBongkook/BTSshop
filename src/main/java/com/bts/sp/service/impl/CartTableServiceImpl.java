package com.bts.sp.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bts.sp.mapper.CartTableMapper;
import com.bts.sp.service.CartTableService;
import com.bts.sp.vo.CartVO;
import com.bts.sp.vo.NoticeVO;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class CartTableServiceImpl implements CartTableService {

	@Resource
	private CartTableMapper ctm;
	
	// 장바구니 조회
	@Override
	public List<CartVO> selectCartListById(String uiId) {
		return ctm.selectCartListById(uiId);
	}
	
	// 장바구니 추가
	@Override
	public Integer insertCart(CartVO cv) {
		return ctm.insertCart(cv);
	}
	@Override
	public Integer updatePrice(CartVO cv) {
		return ctm.updatePrice(cv);
	}

	@Override
	public Integer delCart(List<Map<String,Integer>> cId) {
		
		// 리스트맵으로 받아온 값을 사이즈 만큼 For문을 돌려서 매퍼 delCart 에 값을 넣어서 사이즈 만큼 수행한다.
		int cnt = 0;
		int ret = 0;
		for(int i=0; i<cId.size(); i++) {
			if(cId.get(i).get("value")!=null) {
				cnt = cId.get(i).get("value");
				System.out.println(cnt);
				ret += ctm.delCart(cnt);
			}
		}
		if(ret>0) {
			return ret;
		}
		return null;
	}

	@Override
	public Integer deluiId(Integer uiId) {
		return ctm.deluiId(uiId);
	}



}
