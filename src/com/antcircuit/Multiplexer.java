package com.antcircuit;

import java.awt.geom.Point2D;

public class Multiplexer extends Components {
		
	public Multiplexer(int x, int y) {
		
		double newX = (double) x;
		double newY = (double) y;
		Point2D p = new Point2D.Double(x,y);
		topLeft = p;
		compName = "Multiplexer";
		antFile="./src/com/antcircuit/antcomponents/mux.png";
		offsetInputX1=-100;
		offsetInputY1=-255;
		offsetInputX2=10;
		offsetInputY2=-200;
		offsetOutputX1=500;
		offsetOutputY1=0;
		wireOffsetX=545;
		wireOffsetY=-5;
		IntersectionOffsetX=-840;
		IntersectionOffsetY=-175;
		gatePresentInputOffsetX1=35;
		gatePresentInputOffsetY1=-70;
		gatePresentInputOffsetX2=0;//-350
		gatePresentInputOffsetY2=85;
		//gatePresentInputOffsetX2=-368;//-368
		gatePresentOutputOffset=2550;
	}
	
}
