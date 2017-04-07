package com.wangjiyuan.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import com.wangjiyuan.bean.Message;

public class ChatServerSocketThread extends Thread {

	public static final int PORT = 8889;
	public static final String IDADRESS = "192.168.1.102";

	private ServerSocket chatServerSocket;
	private ClientSocket clientSocket;
	private HashMap<String, ClientSocket> clientPool;
	private boolean state = true;

	private static ChatServerSocketThread server;

	private ChatServerSocketThread() {
		try {
			chatServerSocket = new ServerSocket(PORT);
			clientPool = new HashMap<String, ClientSocket>();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 单例
	public static ChatServerSocketThread singleChatServerSocketThread() {
		if (server == null) {
			synchronized (ChatServerSocketThread.class) {
				if (server == null) {
					server = new ChatServerSocketThread();
				}
			}
		}
		return server;
	}

	@Override
	public void run() {
		super.run();
		// 循环连接客户端
		while (state) {
			try {
				Socket socket = chatServerSocket.accept();
				clientSocket = new ClientSocket(socket);
				// clientPool.put(host + ":" + port, clientSocket);
				// 开启新线程处理客户端与服务器的事务
				clientSocket.StartThread();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public HashMap<String, ClientSocket> getClientPool() {
		return clientPool;
	}

	public void stopThread() {
		state = false;
	}

	public interface transmitMessageListenenr {
		public void transmitMessage(Message message);
	}

}
