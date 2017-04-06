package com.wangjiyuan.bean;

import java.io.Serializable;

import com.wangjiyuan.bean.BaseUser;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wjy on 2017/2/5.
 */

public class User extends BaseUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SerializedName("nickname")
	private String nickname; // 昵称
	@SerializedName("sex")
	private int sex; // 性别
	@SerializedName("headimage")
	private String headimage; // 头像
	@SerializedName("token")
	private String token; // 用于服务器验证身份

	public User() {
		super();

	}

	public void setHeadimage(String headimage) {
		this.headimage = headimage;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getHeadimage() {
		return headimage;
	}

	public String getNickname() {
		return nickname;
	}

	public int getSex() {
		return sex;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "User{" + "phonenumber='" + phonenumber + '\'' + ", password='"
				+ password + '\'' + ", headimage='" + headimage + '\''
				+ ", nickname='" + nickname + '\'' + ", sex=" + sex + '\''
				+ ", token=" + token + '}';
	}
}
