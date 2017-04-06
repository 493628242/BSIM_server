package com.wangjiyuan.bean;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wjy on 2017/2/22.
 */

public class Message implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SerializedName("content")
	private String content;
	@SerializedName("time")
    private Long time;
	@SerializedName("formnickname")
    private String formnickname;
	@SerializedName("tonickname")
    private String tonickname;
	@SerializedName("form")
    private String form;
	@SerializedName("to")
    private String to;
	@SerializedName("type")
    private int type;//类型 1为文本，0为图片
	

    public static final int TEXT = 1;
    public static final int IMAGE = 0;

    public Message() {

    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    public String getFormnickname() {
        return formnickname;
    }

    public void setFormnickname(String formnickname) {
        this.formnickname = formnickname;
    }

    public String getTonickname() {
        return tonickname;
    }

    public void setTonickname(String tonickname) {
        this.tonickname = tonickname;
    }
    @Override
    public String toString() {
    	return "Message{" +
                "content='" + content + '\'' +
                ", time=" + time +
                ", form='" + form + '\'' +
                ", to='" + to + '\'' +
                ", tonickname='" + tonickname + '\'' +
                ", formnickname='" + formnickname + '\'' +
                ", type=" + type +
                '}';
    }
}
