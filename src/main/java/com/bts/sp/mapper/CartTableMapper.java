package com.bts.sp.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.bts.sp.vo.CartVO;

@MapperScan
public interface CartTableMapper {
	// 장바구니 조회
	List<CartVO> selectCartListById(String uiId);
	// 장바구니 추가
	Integer insertCart(CartVO cv);
	// 장바구니 가격 수정
	Integer updatePrice(CartVO cv);
	// 장바구니 삭제
	Integer delCart(Integer cId);
	// 결제 후 장바구니 삭제
	Integer deluiId(Integer uiId);
}
