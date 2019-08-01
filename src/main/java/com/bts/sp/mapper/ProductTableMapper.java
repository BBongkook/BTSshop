package com.bts.sp.mapper;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.bts.sp.vo.ProductVO;

@MapperScan
public interface ProductTableMapper {
	//상품조회
	List<ProductVO> selectProductList();
	//조회수별 상품조회
	List<ProductVO> selectProductListBypCount();
	//상품검색
	List<ProductVO> searchProduct(String pName);
	//상품등록
	Integer insertProduct(ProductVO pv);
	//상품삭제
	Integer deleteProduct(Integer pNum);
	//상품수정
	Integer updateProduct(ProductVO pv);
	//카테고리검색
	List<ProductVO> selectCategorie(ProductVO pv);
	//대분류 나누기
	List<ProductVO> selectProductDivide(ProductVO pv);
	//상품검색
	List<ProductVO> selectProductByPName(String pName);
	//상품 뷰 페이지
	List<ProductVO> selectProductViewPage(Integer pNum);
	//조회수 증가
	Integer updateCount(Integer pNum);
}
