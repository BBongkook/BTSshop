package com.bts.sp.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.bts.sp.vo.OrderVO;

@MapperScan
public interface OrderTableMapper {
	//주문내역조회
	List<OrderVO> selectOrderListById(String uiId);
	//장바구니추가
	Integer insertProduct(OrderVO ov);
	//주문내역삭제
	Integer deleteProduct(Integer orNum);
	
}
