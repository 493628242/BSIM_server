package com.wangjiyuan.socket;

import java.util.HashMap;
import java.util.LinkedList;

import com.wangjiyuan.bean.Message;

public class MessageHandleThread extends Thread {
	private LinkedList<Message> messagePool;
	public boolean state = true;
	private static MessageHandleThread handle;
	private HashMap<String, ClientSocket> clientPool;

	private MessageHandleThread() {
		super();
		clientPool = ChatServerSocketThread.singleChatServerSocketThread()
				.getClientPool();
		messagePool = new LinkedList<Message>();
	}

	@Override
	public void run() {
		super.run();
		while (state) {
			if (messagePool.size() == 0) {
				continue;
			} else {
				Message message = messagePool.getFirst();
				ClientSocket client = (ClientSocket) clientPool.get(message
						.getTo());
				if (client == null) {
					System.out.println("未登录");
				} else {
					client.sendMessage(message);
					messagePool.removeFirst();
				}
			}
		}
	}

	public static MessageHandleThread singleMessageHandle() {
		if (handle == null) {
			synchronized (MessageHandleThread.class) {
				if (handle == null) {
					handle = new MessageHandleThread();
				}
			}
		}
		return handle;
	}

	public void sendMessage(Message message) {
		messagePool.add(message);
	}

	public void stopThread() {
		state = false;
	}

}
