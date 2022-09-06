package com.kh.myPage.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.member.model.vo.Member;
import com.kh.myPage.model.dao.MyPageDao;
import com.kh.myPage.model.vo.Coupon;
import com.kh.product.model.vo.Product;
import static com.kh.common.Template.*;

public class MyPageService {

	public ArrayList<Product> getCartList(int memberNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Product> list = new MyPageDao().getCartList(conn, memberNo);
		
		close(conn);
		
		return list;
	}

	public int updateCartQuan(int memberNo, String productName, String plusMinus, String quantity) {
		
		Connection conn = getConnection();
		
		int result = new MyPageDao().updateCartQuan(conn, memberNo, productName, plusMinus, quantity);
		
		if(result > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
	}

	public ArrayList<Product> getOrderlist(int memberNo, String[] strs) {
		
		Connection conn = getConnection();
		
		ArrayList<Product> result = new MyPageDao().getOrderlist(conn, memberNo, strs);
		
		close(conn);
		
		return result;
		
	}
	
	public ArrayList<Coupon> getCoupons(int memberNo) {
		
		Connection conn = getConnection();
		
		ArrayList<Coupon> coupons = new MyPageDao().getCoupons(conn, memberNo);
		
		return coupons;
	}

	public int orderProducts(int memberNo, String[] products, int discountRate, String[] totalQuantitys,
			String[] points, int point, String couponName, int ano) {
		
		Connection conn = getConnection();
		
		int result = new MyPageDao().orderProducts(conn, memberNo, products, discountRate, totalQuantitys, points, ano);
		int result2 = 0;
		int result3 = 0;
		
		if(result >= products.length) {
			result2 = new MyPageDao().updatePoint(conn, memberNo, points, point);
			result3 = new MyPageDao().usingCoupon(conn, memberNo, couponName);
		}
		
		if(result * result2 * result3 > 0) commit(conn);
		else rollback(conn);
		
		close(conn);
		
		return result;
		
	}

	public ArrayList<Product> getOrderHistoryButton(int memberNo, String date) {
		
		Connection conn = getConnection();
		
		ArrayList<Product> result = new MyPageDao().getOrderHistoryButton(conn, memberNo, date);
		
		close(conn);
		
		return result;
		
	}

	public ArrayList<Product> getOrderHistoryRange(int memberNo, String date1, String date2) {
		
		Connection conn = getConnection();
		
		ArrayList<Product> result = new MyPageDao().getOrderHistoryRange(conn, memberNo, date1, date2);
		
		close(conn);
		
		return result;
		
	}

	public void clearCart(int memberNo) {
		
		Connection conn = getConnection();
		
		// new MyPageDao().clearCart(conn ,memberNo);
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
