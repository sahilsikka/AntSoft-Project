package com.antcircuit;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AntOpener extends JPanel{

	public AntOpener(){
		JFrame frame = new JFrame ("MyPanel");
	    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().add (new MyPanel());
	    frame.pack();
	    frame.setVisible (true);
	
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
	}
}

	class MyPanel extends JPanel
	{
		
	}
