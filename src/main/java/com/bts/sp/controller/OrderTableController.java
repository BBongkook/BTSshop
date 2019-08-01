package com.bts.sp.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bts.sp.service.CartTableService;
import com.bts.sp.service.OrderTableService;
import com.bts.sp.vo.CartVO;
import com.bts.sp.vo.OrderVO;


@CrossOrigin(origins = "*")
@RestController
public class OrderTableController {

	@Resource
	private OrderTableService ots;
	
	// 주문조회
	@GetMapping("/orderList/{uiId}")
	public List<OrderVO> selectOrderListById(@PathVariable("uiId") String uiId){
		return ots.selectOrderListById(uiId);
	}
	
}
