package com.wangjiyuan.bean;

import java.io.Serializable;


/**
 * Created by wjy on 2017/2/5.
 */

public class Friend implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nickname;    //昵称
    private int sex;    //性别
    private String headimage;   //头像
    private String phonenumber; //电话号码

    public Friend() {
    }

    public Friend(FriendWithMesg friendWithMesg) {
        this.headimage = friendWithMesg.getHeadimage();
        this.sex = friendWithMesg.getSex();
        this.phonenumber = friendWithMesg.getPhonenumber();
        this.nickname = friendWithMesg.getNickname();
    }

    public Friend(Friend friend) {
        this.headimage = friend.headimage;
        this.nickname = friend.nickname;
        this.phonenumber = friend.phonenumber;
        this.sex = friend.sex;
    }

    public String getHeadimage() {
        return headimage;
    }

    public void setHeadimage(String headimage) {
        this.headimage = headimage;
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

    @Override
    public String toString() {
        return "Friend{" +
                "headimage='" + headimage + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex=" + sex +
                ", phonenumber='" + phonenumber + '\'' +
                '}';
    }

}
