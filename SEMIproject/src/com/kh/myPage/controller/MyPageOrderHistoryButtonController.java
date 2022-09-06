package com.kh.myPage.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
 * Servlet implementation class MyPageOrderHistoryButtonController
 */
@WebServlet("/orderHistoryButton.my")
public class MyPageOrderHistoryButtonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageOrderHistoryButtonController() {
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
		String text = request.getParameter("date");
		String date = "없음";
		
		//넘어온 일자 텍스트를 연월일 포맷으로 변경 
		if(text.equals("오늘")) date = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
	
		if(text.equals("1주일")) {
			Calendar cdate = Calendar.getInstance();
			cdate.add(Calendar.DATE, -7);
			
			date = new SimpleDateFormat("yyyy/MM/dd").format(cdate.getTime());
		}
		
		if(text.equals("1개월")) {
			Calendar cdate = Calendar.getInstance();
			cdate.add(Calendar.MONTH, -1);
			
			date = new SimpleDateFormat("yyyy/MM/dd").format(cdate.getTime());
		}
		
		if(text.equals("3개월")) {
			Calendar cdate = Calendar.getInstance();
			cdate.add(Calendar.MONTH, -3);
			
			date = new SimpleDateFormat("yyyy/MM/dd").format(cdate.getTime());
		}
		
		
		ArrayList<Product> pd = new MyPageService().getOrderHistoryButton(memberNo, date);
		
		
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
