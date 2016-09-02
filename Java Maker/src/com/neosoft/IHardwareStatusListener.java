package com.neosoft;

public interface IHardwareStatusListener {
	enum HardwareStatus {
		HardwareStatusInvalid,
		HardwareStatusBoilerEmpty,
		HardwareStatusBoilerNotEmpty
	}
	void OnHardwareStatusChanged(HardwareStatus status);
}
