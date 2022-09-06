package com.kh.product.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.product.model.dao.ProductDao;
import com.kh.product.model.vo.Product;
import com.kh.product.model.vo.ProductAttachment;
import com.kh.product.model.vo.ProductCategory;
import com.kh.product.model.vo.Review;

import static com.kh.common.Template.*;

public class ProductService {

	/**
	 * 상품의 카테고리를 조회해주는 서비스
	 * @return
	 */
	public ArrayList<ProductCategory> getCategory() {
		
		Connection conn = getConnection();
		
		ArrayList<ProductCategory> categories = new ProductDao().getCategory(conn);
		
		close(conn);
		
		return categories;
	}

	/**
	 * 상품의 정보와 사진을 각각 VO객체로 받아 DB와 연동하여 INSERT해준다
	 * @param p == 상품VO
	 * @param list == 상품사진VO
	 * @return
	 */
	public int insertProduct(Product p, ArrayList<ProductAttachment> list) {
		
		Connection conn = null;
		int result1 = 0;
		int result2 = 1;
		try {
			conn = getConnection();
		
			result1 = new ProductDao().insertProduct(conn, p);
			result2 = new ProductDao().insertProductAttachmentList(conn, list);
			
			if(result1 * result2 > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
		}finally {
			close(conn);
		}
		
		return(result1 * result2);
	}

	/** 
	 * DB에 올라가 있는 상품중 신상품을 조회해서 반환해준다.
	 * @return
	 */
	public ArrayList<Product> selectNewProduct() {
		
		Connection conn = getConnection();
		
		ArrayList<Product> list = new ProductDao().selectNewProduct(conn);
		
		close(conn);
		
		return list;
	}

	/**
	 * 검색창으로 들어온 검색어를 이용해서 DB에 상품 조회
	 * @param keyword
	 * @return
	 */
	public ArrayList<Product> searchProduct(String keyword) {
		
		Connection conn = getConnection();
		
		ArrayList<Product> searchList = new ProductDao().searchProduct(conn, keyword);
		
		close(conn);
		
		return searchList;
	}

	public Product selectProduct(int productNo) {
		
		Connection conn = getConnection();
		
		Product p = new ProductDao().selectProduct(conn, productNo);
		
		close(conn);
		
		return p;
	}

	public ArrayList<ProductAttachment> selectProductAttachment(int productNo) {
		
		Connection conn = getConnection();
		
		ArrayList<ProductAttachment> pa = new ProductDao().selectProductAttachment(conn, productNo);
		
		close(conn);
		
		return pa;
	}

	public int insertCart(int memberNo, int productNo, int quantity) {
		
		Connection conn = getConnection();
		
		int result = new ProductDao().insertCart(conn, memberNo, productNo, quantity);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

	
	// 정길이형 파트
	//*********************************************************************************************
	// 토스받은 전체 등록 상품 조회
	//*********************************************************************************************
	public ArrayList<Product> selectAllProduct(){
		ArrayList<Product> list = null;
		Connection conn = null;
		try{
			conn = getConnection();
			list = new ProductDao().selectAllProduct(conn);
		}finally {
			close(conn);
		}
		return list;
	}

	//*********************************************************************************************
	// 할인중인 상품 조회 
	//*********************************************************************************************
	public ArrayList<Product> selectSaleProduct(){
		
		Connection conn = getConnection();
		
			
		ArrayList<Product> list = new ProductDao().selectSaleProduct(conn);
		
		close(conn);
		
		return list;
	}

	//*********************************************************************************************
	// 토스받은  판매량 상위 10건 상품 조회 
	//*********************************************************************************************
	public ArrayList<Product> selectRankingProduct(){
		
		Connection conn = getConnection();
			
		ArrayList<Product> list = new ProductDao().selectRankingProduct(conn);
		
		close(conn);
		
		return list;
	}
	
	public int insertReview(Review r) {
			Connection conn = getConnection();
			
			int result = new ProductDao().insertReview(conn, r);
			if(result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
			close(conn);
			return(result);

	}
	
	public ArrayList<Review> selectReviewList(int productNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Review> list = new ProductDao().selectReviewList(conn,productNo);
		
		close(conn);
		
		return list;
	}
}
