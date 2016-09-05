package com.neosoft;

import com.neosoft.util.IMessageQueue;
import com.neosoft.util.Message;
import com.neosoft.util.MessageQueue;

public class CoffeeMaker implements IHardwareStatusListener {
	private final IMessageQueue queue = new MessageQueue();
	
	public void run()
	{
		Message message;
		
		while ((message = queue.get()) != null)
		{
			System.out.println("Hardware status changed : " + message.getExtra().toString());
		}
	}

	@Override
	public void OnHardwareStatusChanged(HardwareStatus status) {
		if (status == HardwareStatus.HardwareStatusInvalid)
		{
			return;
		}
		
		Message message = new Message(Message.MESSAGE_ID_HARDWARE_STATUS_CHANGED);
		message.setExtra(status);
		
		this.queue.post(message);
	}

}
