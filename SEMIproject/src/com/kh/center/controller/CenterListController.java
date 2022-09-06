package com.kh.center.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.center.model.service.CenterService;
import com.kh.center.model.vo.Center;
import com.kh.common.model.vo.PageInfo;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class CenterListController
 */
@WebServlet("/list.ce")
public class CenterListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CenterListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		// ----------- 페이징 처리 --------------
		// 필요한 변수들 
		int listCount; // 현재 일반게시판의 게시글 총 갯수 = Board로 부터 조회 Count(*)활용 조건(STATUS = 'Y')
		int currentPage; // 현재 페이지(즉, 사용자가 요청한 페이지) => request.getParameter("cpage");
		int pageLimit; // 페이지 하단에 보여질 페이징바의 최대 갯수 => 10개로 고정
		int boardLimit; // 한 페이지에 보여질 게시글의 최대 갯수 => 10개로 고정
		
		int maxPage; // 가장 마지막 페이지가 몇번 페이지 인지 (총 페이지의 갯수)
		int startPage; // 페이지 하단에 보여질 페이징바의 시작 수
		int endPage; // 페이지 하단에 보여질 페이징바의 끝 수
		
		// * listCount : 총 게시글 갯수
		listCount = new CenterService().selectInqListCount();
		
		// * currentPage : 현재페이지 (== 사용자가 요청한 페이지)
		currentPage = Integer.parseInt(request.getParameter("cpage"));
		
		//System.out.println(listCount); // 107
		//System.out.println(currentPage); // 1
		
		// * pageLimit : 페이징바의 페이지 최대 갯수
		pageLimit = 10;
		
		// * NoticeLimit : 한 페이지에 보여질 게시글의 최대 갯수
		boardLimit = 10;
		
		// * maxPage : 가장 마지막 페이지가 몇 번 페이지인지(총 페이지 갯수)
		/*
		 * listCount, boardLimit에 영향을 받음
		 * 
		 * - 공식 구하기 
		 *   단, boardLimit이 10이라는 가정하에 규칙을 찾아보자!
		 *   
		 *   총 갯수(listCount)   boardLimit(보여지는 게시글)	 maxPage(마지막 페이지)
		 *   100 개                                       10개					=> 10 페이지
		 * 	 101 개 					   10개					=> 11 페이지
		 * 	 105 개					   10개					=> 11 페이지
		 *   109 개  					   10개					=> 11 페이지
		 *   111 개 				       10개					=> 12 페이지
		 *   
		 * => 나눗셈 결과 (listCount / boardLimit)를 올림처리 할 경우 maxPage가 된다.
		 * 
		 * 스텝
		 * 1) listCount를 double로 형변환
		 * 2) listCount / boardLimit
		 * 3) Math.ceil() => 결과를 올림 처리
		 * 4) 결과값을 int로 형변환
		 * 
		 */
		
		maxPage = (int)Math.ceil((double)listCount / boardLimit);
		// System.out.println(maxPage); // 11 
		
		// * startPage : 페이지 하단에 보여질 페이징바의 시작수
		/*
		 * pageLimit, currentPage에 영향을 받음
		 * 
		 * - 공식 구하기
		 *   단, pageLimit 10이라는 가정하에 규칙을 구해보자
		 *   
		 * startPage : 1, 11, 21, 31, 41 .... => n * 10 + 1 => 10의 배수 + 1
		 * 
		 * 만약에 pageLimit이 5였다면?
		 * startPage : 1, 6, 11, 16 .... => n * 5 + 1 => 5의 배수 + 1
		 * 
		 * 즉, startPage = n * pageLimit + 1
		 * 
		 * n을 구하는 공식은 
		 * 0 ~ 9 / 10 = 0
		 * 10 ~ 19 / 10 = 1
		 * 20 ~ 29 / 10 = 2
		 * 
		 * n = (currentPage -1 ) / pageLimit
		 *
		 * startPage  = (currentPage -1) / pageLimit * pageLimit + 1
		 */

		startPage = (currentPage -1) / pageLimit * pageLimit + 1;
		
		// * endPage : 페이지 하단에 보여질 페이징바의 끝 수
		/*
		 * startPage, pageLimit에 영향을 받음(단, maxPage도 마지막 페이징 바에 대해선 영향을 준다.)
		 * 
		 * - 공식 구하기
		 * 단, pageLimit이 10이라는 가정
		 * 
		 * startPage : 1 => endPage : 10
		 * startPage : 11 => endPage : 20
		 * startPage : 21 => endPage : 30
		 * ...
		 * 
		 * => endPage = startPage + pageLimit - 1;
		 * 
		 */
		
		endPage = startPage + pageLimit -1;
		
		// startPage가 11이어서 endPage에는 20이 들어갔는데
		// maxPage가 13이라면??
		// endPage값을 maxPage값으로 변경
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		// 여기까지 총 7개의 변수를 만들었음!
		// 7개의 변수를 가지고 해당되는 범위에 따른 게시글 10개씩만 SELECT
		// Service단으로 토스 => 7개나 있다. => VO클래스에 만들어서 가공해서 넘긴다.
		
		// 3) VO로 가공
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		
		

		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginMember") == null) {
			
			request.setAttribute("errorMsg", "로그인 후 이용해주세요!!");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
		} else {
			
			String MemberId = ((Member)request.getSession().getAttribute("loginMember")).getMemberId();
	
			if(MemberId.equals("admin")) {
				ArrayList<Center> list1 = new CenterService().selectCenterAdminList(pi);
				
				// 값 주기
				request.setAttribute("list", list1);
				request.setAttribute("MemberId", MemberId);
				request.setAttribute("pi", pi);
				
				
				// 화면 띄우기
				request.getRequestDispatcher("/views/center/centerListView.jsp").forward(request, response);
				
			} else {
				ArrayList<Center> list2 = new CenterService().selectCenterList(MemberId, pi);
				
				// 값 주기
				request.setAttribute("list", list2);
				request.setAttribute("MemberId", MemberId);
				request.setAttribute("pi", pi);
				
				
				// 화면 띄우기
				request.getRequestDispatcher("/views/center/centerListView.jsp").forward(request, response);
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
