package com.kh.center.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.center.model.service.CenterService;
import com.kh.center.model.vo.CenterReply;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class AjaxReplyDeleteController
 */
@WebServlet("/rdelete.ce")
public class AjaxReplyDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReplyDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// POST => 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// request로부터 값 뽑기
		int replyNo = Integer.parseInt(request.getParameter("reno"));
		
		// Service단 호출
		int result = new CenterService().deleteReply(replyNo);
		
		// Gson, Json => 넘겨야할 값이 여러개여서 묶을때
		
		// result 1개뿐임 그냥 넘기기
		response.setContentType("text/html; charset=UTF-8");
		
		response.getWriter().print(result);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
