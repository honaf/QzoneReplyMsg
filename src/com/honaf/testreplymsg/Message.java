package com.honaf.testreplymsg;

import java.io.Serializable;

public class Message implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String from ;
	private String to;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
		
	}
	public Message(String id,String from, String to, String msg) {
		super();
		this.id=id;
		this.from = from;
		this.to = to;
		this.msg = msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	private String msg;

}
