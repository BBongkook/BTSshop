package com.bts.sp.service;

import java.util.List;

import com.bts.sp.vo.OrderVO;

public interface OrderTableService {
	//주문내역조회
	List<OrderVO> selectOrderListById(String uiId);
	//장바구니추가
	Integer insertProduct(OrderVO ov);
	//주문내역삭제
	Integer deleteProduct(Integer orNum);
}
