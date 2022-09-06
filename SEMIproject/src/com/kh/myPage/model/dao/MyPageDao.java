package com.kh.myPage.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;
import com.kh.myPage.model.vo.Coupon;
import com.kh.product.model.vo.Product;
import static com.kh.common.Template.*;

public class MyPageDao {

	private Properties prop = new Properties();
	
	public MyPageDao() {
		
		String file = MemberDao.class.getResource("/sql/myPage/myPage-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Product> getCartList(Connection conn, int memberNo) {
		
		ArrayList<Product> list = new ArrayList<Product>();
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		
		String sql = prop.getProperty("getCartList");
		// 조회하는 컬럼 : 사진저장경로, 사진이름(change), 상품명, 가격, 주문 수량
		// 추가로 - PNO를 식별값으로 받는게 좋지 않을까..
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			
			rSet = pstmt.executeQuery();
			
//			 	FILE_PATH, 
//			   CHANGE_NAME, 
//			   PRODUCT_NAME, 
//			   PRICE, 
//			   TOTAL_QUANTITY
			
			// 사용자의 장바구니 목록을 불러옴
			while (rSet.next()) {
				Product p = new Product();
				p.setProductNo(rSet.getInt("PRODUCT_NO"));
				// file_path + changeName 연결 => 컬럼명 PIMG
				p.setFilePathName(rSet.getString("PIMG"));
				p.setProductName(rSet.getString("PRODUCT_NAME"));
				p.setPrice(rSet.getInt("PRICE"));
				// 기존의 stock은 재고를 의미하지만 현재 요청하는 페이지에서는 주문수량에 값을 주기위해
				// 대신 사용함
				p.setStock(rSet.getInt("TOTAL_QUANTITY"));
				
				list.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rSet);
			close(pstmt);
		}
		
		return list;
	}

	public void getOrderList(Connection conn, int memberNo, String[] pnoArr) {
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("getOrderList");
		
	}

	public ArrayList<Coupon> getCoupons(Connection conn, int memberNo) {
		
		ArrayList<Coupon> result = new ArrayList<Coupon>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("getCoupons");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Coupon c = new Coupon();
				c.setCouponName(rset.getString("COUPON_NAME"));
				c.setDiscount(rset.getInt("DISCOUNT_PRICE"));
				
				result.add(c);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int updateCartQuan(Connection conn, int memberNo, String productName, String plusMinus, String quantity) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		System.out.println(productName);
	
		if(plusMinus.equals("+")) sql = prop.getProperty("updateCartQuanPlus");
		else sql = prop.getProperty("updateCartQuanMinus");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, productName);
			pstmt.setInt(3, memberNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}

	public ArrayList<Product> getOrderlist(Connection conn, int memberNo, String[] strs) {
		
		ArrayList<Product> result = new ArrayList<Product>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("getOrderlist");
		
		for(String product_name : strs) {
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, memberNo);
				pstmt.setString(2, product_name);
				
				rset = pstmt.executeQuery();
				
				while(rset.next()) {
					Product p = new Product();
					p.setFilePathName(rset.getString("PIMG"));
					p.setProductName(rset.getString("PRODUCT_NAME"));
					p.setPrice(rset.getInt("PRICE"));
					p.setStock(rset.getInt("TOTAL_QUANTITY"));
					
					result.add(p);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
		}
		return result;
	}

	public int orderProducts(Connection conn, int memberNo, String[] products, int discountRate,
			String[] totalQuantitys, String[] points, int ano) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("orderProducts");
		
		try {
			pstmt = conn.prepareStatement(sql);
			for(int i=0 ; i<products.length ; i++) {
				pstmt.setInt(1, memberNo);
				pstmt.setString(2, products[i]);
				pstmt.setInt(3, discountRate);
				pstmt.setInt(4, (int)(Integer.parseInt(points[i]) * 0.01));
				pstmt.setInt(5, Integer.parseInt(totalQuantitys[i]));
				pstmt.setInt(6, ano);
				
				result += pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
		
	}

	public int updatePoint(Connection conn, int memberNo, String[] points, int point) {
		int result = 0;
		int pointsSum = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updatePoint");
		
		for(String s : points) pointsSum += (int)(Integer.parseInt(s) * 0.01);
		pointsSum -= point;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pointsSum);
			pstmt.setInt(2, memberNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int usingCoupon(Connection conn, int memberNo, String couponName) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("usingCoupon");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, couponName);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
		
	}

	public ArrayList<Product> getOrderHistoryButton(Connection conn, int memberNo, String date) {
		
		ArrayList<Product> result = new ArrayList<Product>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("getOrderHistoryButton");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, date);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Product p = new Product();
				p.setProductEnroll(rset.getDate("ORDER_DATE"));
				p.setFilePathName(rset.getString("FILE_PATH") + rset.getString("CHANGE_NAME"));
				p.setProductName(rset.getString("PRODUCT_NAME"));
				p.setStock(rset.getInt("TOTAL_QUANTITY"));
				
				result.add(p);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
		
	}

	public ArrayList<Product> getOrderHistoryRange(Connection conn, int memberNo, String date1, String date2) {
		
		ArrayList<Product> result = new ArrayList<Product>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("getOrderHistoryRange");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, date1);
			pstmt.setString(3, date2.replaceAll("/", ""));
			
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Product p = new Product();
				p.setProductEnroll(rset.getDate("ORDER_DATE"));
				p.setFilePathName(rset.getString("FILE_PATH") + rset.getString("CHANGE_NAME"));
				p.setProductName(rset.getString("PRODUCT_NAME"));
				p.setStock(rset.getInt("TOTAL_QUANTITY"));
				
				result.add(p);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return result;
		
	}

	public void clearCart(Connection conn, int memberNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("clearCart");
		
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
