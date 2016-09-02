package com.neosoft.util;

public interface IMessageQueue {
	public boolean post(final Message message);
	public Message get();
}
