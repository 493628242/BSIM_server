package com.wangjiyuan.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by wjy on 2017/3/11.
 */

public class Group implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String title;
	private int isExpand;// 代表是否展开 0代表：未展开 1代表：已展开
	private ArrayList<Friend> childs;
	private int childsize;

	public Group() {
	}

	public int getChildsize() {
		return childsize;
	}

	public ArrayList<Friend> getChilds() {
		return childs;
	}

	public void setChilds(ArrayList<Friend> childs) {
		this.childs = childs;
	}

	public int getIsExpand() {
		return isExpand;
	}

	public void setIsExpand(int isExpand) {
		this.isExpand = isExpand;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
