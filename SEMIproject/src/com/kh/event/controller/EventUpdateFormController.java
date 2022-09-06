package com.kh.event.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.event.model.service.EventService;
import com.kh.event.model.vo.EventAttachment;
import com.kh.event.model.vo.Event;


/**
 * Servlet implementation class BoardUpdateFormController
 */
@WebServlet("/updateForm.ev")
public class EventUpdateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventUpdateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 카테고리 조회
		ArrayList<Category> list = new EventService().selectCategoryList();
		
		
		// 해당 글 번호 뽑기(bno)
		int eventNo = Integer.parseInt(request.getParameter("eno"));
		
		//글 번호에 해당하는 board테이블 행 조회
		Event b = new EventService().selectEventBoard(eventNo);
		
		// 글 번호에 해당하는 첨부파일 attachment 테이블 행 조회
		
		EventAttachment et = new EventService().selectEventAttachment(eventNo);
		
		// 값 넘기기
		request.setAttribute("list", list);
		request.setAttribute("e", e);
		request.setAttribute("et", et);
		
		// 화면띄우기 => 포워딩
		request.getRequestDispatcher("views/event/eventUpdateForm.jsp").forward(request, response);
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
