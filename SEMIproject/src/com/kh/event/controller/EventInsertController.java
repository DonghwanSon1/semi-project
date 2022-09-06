package com.kh.event.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.common.MyFileRenamePolicy;
import com.kh.event.model.service.EventService;
import com.kh.event.model.vo.Event;
import com.kh.event.model.vo.EventAttachment;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class EventInsertController
 */
@WebServlet("/insert.ev")
public class EventInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
			if(ServletFileUpload.isMultipartContent(request)) {
				
			int maxSize = 1024 * 1024 * 10;
			
			String savePath = request.getServletContext().getRealPath("/resources/event_upfiles/");
			
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
				
			String eventTitle = multiRequest.getParameter("title");
			String eventContent = multiRequest.getParameter("content");
			String memberNo = multiRequest.getParameter("memberNo");
			
			Event e = new Event();
			e.setEventTitle(eventTitle);
			e.setEventContent(eventContent);
			e.setEventWriter(memberNo);
			
			ArrayList<EventAttachment> list = new ArrayList();
			
			for(int i = 1; i <=4; i++) {
				
				String key = "file" + i;
				
				if(multiRequest.getOriginalFileName(key) != null) {// 원본파일 존재
					
					EventAttachment et = new EventAttachment();
					et.setOriginName(multiRequest.getOriginalFileName(key));
					et.setChangeName(multiRequest.getFilesystemName(key));
					
					et.setFilePath("resources/event_upfiles/");
					
					if(i == 1) {
						
						et.setFileLevel(1);
					}else {
						et.setFileLevel(2);
					}
					list.add(et);
				}
				
			}
			
			// service단으로 
			
			int result = new EventService().insertEventBoard(e, list);
			
			// 결과에 따른 응답뷰
			if(result > 0) {
				request.getSession().setAttribute("alertMsg", "게시글작성성공");
				response.sendRedirect(request.getContextPath() + "/list.ev");
				
				
			}else {
				System.out.println("실패");
			}
			
			
			
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
