package com.wangjiyuan.information;

import java.util.HashMap;

public class UserInformation {

	private static HashMap<String, String> ipAndpn;

	public synchronized static HashMap<String, String> getPnAndip() {
		if (ipAndpn == null) {
			ipAndpn = new HashMap<String, String>();
		}
		return ipAndpn;
	}

	public synchronized static void addInformation(String phoneNumber, String ipAddress) {
		if (ipAndpn == null) {
			ipAndpn = new HashMap<String, String>();
		}
		ipAndpn.put(ipAddress, phoneNumber);
	}

}
