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

/**
 * Servlet implementation class NickNameCheckController
 */
@WebServlet("/nicknamecheck.me")
public class NickNameCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NickNameCheckController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginNickName = (String) request.getParameter("loginNickName");
				
		
		
		
		int check = new MemberService().nickNameCheck(loginNickName);
		
		
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

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
