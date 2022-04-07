package com.sbi;
public class Engine 
{
	Piston piston;
	public Engine(Piston pistRef)
	{
		piston = pistRef;
		System.out.println("Engine() constructor");
		piston.firePiston();
	}
	public void startEngine()
	{
		
		System.out.println("Starting the Engine");
	}
	public void stopEngine()
	{
		System.out.println("Stoping the Engine");
	}
}
