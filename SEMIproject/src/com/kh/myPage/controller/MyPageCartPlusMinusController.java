package com.kh.myPage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.vo.Member;
import com.kh.myPage.model.service.MyPageService;

/**
 * Servlet implementation class MyPageCartPlusMinusController
 */
@WebServlet("/cartQuanPlusMinus.my")
public class MyPageCartPlusMinusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageCartPlusMinusController() {
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
		
		String productName = request.getParameter("productName");
		String plusMinus = request.getParameter("plusMinus");
		String quantity = request.getParameter("quantity");
		
		int result = new MyPageService().updateCartQuan(memberNo, productName, plusMinus, quantity);
		
		response.setContentType("text/html; charset=UTF-8");
		if(plusMinus.equals("+")) response.getWriter().print(Integer.parseInt(quantity) + 1);
		else response.getWriter().print(Integer.parseInt(quantity) - 1);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
