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
import com.bts.sp.vo.CartVO;


@CrossOrigin(origins = "*")
@RestController
public class CartTableController {

	@Resource
	private CartTableService cts ;
	
	// 장바구니 조회
	@GetMapping("/cartList/{uiId}")
	public List<CartVO> selectCartListById(@PathVariable("uiId") String uiId){
		return cts.selectCartListById(uiId);
	}
	// 장바구니 등록
	@PostMapping("/insertCart")
	public Integer insertCart(CartVO cv) {	
		return cts.insertCart(cv);
	}
	// 장바구니 수량 및 가격
	@PostMapping("/updatePrice")
	public Integer updatePrice(CartVO cv) {
		System.out.println(cv);
		return cts.updatePrice(cv);
	}
	//장바구니 선택삭제
	@DeleteMapping("/deleteCart")
	public Integer deleteCart(@RequestBody List<Map<String,Integer>> params) {	
		return cts.delCart(params);
	}
	//결제 후 장바구니 삭제
	@DeleteMapping("/deleteCartuiId")
	public Integer deleteCartuiId(@RequestBody Integer uiId) {
		System.out.println(uiId);
		return null;
	}
}
