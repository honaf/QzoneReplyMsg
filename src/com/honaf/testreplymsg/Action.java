package com.honaf.testreplymsg;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Action implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String action;
	private List<Message> msgList=new ArrayList<Message>();
	public String getId() {
		return id;
	}
	public Action(String id, String action, List<Message> actionList) {
		super();
		this.id = id;
		this.action = action;
		this.msgList = actionList;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public List<Message> getMsgList() {
		return msgList;
	}
	public void setMsgList(List<Message> msgList) {
		this.msgList = msgList;
	}
	
}
