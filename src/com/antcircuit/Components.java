package com.antcircuit;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class Components {
	
	public Point2D topLeft;
	public int id;
	public BufferedImage img;
	String compName;
	public String antFile;
	
	public float inputA;
	public float inputB;
	//public float input;
	public float pump_a;
	public float pump_b;
	public float battery;	
	
	public int offsetInputX1;
	public int offsetInputY1;
	public int offsetInputX2;
	public int offsetInputY2;
	public int offsetOutputX1;
	public int offsetOutputY1;
	public int gateOffsetX;
	public int gateOffsetY;
	public int gatePlaceX;
	public int gatePlaceY;
	public int wireOffsetX;
	public int wireOffsetY;
	public int IntersectionOffsetX;
	public int IntersectionOffsetY;
	public int gatePresentInputOffsetX1;
	public int gatePresentInputOffsetX2;
	public int gatePresentInputOffsetY1;
	public int gatePresentInputOffsetY2;
	public int gatePresentOutputOffset;
	
	public Concentration gate;
	public float getPump_a()
	{
		return pump_a;
	}
	public float getPump_b()
	{
		return pump_b;
	}
	public float getBattery()
	{
		return battery;
	}
	
}

