package com.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Address;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;


/**
 * Servlet implementation class MyPageModifyAddressController
 */
@WebServlet("/modifyAddress.my")
public class MyPageModifyAddressController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageModifyAddressController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// post방식 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 값뽑기
		int addressNo = Integer.parseInt(request.getParameter("addressNo"));
		String receiver = request.getParameter("receiver");
		String location = request.getParameter("location");
		String phone = request.getParameter("phone");
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
	
		
		String curMain = request.getParameter("curMain");
		String newMain = request.getParameter("newMain");
		
		String temp = curMain + newMain;
		
		switch (temp) {
		case "Ynull":
			newMain = "Y";
			break;
		case "Nnull":
			newMain = "N";
			break;
		}
		
		temp = curMain + newMain;
		/*
		 * 경우의 수는 3가지
		 * curMain == "Y" && newMain == null
		 * => 기본배송지의 수정
		 * temp == YY
		 * 
		 * curMain == "N" && newMain == null
		 * => 일반배송지의 수정 (기본으로 설정 X)
		 * temp == NN
		 * 
		 * curMain == "N" && newMain == "Y"
		 * => 일반배송지의 수정 (기본으로 설정 O)
		 * temp == NY
		 */
		
		// 가공처리
		// curMain과 newMain은 따로 넘겨준다.
		Address address = new Address(addressNo, newMain, receiver, location, phone, memberNo);
		
		// 서비스단으로 토스
		 int result = new MemberService().updateAddress(address, temp);
		
		if (result > 0) { // 성공
			 
			 request.getSession().setAttribute("alertMsg", "배송지 정보 변경 성공!");
			 response.sendRedirect(request.getContextPath() + "/address.my");
			 
		} else { // 실패
			request.setAttribute("errorMsg", "주소지 정보 변경 실패");
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
