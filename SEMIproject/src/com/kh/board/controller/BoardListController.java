package com.kh.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Board;
import com.kh.common.model.vo.PageInfo;

/**
 * Servlet implementation class BoardListController
 */
@WebServlet("/list.bo")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		// 페이징 처리
		int listCount; // 일반게시판 총 갯수
		int currentPage; // 현재페이지
		int pageLimit; // 페이징바 최대갯수 10개
		int boardLimit; // 게시글 최대 갯수 10개
		
		int maxPage; // 총 페이지 갯수
		int startPage; // 페이지 하단에 보여질 페이징바의 시작수
		int endPage; // 페이지 하단에 보여질 페이징바의 끝 수
		
		listCount = new BoardService().selectListCount();
		
		// 현재페이지
		currentPage = Integer.parseInt(request.getParameter("cpage"));

		
		// 페이지 최대 갯수
		pageLimit = 10;
		
		
		// 한 페이지에 보여질 게시글 최대 갯수
		boardLimit = 10;
		
		//maxPage 마지막 페이지가 몇번 페이지인지
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		
		
		// startPage 시작페이지
		
		startPage = (currentPage - 1) / pageLimit * pageLimit + 1;
		
		// endPage : 하단에 보여질 페이징바의 끝 수
		
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		
		
		// 3) vo 가공
		
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit,
									maxPage, startPage, endPage);
		
		// 4) Service로 토스
		
		ArrayList<Board> list = new BoardService().selectList(pi);
		
		// 5) 응답뷰 지정
		request.setAttribute("list", list); // 우리가 실제로 조회한 페이지에 보일 10개의 게시글
		request.setAttribute("pi", pi);	// 페이징바를 만들 때 필요한 변수
		
		
		
		// views/board/boardDetailView.jsp 화면으로 응답 => 포워딩
		request.getRequestDispatcher("views/board/boardListView.jsp").forward(request,  response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
