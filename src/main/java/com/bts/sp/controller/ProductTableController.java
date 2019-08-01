package com.bts.sp.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bts.sp.service.ProductTableService;
import com.bts.sp.vo.ProductVO;

@CrossOrigin(origins="*")
@RestController

public class ProductTableController {

	@Resource
	private ProductTableService pts;
	
	//상품조회
	@GetMapping("/productLists")
	public List<ProductVO> selectProductLists() {
		return pts.selectProductList();
	}
	
	//상품조회수
	@GetMapping("/productListsBypCount")
	public List<ProductVO> selectProductListsBypCount() {
		return pts.selectProductListBypCount();
		}
	
	//상품등록
	@PostMapping("/insertProduct")
	public Integer insertProduct(MultipartHttpServletRequest request ,ProductVO pv) throws IOException {
		pv.setPImageFile(request.getFile("pimageFile"));
		return pts.insertProduct(pv);
	}
	
	//상품삭제
	@DeleteMapping("/deleteProduct")
	public Integer deleteProduct(@RequestBody Integer pNums) {	
		return  pts.deleteProduct(pNums);
	}
	
	//상품수정
	@PutMapping("/updateProduct")
	public Integer updateProduct(ProductVO pv) {
		return pts.updateProduct(pv);
	}
	
	//카테고리조회
	@PostMapping("/CategorieList")
	public List<ProductVO> selectCategorie(ProductVO pv) {
		return pts.selectCategorie(pv);
	}
	//대분류 조회
	@GetMapping("/productDivide/{pLarge}")
	public List<ProductVO> selectProductDivide(@PathVariable("pLarge") String pLarge){
		return pts.selectProductDivide(pLarge);
	}
	//상품 검색
		@GetMapping("/productSearch/{pName}")
		public List<ProductVO> selectProductSearch(@PathVariable("pName") String pName){
			return pts.selectProductByPName(pName);
	}	
	//상품뷰페이지
	@GetMapping("/productViewPage/{pNum}")
	public List<ProductVO> selectViewProduct(@PathVariable("pNum") String pNum){
		Integer castPnum = Integer.parseInt(pNum);
		return pts.selectProductViewPage(castPnum);
		
	}
}
