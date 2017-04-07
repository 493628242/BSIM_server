package com.wangjiyuan.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

import com.wangjiyuan.bean.Message;
import com.wangjiyuan.socket.ReadThread.heartBeatListener;
import com.wangjiyuan.socket.ReadThread.registerSocketLinstener;

public class ClientSocket {

	public static boolean STATE = true;
	public long lastSendTime;
	private Timer timer;
	private TimerTask timerTask;
	private ReadThread readThread;
	private WriteThread writeThread;
	private Socket client;
	private String phoneNumber;

	public ClientSocket(Socket client) {
		this.client = client;
		timer = new Timer();
		timerTask = new TimerTask() {
			// 计时器，用于计算心跳包
			@Override
			public void run() {
				if (System.currentTimeMillis() - lastSendTime >= 50000) {

					close();
					System.out.println(STATE);
					System.out.println(System.currentTimeMillis());
					timer.cancel();
				}
			}
		};
//		timer.schedule(timerTask, 0, 10000);
		lastSendTime = System.currentTimeMillis();
	}

	public void StartThread() throws IOException {
		readThread = new ReadThread(new BufferedReader(new InputStreamReader(
				client.getInputStream(), "UTF-8")));
		// 设置心跳包的监听
		readThread.addHeartBeatListener(new heartBeatListener() {

			public void onReceiveHeartBeat() {
				lastSendTime = System.currentTimeMillis();
			}
		});

		readThread.addRegisterSocketLinstener(new registerSocketLinstener() {

			public void getSocketPhoneNumber(String phoneNumber) {
				setPhoneNumber(phoneNumber);
				ChatServerSocketThread.singleChatServerSocketThread()
						.getClientPool().put(phoneNumber, ClientSocket.this);
				
			}
		});
		writeThread = new WriteThread(new BufferedWriter(
				new OutputStreamWriter(client.getOutputStream(), "UTF-8")));
		readThread.start();
		writeThread.start();
	}

	public void sendMessage(Message message) {
		writeThread.sendMessage(message);
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	// 关闭socket
	public void close() {
		try {
			
			STATE = false;
			ChatServerSocketThread.singleChatServerSocketThread()
					.getClientPool().remove(phoneNumber);
			readThread.close();
			writeThread.close();
			System.out.println("关闭socket");
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "ClientSocket [lastSendTime=" + lastSendTime + ", timer="
				+ timer + ", timerTask=" + timerTask + ", readThread="
				+ readThread + ", writeThread=" + writeThread + ", client="
				+ client + ", phoneNumber=" + phoneNumber + "]";
	}

}
