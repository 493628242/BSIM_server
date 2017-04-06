package com.wangjiyuan.scoket;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SocketServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SocketServlet() {
		super();
	}

	public void destroy() {
		super.destroy();
		// 停止服务
		ChatServerSocketThread.singleChatServerSocketThread().stopThread();
		MessageHandleThread.singleMessageHandle().stopThread();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void init() throws ServletException {
		// 启动服务
		MessageHandleThread.singleMessageHandle().start();
		ChatServerSocketThread.singleChatServerSocketThread().start();
	}

}
