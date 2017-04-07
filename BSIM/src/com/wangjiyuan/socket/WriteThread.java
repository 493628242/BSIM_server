package com.wangjiyuan.socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.wangjiyuan.bean.Message;

public class WriteThread extends Thread {
	private BufferedWriter writeMessage;
	private String Message;
	private Gson gson;
	private LinkedList<Message> messages;

	public WriteThread(BufferedWriter writeMessage) {
		this.writeMessage = writeMessage;
		gson = new Gson();
		messages = new LinkedList<Message>();

	}

	@Override
	public void run() {
		super.run();
		System.out.println("write执行");
		try {
			while (ClientSocket.STATE) {
				if (messages.size() == 0) {
					continue;
				} else {
					Message = gson.toJson(messages.getFirst());
					writeMessage.write(Message);
					writeMessage.newLine();
					writeMessage.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendMessage(Message message) {
		messages.add(message);
	}
	
	public void close() throws IOException {
		writeMessage.close();
	}
}
