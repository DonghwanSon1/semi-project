package com.kh.myPage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;
import com.kh.myPage.model.service.MyPageService;
import com.kh.product.model.vo.Product;

/**
 * Servlet implementation class MyPageOrderProductController
 */
@WebServlet("/orderProducts.my")
public class MyPageOrderProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageOrderProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
		
		String[] products = request.getParameter("products").split(",");
		int discountRate = Integer.parseInt(request.getParameter("discountRate"));
		String[] totalQuantitys = request.getParameter("totalQuantity").split(",");
		String[] points = request.getParameter("points").split(",");
		int point = Integer.parseInt(request.getParameter("point"));
		String couponName = request.getParameter("couponName");
		int ano = Integer.parseInt(request.getParameter("ano"));
		
		int result = new MyPageService().orderProducts(memberNo, products, discountRate, totalQuantitys, points, point, couponName, ano);
		
		if(result == products.length) {
			
			// new MyPageService().clearCart(memberNo);
			
			session.setAttribute("alertMsg", "주문 성공");						
			response.sendRedirect(request.getContextPath());
			
			
		}else {
			session.setAttribute("alertMsg", "주문 실패");
			response.sendRedirect(request.getContextPath());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
