package com.wangjiyuan.scoket;

import java.io.BufferedReader;
import java.io.IOException;
import com.wangjiyuan.bean.Message;
import com.google.gson.Gson;

public class ReadThread extends Thread {
	private BufferedReader readMessage;
	private String Message;
	private Gson gson;
	private heartBeatListener listener;
	public static final String HEART_BEAT_CODE = "200";

	public ReadThread(BufferedReader readMessage) {
		this.readMessage = readMessage;
		gson = new Gson();

	}

	@Override
	public void run() {
		super.run();
		try {
			while (ClientSocket.STATE) {
				Message = readMessage.readLine();
				if (Message.equals(HEART_BEAT_CODE)) {
					listener.onReceiveHeartBeat();
					continue;
				}
				Message message = gson.fromJson(Message, Message.class);
				MessageHandleThread.singleMessageHandle().sendMessage(message);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void addHeartBeatListener(heartBeatListener listener) {
		this.listener = listener;
	}

	public void close() throws IOException {
		readMessage.close();
	}

	interface heartBeatListener {
		void onReceiveHeartBeat();
	}
}
