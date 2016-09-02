package com.neosoft;

import java.util.Scanner;

import com.neosoft.IHardwareStatusListener.HardwareStatus;

public class HardwareEmulator {
	private final IHardwareStatusListener inputCallback;

	public HardwareEmulator(IHardwareStatusListener inputCallback) {
		super();
		this.inputCallback = inputCallback;

		new Thread(new Runnable() {
			@Override
			public void run() {
				Scanner scanner = new Scanner(System.in);

				while (true) {
					String input = scanner.next();
					
					if (null != HardwareEmulator.this.inputCallback)
					{
						HardwareStatus status = HardwareStatus.HardwareStatusInvalid;
						
						try {
							int statusIndex = Integer.parseInt(input);
							
							if (statusIndex >= 0 && statusIndex < HardwareStatus.values().length)
							{
								status = HardwareStatus.values()[statusIndex];
							}
						} catch (NumberFormatException e) {
							/* ignore */
						}
						
						if (status != HardwareStatus.HardwareStatusInvalid)
						{
							HardwareEmulator.this.inputCallback.OnHardwareStatusChanged(status);
						}
					}
					
					if ("Q".equals(input))
					{
						break;
					}
				}
				
				scanner.close();
			}
		}).start();
	}
}
