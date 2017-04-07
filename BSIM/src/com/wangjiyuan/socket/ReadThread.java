package com.wangjiyuan.socket;

import java.io.BufferedReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.wangjiyuan.bean.Message;

public class ReadThread extends Thread {
	private BufferedReader readMessage;
	private String messageJson;
	private Gson gson;
	private heartBeatListener listener;
	private registerSocketLinstener l;
	public static final String HEART_BEAT_CODE = "200";

	public ReadThread(BufferedReader readMessage) {
		this.readMessage = readMessage;
		gson = new Gson();

	}

	@Override
	public void run() {
		super.run();
		System.out.println("read执行");
		try {
			while (ClientSocket.STATE) {
				messageJson = readMessage.readLine();
				System.out.println(messageJson);
				if (messageJson.equals(HEART_BEAT_CODE)) {
					listener.onReceiveHeartBeat();
					continue;
				}
				Message message = gson.fromJson(messageJson, Message.class);
				if (message.getType() == Message.CODE) {
					l.getSocketPhoneNumber(message.getForm());
					continue;
				}
				System.out.println(message);
				MessageHandleThread.singleMessageHandle().sendMessage(message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addHeartBeatListener(heartBeatListener listener) {
		this.listener = listener;
	}

	public void addRegisterSocketLinstener(registerSocketLinstener l) {
		this.l = l;
	}

	public void close() throws IOException {
		readMessage.close();
	}

	interface heartBeatListener {
		void onReceiveHeartBeat();
	}

	interface registerSocketLinstener {
		void getSocketPhoneNumber(String phoneNumber);
	}
}
