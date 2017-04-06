package com.wangjiyuan.bean;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wjy on 2017/2/17.
 */

public class BaseUser implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SerializedName("phonenumber")
	protected String phonenumber; // 电话号码
	@SerializedName("password")
	protected String password; // 密码

	public BaseUser() {
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getPassword() {
		return password;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

}
