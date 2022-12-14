package com.kh.board.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;
import com.kh.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class BoardUpdateController
 */
@WebServlet("/update.bo")
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1) POST => 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2) 값 뽑기 전에 파일이 전송될 것인가를 먼저 파악
		if(ServletFileUpload.isMultipartContent(request)) {
			
			// 파일 업로드 => 2가지 설정
			
			// 1. 전송파일 용량 제한 int maxSize => 10Mbyte
			int maxSize = 1024 * 1024 * 10;
			
			// 2. 전달된 파일을 저장시킬 서버폴더의 물리적인 경로를 알아내기 String savePath
			String savePath = request.getSession().getServletContext().getRealPath("/resources/board_upfiles/");
		
			// 파일명 수정 후 업로드
			// MultiRequest 객체를 생성함으로써 파일을 내려받아짐
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			// 공통적으로 수행 : Update Board
			// 2) 값 뽑기 request => multiRequest
			int boardNo = Integer.parseInt(multiRequest.getParameter("bno"));
			System.out.println(boardNo);
			String category = multiRequest.getParameter("category");
			String boardTitle = multiRequest.getParameter("title");
			String boardContent = multiRequest.getParameter("content");
			
			
			// 3) VO 가공 -Board 와 관련
			Board b = new Board();
			b.setBoardNo(boardNo);
			b.setCategory(category);
			b.setBoardTitle(boardTitle);
			b.setBoardContent(boardContent);
		
			// Attachment 와 관련된 것도 
			// Attachment 객체 선언(null)
			// 실제 첨부파일이 있을 경우에만 객체생성
			
			Attachment at = null;
			
			// 새로운 첨부파일명을 리턴해주는 메소드 이용 첨부파일이 있는지 확인
			if(multiRequest.getOriginalFileName("reUpfile") != null) {
				
				// 새로운 파일명이 존재한다면 객체 생성 후 원본 이름, 수정된 이름, 파일경로
				
				at = new Attachment();
				at.setOriginName(multiRequest.getOriginalFileName("reUpfile"));
				at.setChangeName(multiRequest.getFilesystemName("reUpfile"));
				at.setFilePath("resources/board_upfiles/");
				// => 여기까지는 새롭게 업로드한 새로운 첨부파일에 대한 내용
				
				// 첨부파일이 있을경우 + 원본파일도 있을 경우
				
				if(multiRequest.getParameter("originFileNo") !=null) {
					
					// 기존 파일이 존재했다
					// 기존파일에 대한 파일번호 at에 담을 것 
					at.setFileNo(Integer.parseInt(multiRequest.getParameter("originFileNo")));
					
					// 기존에 서버에 존재하던 첨부파일 삭제
					new File(savePath+multiRequest.getParameter("originFileName")).delete();
					} else {
					
					// 새로운 첨부파일이 넘어왔지만 INSERT문
					// + 어느 게시글의 첨부파일인지 boardNo (REF_PNO
					 
					at.setRefPno(boardNo);
				}
				
			}
				// 4) Service단으로 
				// 경우에  따라 1개의 트랜잭션으로 묶어야함
				// Service단 작성 전 경우의 수 처리
				// case 1 : 새로운 첨부파일이 없으면 => b, null => BOARD UPDATE
				// case 2 : 새로운 첨부파일이 있고 기존 첨부파일 O => BOARD UPDATE, ATTACHMENT UPDATE
				// case 3 : 새로운 첨부파일이 있고 기존 첨부파일 X => BOARD UPDATE, ATTACHMENT INSERT 
				
				int result = new BoardService().updateBoard(b, at);
			
			
				// 결과에 따른 응답뷰
				if(result > 0) { // 성공 => 상세보기 페이지 이동
					
				request.getSession().setAttribute("alertMsg", "게시글이 수정되었습니다.");
				response.sendRedirect(request.getContextPath() + "/detail.bo?bno=" + boardNo);
				
				}else { // 실패
				request.setAttribute("errorMsg", "게시글 수정 실패!");
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
