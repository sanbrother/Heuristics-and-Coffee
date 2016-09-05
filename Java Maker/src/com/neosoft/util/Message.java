package com.neosoft.util;

public class Message {
	public final static int MESSAGE_ID_HARDWARE_STATUS_CHANGED = 1;

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
