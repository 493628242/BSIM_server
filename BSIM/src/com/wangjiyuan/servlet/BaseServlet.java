package com.wangjiyuan.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void ReturnJson(HttpServletResponse response, String Json)
			throws IOException {
		response.setHeader("content-type", "text/html;charset=utf-8");
		response.getWriter().append(Json);
	}
}
