package com.wangjiyuan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.wangjiyuan.bean.User;
import com.wangjiyuan.information.UserInformation;

public class LoginServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String PHONE_NUMBER = "phonenumber";
	public static final String PASSWORD = "password";

	public LoginServlet() {
		super();
	}

	public void init() throws ServletException {
		// Put your code here
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// String phonenumber = request.getParameter(PHONE_NUMBER);
		// String password = request.getParameter(PASSWORD);
		// System.out.println(phonenumber + "----------" + password);
		// User user = new User();
		// user.setHeadimage("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2075750630,4216747848&fm=117&gp=0.jpg");
		// user.setNickname("张三");
		// user.setPhonenumber(phonenumber);
		// user.setSex(1);
		// Gson gson = new Gson();
		// String userJson = gson.toJson(user);
		// System.out.println(userJson);
		// ReturnJson(response, userJson);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String phonenumber = request.getParameter(PHONE_NUMBER);
		String password = request.getParameter(PASSWORD);
		String ip = getRemortIP(request);
		UserInformation.addInformation(phonenumber, ip);
		System.out.println(phonenumber + "----------" + password
				+ "------------------" + ip);
		User user = new User();
		user.setHeadimage("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2075750630,4216747848&fm=117&gp=0.jpg");
		user.setNickname("张三");
		user.setPhonenumber(phonenumber);
		user.setSex(1);
		user.setToken(System.currentTimeMillis() + "/" + phonenumber);
		Gson gson = new Gson();
		String userJson = gson.toJson(user);
		System.out.println(userJson);
		ReturnJson(response, userJson);
	}

	public String getRemortIP(HttpServletRequest request) {
		if (request.getHeader("x-forwarded-for") == null) {
			return request.getRemoteAddr();
		}
		return request.getHeader("x-forwarded-for");
	}
}
