package com.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;

import oracle.security.o3logon.a;

/**
 * Servlet implementation class MyPageDeleteAddressController
 */
@WebServlet("/deleteAddress.my")
public class MyPageDeleteAddressController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageDeleteAddressController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get방식
		
		// 값뽑기 => 선택된 배송지의 고유번호인 addressNo를 받아온
		int ano = Integer.parseInt(request.getParameter("ano"));
		
		// 가공 패스
		
		// 서비스단으로~
		int result = new MemberService().deleteAddress(ano);
		
		// 응답뷰 지정
		if (result > 0) {
			request.getSession().setAttribute("alertMsg", "배송지 삭제 성공!");
			response.sendRedirect(request.getContextPath()+"/address.my");
		} else {
			request.setAttribute("errorMsg", "배송지 삭제 실패!!");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
