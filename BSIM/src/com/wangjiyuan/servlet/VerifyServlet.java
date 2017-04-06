package com.wangjiyuan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.wangjiyuan.bean.User;

public class VerifyServlet extends BaseServlet {

	/**
	 * 验证身份的Servlet
	 */
	private static final long serialVersionUID = 1L;
	public static final String TOKEN = "token";
	public static final String PHONE_NUMBER = "phonenumber";

	public VerifyServlet() {
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
		String phonenumber = request.getParameter(PHONE_NUMBER);
		String token = request.getParameter(TOKEN);
		
		//数据库查询token验证，token一致则返回userJson，不一致则返回token为000000，代表从新登录
		User user = new User();
		user.setHeadimage("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2959468746,3057091608&fm=117&gp=0.jpg");
		user.setNickname("张三");
		user.setPhonenumber(phonenumber);
		user.setSex(1);
		user.setToken(System.currentTimeMillis()+"/"+phonenumber);
		Gson gson = new Gson();
		String userJson = gson.toJson(user);
		System.out.println(userJson);
		ReturnJson(response, userJson);
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
