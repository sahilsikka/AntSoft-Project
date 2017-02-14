package com.antcircuit;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JFrame;

import org.jfree.ui.RefineryUtilities;

import java.beans.*; //Property change stuff
import java.awt.*;
import java.awt.event.*;

public class SimulationBox extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AntSimulation antSimulationCheck;
	public static boolean isSimulationCalled=false;
	JLabel label;
	JFrame frame;
	JTextField thrText;
	JTextField diffText;
	JTextField dissText;
	JTextField antSText;
	public static boolean simulationRun=false;

	/** Creates the GUI shown inside the frame's content pane. */
	public SimulationBox(JFrame frame) {

		super(new BorderLayout());
		this.frame = frame;

		JPanel panel1 = new JPanel(new GridLayout(4, 3));

		JLabel thrLabel = new JLabel("Threshold");
		thrLabel.setBorder(BorderFactory.createEtchedBorder());
		JLabel diffLabel = new JLabel("Diffusion rate");
		diffLabel.setBorder(BorderFactory.createEtchedBorder());
		JLabel dissLabel = new JLabel("Dissipation rate");
		dissLabel.setBorder(BorderFactory.createEtchedBorder());
		JLabel antSLabel = new JLabel("Ant Srcretion");
		antSLabel.setBorder(BorderFactory.createEtchedBorder());
		JLabel emptyLabel1 = new JLabel();
		emptyLabel1.setBorder(BorderFactory.createEtchedBorder());
		JLabel emptyLabel2 = new JLabel();
		emptyLabel2.setBorder(BorderFactory.createEtchedBorder());
		JLabel emptyLabel3 = new JLabel();
		emptyLabel3.setBorder(BorderFactory.createEtchedBorder());
		JLabel emptyLabel4 = new JLabel();
		emptyLabel4.setBorder(BorderFactory.createEtchedBorder());
		
		thrText = new JTextField();
		thrText.setBorder(BorderFactory.createEtchedBorder());
		
		diffText = new JTextField();
		diffText.setBorder(BorderFactory.createEtchedBorder());
		dissText = new JTextField();
		dissText.setBorder(BorderFactory.createEtchedBorder());
		antSText = new JTextField();
		antSText.setBorder(BorderFactory.createEtchedBorder());

		panel1.add(thrLabel);
		panel1.add(emptyLabel1);
		panel1.add(thrText);
		panel1.add(diffLabel);
		panel1.add(emptyLabel2);
		panel1.add(diffText);
		panel1.add(dissLabel);
		panel1.add(emptyLabel3);
		panel1.add(dissText);
		panel1.add(antSLabel);
		panel1.add(emptyLabel4);
		panel1.add(antSText);

		add(panel1, BorderLayout.NORTH);
		JButton button = new JButton("Simulate!");
		add(button, BorderLayout.SOUTH);
		button.addActionListener(this);
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = SimulationBox.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		simulationRun=true;
		float f = Float.parseFloat(dissText.getText());
			antSimulationCheck=new AntSimulation(Float.parseFloat(dissText.getText()),
			Float.parseFloat(diffText.getText()),
			Float.parseFloat(antSText.getText()),
			Float.parseFloat(thrText.getText()));
			String result=AntSimulation.finalresult;
			JOptionPane.showMessageDialog(null, result);
			//new AntSimulation((float)0.1, (float)0.1, (float)6.0, (float)3.0);
			/*
			GraphSimulator demo = new GraphSimulator("ant");
			
	        demo.pack();
	        RefineryUtilities.centerFrameOnScreen(demo);
	        demo.setVisible(true);*/
		}
	
	private void GraphSimulator(String string) {
		// TODO Auto-generated method stub
		
	}
	
}