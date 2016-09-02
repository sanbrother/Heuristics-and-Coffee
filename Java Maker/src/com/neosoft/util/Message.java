package com.neosoft.util;

public class Message {
	private final int messageID;
	private Object extra = null;

	public Message(int messageID) {
		super();
		this.messageID = messageID;
	}

	public int getMessageID() {
		return messageID;
	}
	
	public Object getExtra() {
		return extra;
	}

	public void setExtra(Object extra) {
		this.extra = extra;
	}
}
