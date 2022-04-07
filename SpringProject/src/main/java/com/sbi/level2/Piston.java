package com.sbi.level2;

public class Piston 
{
	
	String pistonType;
	public void setPistonType(String p)
	{
		System.out.println("setPistonType invoked");
		pistonType = p;
	}
	public void firePiston()
	{
		System.out.println("Piston is fired");
		
	}

}
