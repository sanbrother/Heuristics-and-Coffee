package com.neosoft;


public class Main  {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CoffeeMaker maker = new CoffeeMaker();
		new HardwareEmulator(maker);
		
		maker.run();
	}


}
