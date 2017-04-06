package com.wangjiyuan.scoket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

import com.wangjiyuan.bean.Message;
import com.wangjiyuan.scoket.ReadThread.heartBeatListener;

public class ClientSocket extends Socket {

	public static boolean STATE = true;
	public long lastSendTime;
	private Timer timer;
	private TimerTask timerTask;
	private ReadThread readThread;
	private WriteThread writeThread;

	public ClientSocket() {
		timer = new Timer(true);
		timerTask = new TimerTask() {
			// 计时器，用于计算心跳包
			@Override
			public void run() {
				if (System.currentTimeMillis() - lastSendTime >= 40000) {
					ClientSocket.this.close();
					timer.cancel();
				}
			}
		};
		timer.schedule(timerTask, 20000, 40000);
		lastSendTime = System.currentTimeMillis();
	}

	public void StartThread() throws IOException {
		readThread = new ReadThread(new BufferedReader(new InputStreamReader(
				this.getInputStream())));
		// 设置心跳包的监听
		readThread.addHeartBeatListener(new heartBeatListener() {

			public void onReceiveHeartBeat() {
				lastSendTime = System.currentTimeMillis();
			}
		});
		writeThread = new WriteThread(new BufferedWriter(
				new OutputStreamWriter(this.getOutputStream())));
		readThread.start();
		writeThread.start();
	}

	public void sendMessage(Message message) {
		writeThread.sendMessage(message);
	}

	// 关闭socket
	@Override
	public void close() {
		try {
			STATE = false;
			writeThread.close();
			readThread.close();
			super.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
