package com.kh.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Address;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class MyPageAddressListController
 */
@WebServlet("/address.my")
public class MyPageAddressListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageAddressListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 로그인을 하지 않았을 경우 URL 접근을 막음
		HttpSession session = request.getSession();
		
		if (session.getAttribute("loginMember") == null) {
			request.setAttribute("errorMsg", "잘못된 접근입니다!!!");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		} else {
			
			int memberNo = ((Member)request.getSession().getAttribute("loginMember")).getMemberNo();
			
			ArrayList<Address> list = new MemberService().selectAddressList(memberNo);
			
			// 응답뷰 지정
			request.setAttribute("list", list);
			request.getRequestDispatcher("views/myPage/addressList.jsp").forward(request, response);			
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
