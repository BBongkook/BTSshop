package com.bts.sp.service;

import java.util.List;

import com.bts.sp.vo.ProductVO;

public interface ProductTableService {
	//상품조회
	List<ProductVO> selectProductList();
	//조회수별 상품조회
	List<ProductVO> selectProductListBypCount();
	//상품검색
	List<ProductVO> searchProduct(String pName);
	//상품등록
	Integer insertProduct(ProductVO pv);
	//상품삭제
	Integer deleteProduct(Integer pNums);
	//상품수정
	Integer updateProduct(ProductVO pv);
	//카테고리검색
	List<ProductVO> selectCategorie(ProductVO pv);
	//대분류 나누기
	List<ProductVO> selectProductDivide(String pLarge);
	//상품 검색
	List<ProductVO> selectProductByPName(String pName);
	//상품 뷰 페이지
	List<ProductVO> selectProductViewPage(Integer pNum);
}
