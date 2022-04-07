package com.sbi.level2;

import com.sbi.level2.*;

public class Engine
{
	Piston piston;
	public void setPiston(Piston pistRef)
	{
		piston = pistRef;
		System.out.println("setPiston() invoked");
		
	}
	public void startEngine()
	{
		piston.firePiston();
		System.out.println("Starting the Engine");
	}
	public void stopEngine()
	{
		System.out.println("Stoping the Engine");
	}

}
