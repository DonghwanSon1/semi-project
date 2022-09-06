package com.kh.board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;
import com.kh.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class BoardInsertController
 */
@WebServlet("/insert.bo")
public class BoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩
		request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			
			
			
		int maxSize = 10 * 1024 * 1024; // 10Mbyte
		
		//HttpSession session = request.getSession();
		//ServletContext application = session.getServletContext();
		
		String savePath = request.getSession().getServletContext().getRealPath("/resources/board_upfiles/");
		
		
		
		
		
		MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
		
		
		// Attachment
		// 값 뽑기
		String category = multiRequest.getParameter("category");
		String title = multiRequest.getParameter("title");
		String content = multiRequest.getParameter("content");
		String memberNo = multiRequest.getParameter("memberNo");
		
		// VO 가공
		Board b = new Board();
		b.setCategory(category);
		b.setBoardTitle(title);
		b.setBoardContent(content);
		b.setBoardWriter(memberNo);
		
		Attachment at = null;
		
		// Service로 토스 => 첨부파일 객체 생성 후 토스(첨부파일 유무)
		
		// 첨부파일 가려내는 메소드(원본파일 리턴
		// 첨부파일이 있으면 원본파일명 // 없으면 null 리턴
		
		if(multiRequest.getOriginalFileName("upfile") != null) {
			
			// 첨부파일이 있다 vo 객체로 가공
			at = new Attachment();
			
			at.setOriginName(multiRequest.getOriginalFileName("upfile")); // 원본명
			
			// 수정파일명 
			at.setChangeName(multiRequest.getFilesystemName("upfile"));
			
			// 파일경로
			at.setFilePath("resources/board_upfiles");
			
		}
		// 서비스 요청
		
		int result = new BoardService().insertBoard(b, at);
		
		if(result > 0) {
			
			request.getSession().setAttribute("alertMsg", "게시글 작성 성공");
			response.sendRedirect(request.getContextPath() + "/list.bo?cpage=1");
			
			
		}else { // 실패
			
			if(at !=null) {
				//
				new File(savePath + at.getChangeName()).delete();
				
			}
			
			request.setAttribute("errorMsg", "게시글 작성 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
