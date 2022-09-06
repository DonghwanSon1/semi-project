package com.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;

/**
 * Servlet implementation class MyPageSetMainAddressController
 */
@WebServlet("/setMainAddress.my")
public class MyPageSetMainAddressController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageSetMainAddressController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int ano = Integer.parseInt(request.getParameter("ano"));
		int mno = Integer.parseInt(request.getParameter("mno"));
		
		int result = 0;
		int result2 = new MemberService().chageMainAddress(mno);
		
		if (result2 > 0) result = new MemberService().setMainAddress(ano);
		
		if (result > 0) {
			request.getSession().setAttribute("alertMsg", "기본배송지 설정 완료!!");
			response.sendRedirect(request.getContextPath() + "/address.my");
		} else {
			request.setAttribute("errorMsg", "기본배송지 설정 실패!");
			request.getRequestDispatcher("views/common/errorPage.jsp");
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
