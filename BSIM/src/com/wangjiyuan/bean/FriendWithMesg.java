package com.wangjiyuan.bean;

import java.io.Serializable;

/**
 * Created by wjy on 2017/3/4.
 */

public class FriendWithMesg implements Serializable, Comparable<FriendWithMesg> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String LastChatMesg; //最新的消息
    private String nickname;    //昵称
    private int sex;    //性别
    private String headimage;   //头像
    private String phonenumber; //电话号码
    private Long time;

    public FriendWithMesg() {
    }


    public String getHeadimage() {
        return headimage;
    }

    public void setHeadimage(String headimage) {
        this.headimage = headimage;
    }

    public String getLastChatMesg() {
        return LastChatMesg;
    }

    public void setLastChatMesg(String lastChatMesg) {
        LastChatMesg = lastChatMesg;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "FriendWithMesg{" +
                "headimage='" + headimage + '\'' +
                ", LastChatMesg='" + LastChatMesg + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex=" + sex +
                ", phonenumber='" + phonenumber + '\'' +
                ", time=" + time +
                '}';
    }


    public int compareTo(FriendWithMesg o) {
        return (int) (o.time - this.time);
    }
}

