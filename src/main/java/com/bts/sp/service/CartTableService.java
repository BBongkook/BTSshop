package com.bts.sp.service;

import java.util.List;
import java.util.Map;

import com.bts.sp.vo.CartVO;
import com.bts.sp.vo.NoticeVO;
import com.bts.sp.vo.UserInfoVO;

public interface CartTableService {
	// 장바구니 조회
	List<CartVO> selectCartListById(String uiId);
	//장바구니 추가
	Integer insertCart(CartVO cv);
	// 장바구니 가격 수정
	Integer updatePrice(CartVO cv);
	// 장바구니 삭제
	Integer delCart(List<Map<String,Integer>> cId);
	// 결제 후 장바구니 삭제
	Integer deluiId(Integer uiId);
}
