package com.sbi;

public class Car
{
	Engine engine;	//hasA
	public Car(Engine ref) 
	{
		engine = ref;
		System.out.println("car() is constructed");
	}

	public void startTheCar()
	{
		
		engine.startEngine();
		System.out.println("Car Started");
	}
	public void stopTheCar()
	{
		
		engine.stopEngine();
		System.out.println("Car Stopped ");
	}

}
