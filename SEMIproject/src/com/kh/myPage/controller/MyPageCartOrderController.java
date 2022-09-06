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

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Address;
import com.kh.member.model.vo.Member;
import com.kh.myPage.model.service.MyPageService;
import com.kh.product.model.vo.Product;

/**
 * Servlet implementation class MyPageCartOrderController
 */
@WebServlet("/cartOrder.my")
public class MyPageCartOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageCartOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
		
		String[] strs = request.getParameter("pNames").split(",");
		
		ArrayList<Product> pList = new MyPageService().getOrderlist(memberNo, strs);
		ArrayList<Address> aList = new MemberService().selectAddressList(memberNo);
		
		System.out.println(aList);
		
		request.setAttribute("pList", pList);
		request.setAttribute("aList", aList);
		request.getRequestDispatcher("views/myPage/orderProduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
