package com.bts.sp.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bts.sp.mapper.ProductTableMapper;
import com.bts.sp.service.ProductTableService;
import com.bts.sp.vo.ProductVO;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class ProductTableServiceImpl implements ProductTableService {

	private final String BASE = "C:\\Users\\Administrator\\git\\shop-bts\\src\\main\\webapp\\resources\\upload\\";
	
	@Resource
	private ProductTableMapper ptm;
	
	//상품조회
	@Override
	public List<ProductVO> selectProductList() {
		return ptm.selectProductList();
	}

	//상품등록
	@Override
	public Integer insertProduct(ProductVO pv) {
		// 멀티파트파일로 파일입력을 한다.
		MultipartFile pvImageFile = pv.getPImageFile();
		String fileName = pvImageFile.getOriginalFilename();
		String extName = FilenameUtils.getExtension(fileName);
		String reName = Long.toString(System.nanoTime());
		
		reName += "."+extName;
		
		File targetFile = new File(BASE + reName);
		try {
		Files.copy(pvImageFile.getInputStream(),targetFile.toPath());
		} catch(IOException e) {
			e.printStackTrace();
		}
		pv.setPImageUri(reName);
		log.info("=>{}",pv);
		return ptm.insertProduct(pv);
	}

	//상품 다중삭제
	@Override
	public Integer deleteProduct(Integer pNums){
		return ptm.deleteProduct(pNums);
	}
	
	//상품수정
	@Override
	public Integer updateProduct(ProductVO pv) {
		
		return ptm.updateProduct(pv);
	}
	
	//상품검색
	@Override
	public List<ProductVO> searchProduct(String pName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//카테고리
	@Override
	public List<ProductVO> selectCategorie(ProductVO pv) {
		return ptm.selectCategorie(pv);
	}
	//대분류 조회
	@Override
	public List<ProductVO> selectProductDivide(String pLarge) {
		ProductVO pv = new ProductVO();
		pv.setPLarge(pLarge);
		if(pLarge.indexOf("&")!=-1) {
			Integer cutPdivideNum = pLarge.indexOf("&");
			Object cutPdividieStr = pLarge.substring(cutPdivideNum+1);
			
			String cutPlargeStr = pLarge.substring(0,cutPdivideNum);
			
			System.out.println(cutPlargeStr);
			System.out.println(cutPdividieStr);
			pv.setPLarge(cutPlargeStr);
			if("pPrice".equals(cutPdividieStr)) {
				pv.setPPrice(1);
				System.out.println(pv);
			}
			else if("pCount".equals(cutPdividieStr)) {
				pv.setPCount(1);
				System.out.println(pv);
			}
			else if("pCredat".equals(cutPdividieStr)) {
				pv.setPCredat("Y");
				System.out.println(pv);
			}else if("pPriceTmp".equals(cutPdividieStr)) {
				pv.setPPriceTmp(1);
			}
		}
		return ptm.selectProductDivide(pv);
	}

	@Override
	public List<ProductVO> selectProductByPName(String pName) {
		return ptm.selectProductByPName(pName);
	}

	//조회수별 상품조회
	@Override
	public List<ProductVO> selectProductListBypCount() {
		return ptm.selectProductListBypCount();
	}

	//상품 뷰 페이지
	@Override
	public List<ProductVO> selectProductViewPage(Integer pNum) {
		ptm.updateCount(pNum);
		return ptm.selectProductViewPage(pNum);
	}


}
