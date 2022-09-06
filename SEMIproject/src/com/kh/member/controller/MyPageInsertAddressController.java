package com.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Address;

/**
 * Servlet implementation class MyPageInsertAddressController
 */
@WebServlet("/insertAddress.my")
public class MyPageInsertAddressController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageInsertAddressController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// post 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 값 뽑기
		String receiver = request.getParameter("receiver");
		String location = request.getParameter("location");
		String phone = request.getParameter("phone");
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));

		// main은 "Y" 아니면 "null"이 들어온
		String main = request.getParameter("setMain");
		
//		System.out.println(main);
//		System.out.println(receiver);
//		System.out.println(location);
//		System.out.println(phone);
//		System.out.println(memberNo);
		
		if (main == null) {
			main = "N";
		}
		
		// 가공
		Address address = new Address(main, receiver, location, phone, memberNo);
		
		// 사용자가 새로 추가하는 배송지를 기본으로 설정하는지에 대한 확인
		// 새롭게 기본배송지 설정을 한경우에는 기존의 기본배송지의 main의 값을 "N"으로 변경해줘야한다.
		
		int result = new MemberService().insertAddress(address);			
		
		
		 //서비스단으로 넘기기
		 
		 if (result > 0) { // 성공
			 
			 request.getSession().setAttribute("alertMsg", "배송지 등록 성공!");
			 response.sendRedirect(request.getContextPath() + "/address.my");
			 
		} else { // 실패
			request.setAttribute("errorMsg", "주소지 등록 실패");
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
