package com.sbi.level2;

import com.sbi.level2.*;

public class Car 
{
	Engine engine;	//hasA
	public void setEngine(Engine ref)
	{
		System.out.println("setEngine() invoked");
		engine = ref;
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
