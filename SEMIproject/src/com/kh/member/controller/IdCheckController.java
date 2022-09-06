package com.kh.member.controller;

import java.io.IOException;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;


/**
 * Servlet implementation class idCheckController
 */
@WebServlet("/idCheck.me")
public class IdCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdCheckController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String memberId = (String) request.getParameter("memberId");
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		int check = new MemberService().idCheck(memberId);
		
		
		
		/*
		HashSet<String> set = new HashSet<>();
		set.add("check");
		*/
		
		if(check == 1) {
			JSONObject json = new JSONObject();
			json.put("resultCode", 1000);
			json.put("resultMsg", "success");
			JSONObject data = new JSONObject();
			data.put("exist", "F");
			
			json.put("data", data);
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(json);
		} else if (check == 0) {
			
			JSONObject json = new JSONObject();
			json.put("resultCode", 1000);
			json.put("resultMsg", "success");
			JSONObject data = new JSONObject();
			data.put("exist", "T");
			json.put("data", data);
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(json);
			
		}
		
		
		
		/*
		 * {
		 * 		resultCode : 1000, 
		 * 		resultMsg : 'success',
		 * 		data : {
		 * 			exist : <"T" or "F">
		 * 		}
		 * }
		 
		
		JSONObject json = new JSONObject();
		json.put("resultCode", 1000);
		json.put("resultMsg", "success");
//		json.put("resultCode", 1001);
//		json.put("resultMsg", "db error");

		JSONObject data = new JSONObject();
		data.put("exist", set.contains(1)? "T" : "F");
		
		json.put("data", data);

		
		/*
		if(set.contains(userId)) {
			System.out.println("사용불가. -이미존재함");
			json.put("exist", "T");
		}
		else {
			System.out.println("사용가능.");
			json.put("exist", "F");
		}	
		
		
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(json);
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
