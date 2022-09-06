package com.kh.event.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.event.model.service.EventService;
import com.kh.event.model.vo.Event;
import com.kh.event.model.vo.EventAttachment;

/**
 * Servlet implementation class EventDetailController
 */
@WebServlet("/detail.ev")
public class EventDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int eventNo = Integer.parseInt(request.getParameter("eno"));
		
	
		//1. 조회수 증가시키기
		
		int result = new EventService().increaseEventCount(eventNo);
		
		if(result > 0) {
			
			Event e = new EventService().selectEventBoard(eventNo);
			ArrayList<EventAttachment> list = new EventService().selectEventAttachmentList(eventNo);
			
			request.setAttribute("e",e);
			request.setAttribute("list",list);
			request.getRequestDispatcher("views/event/eventDetailView.jsp").forward(request, response);
			
			
			
		}else {
			
			
			
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
