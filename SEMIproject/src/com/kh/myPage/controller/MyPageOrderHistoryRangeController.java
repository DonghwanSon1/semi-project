package com.kh.myPage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.kh.member.model.vo.Member;
import com.kh.myPage.model.service.MyPageService;
import com.kh.product.model.vo.Product;

/**
 * Servlet implementation class MyPageOrderHistoryRangeController
 */
@WebServlet("/orderHistoryDateRange.my")
public class MyPageOrderHistoryRangeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageOrderHistoryRangeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
		
		String date1 = request.getParameter("date1");
		String date2 = request.getParameter("date2");
	
		// System.out.println(date1); // 2022/07/06
		// System.out.println(date2); // 2022/07/06
		
		ArrayList<Product> pd = new MyPageService().getOrderHistoryRange(memberNo, date1, date2);
		
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(pd, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
