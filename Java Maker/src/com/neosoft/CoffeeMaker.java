package com.neosoft;

import com.neosoft.util.Message;
import com.neosoft.util.MessageQueue;

public class CoffeeMaker implements IHardwareStatusListener {
	private final MessageQueue queue = new MessageQueue();
	
	public void run()
	{
		Message message;
		
		while ((message = queue.get()) != null)
		{
			System.out.println("Message ID = " + message.getMessageID());
		}
	}

	@Override
	public void OnHardwareStatusChanged(HardwareStatus status) {
		if (status == HardwareStatus.HardwareStatusInvalid)
		{
			return;
		}
		
		this.queue.post(new Message(status.ordinal()));
	}

}
