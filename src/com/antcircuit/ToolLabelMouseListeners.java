package com.antcircuit;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ToolLabelMouseListeners extends JPanel {
	public static int count=0;
	
	public static void andClicked() {
		
		System.out.println("andclicked reached");
		DisplayCanvas.bi = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
		//DisplayCanvas.bufferedImage.add(DisplayCanvas.bi);
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("./images/and.png"));///ClassLoader.getSystemResource("and.gif"));
			System.out.println("entered in");
			//DisplayCanvas.bufferedImage.add(DisplayCanvas.bi);
			//comp.img=DisplayCanvas.bi;
			//DisplayCanvas.component.add(e)
		} catch (IOException e) {
		}

		AntGUI.canvas.g = DisplayCanvas.bi.createGraphics();//DisplayCanvas.bufferedImage.get(count++).createGraphics();
		AntGUI.canvas.g.drawImage(img, 0, 0, null);
				
	}

	public static void orClicked() {
		
		System.out.println("orclicked reached");
		DisplayCanvas.bi = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("./images/or.png"));
			System.out.println("entered in");
//		DisplayCanvas.comp.img=DisplayCanvas.bi;
		} catch (IOException e) {
		}

		AntGUI.canvas.g = AntGUI.canvas.g = DisplayCanvas.bi.createGraphics();//DisplayCanvas.bufferedImage.get(count++).createGraphics();
		AntGUI.canvas.g.drawImage(img, 0, 0, null);
		System.out.println("in orclicked()"+DisplayCanvas.bufferedImage.size());
	}

	public static void notClicked() {

		System.out.println("andclicked reached");
		DisplayCanvas.bi = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
		//DisplayCanvas.bufferedImage.add(DisplayCanvas.bi);
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("./images/Enotgate.png"));
			System.out.println("entered in");
	//		DisplayCanvas.comp.img=DisplayCanvas.bi;
		} catch (IOException e) {
		}

		AntGUI.canvas.g = AntGUI.canvas.g = DisplayCanvas.bi.createGraphics();//DisplayCanvas.bufferedImage.get(count++).createGraphics();
		AntGUI.canvas.g.drawImage(img, 0, 0, null);
	}

	public static void inputClicked() {

		System.out.println("andclicked reached");
		DisplayCanvas.bi = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
		//DisplayCanvas.bufferedImage.add(DisplayCanvas.bi);
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("./images/input.png"));
			System.out.println("entered in");
	//		DisplayCanvas.comp.img=DisplayCanvas.bi;
		} catch (IOException e) {
		}

		AntGUI.canvas.g = AntGUI.canvas.g = DisplayCanvas.bi.createGraphics();//DisplayCanvas.bufferedImage.get(count++).createGraphics();
		AntGUI.canvas.g.drawImage(img, 0, 0, null);
	}
	
	public static void outputClicked() {

		System.out.println("andclicked reached");
		DisplayCanvas.bi = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
		//DisplayCanvas.bufferedImage.add(DisplayCanvas.bi);
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("./images/output.png"));
			System.out.println("entered in");
	//		DisplayCanvas.comp.img=DisplayCanvas.bi;
		} catch (IOException e) {
		}

		AntGUI.canvas.g = AntGUI.canvas.g = DisplayCanvas.bi.createGraphics();//DisplayCanvas.bufferedImage.get(count++).createGraphics();
		AntGUI.canvas.g.drawImage(img, 0, 0, null);
	}


	/*public static void muxClicked() {

		System.out.println("andclicked reached");
		DisplayCanvas.bi = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
		//DisplayCanvas.bufferedImage.add(DisplayCanvas.bi);
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("./src/com/antcircuit/multiplexer.png"));
			System.out.println("entered in");
	//		DisplayCanvas.comp.img=DisplayCanvas.bi;
		} catch (IOException e) {
		}

		AntGUI.canvas.g = AntGUI.canvas.g = DisplayCanvas.bi.createGraphics();//DisplayCanvas.bufferedImage.get(count++).createGraphics();
		AntGUI.canvas.g.drawImage(img, 0, 0, null);
	}
	*/
}