package com.antcircuit;

import java.awt.geom.Point2D;

public class AndGate extends Components {
	
	AndConcentration andAntGate;
	public AndGate(int x, int y) {
		
		double newX = (double) x;
		double newY = (double) y;
		Point2D p = new Point2D.Double(x,y);
		inputA=0;
		inputB=0;
		topLeft = p;
		compName = "AND";
		antFile="./images/antcomponents/AndGateExt.png";
		offsetInputX1=-10;
		offsetInputY1=-25;
		offsetInputX2=10;
		offsetInputY2=-200;
		offsetOutputX1=-370;
		offsetOutputY1=0;
		wireOffsetX=545;
		wireOffsetY=-5;
		IntersectionOffsetX=-540;
		IntersectionOffsetY=-175;
		gatePresentInputOffsetX1=35;
		gatePresentInputOffsetY1=-70;
		gatePresentInputOffsetX2=0;//-350
		gatePresentInputOffsetY2=85;
		//gatePresentInputOffsetX2=-368;//-368
		gatePresentOutputOffset=550;
		gate = new AndConcentration();
	}
	
}
