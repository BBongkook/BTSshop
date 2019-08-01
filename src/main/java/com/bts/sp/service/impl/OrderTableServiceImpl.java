package com.bts.sp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bts.sp.mapper.OrderTableMapper;
import com.bts.sp.service.OrderTableService;
import com.bts.sp.vo.OrderVO;

@Service
public class OrderTableServiceImpl implements OrderTableService {
	@Resource
	private OrderTableMapper otm;
	@Override
	public List<OrderVO> selectOrderListById(String uiId) {
		return otm.selectOrderListById(uiId);
	}
	@Override
	public Integer insertProduct(OrderVO ov) {
		return otm.insertProduct(ov);
	}
	@Override
	public Integer deleteProduct(Integer orNum) {
		return otm.deleteProduct(orNum);
	}

}
