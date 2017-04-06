package com.wangjiyuan.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FriendListServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String TOKEN = "token";
	public static final String PHONE_NUMBER = "phonenumber";

	public FriendListServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1、查询数据库的验证客户发来的信息
		String phonenumber = request.getParameter(PHONE_NUMBER);
		String token = request.getParameter(TOKEN);
		//2、查询用户好友分组，查询好友信息
		
		//3、组合成ArrayList<Group>对象，生成Json字符串，返回给客户端
		
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
