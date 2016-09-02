package com.neosoft.util;

import java.util.concurrent.LinkedBlockingQueue;

public class MessageQueue {
	private final LinkedBlockingQueue<Message> messages = new LinkedBlockingQueue<>(64);
	
	public boolean post(final Message message) {
		boolean ret = true;

		try {
			this.messages.put(message);
		} catch (InterruptedException e) {
			ret = false;
		}

		return ret;
	}
	
	public Message get()
	{
		Message message = null;
		
		try {
			message = this.messages.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return message;
	}
}
