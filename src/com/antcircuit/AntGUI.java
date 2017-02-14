package com.antcircuit;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.Line;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalToggleButtonUI;
import javax.swing.plaf.synth.SynthLookAndFeel;

import org.jfree.ui.RefineryUtilities;

import de.javasoft.plaf.synthetica.SyntheticaClassyLookAndFeel;

public class AntGUI extends JFrame implements ActionListener, ItemListener {

	static Container container;

	public static DisplayCanvas canvas = null;
	Components comp;
	private JTextField filename = new JTextField();

	String number;
	static int countExit = 0;
	static String ProjectName;
	public static final int COMP_OR = 1;
	public static final int COMP_AND = 2;
	public static final int COMP_NOT = 3;
	public static final int COMP_WIRE = 4;
	public static final int COMP_INPUT = 5;
	public static final int COMP_OUTPUT = 6;
	public static final int NONE = 0;

	public static int CompFLAG = NONE;
	public static int wireFLAG = NONE;
	public static int clearClicked = 0;
	public static int buttonclicked = 0;

	public static float inputValue;
	public static Components simulationComponentSelected;

	JToggleButton andLabel;
	JToggleButton orLabel;
	JToggleButton notLabel;
	JToggleButton inputLabel;
	JToggleButton outputLabel;
	JToggleButton wireLabel;
	JButton simulateButton = new JButton("Simulate Circuit");
	JButton showGraphButton = new JButton("Show Graph");

	static JLabel selectedLabel;
	JLabel attr1;
	JLabel attr2;
	JLabel attr3;
	JLabel attr4;
	JLabel attr5;
	JLabel attr6;
	JLabel attr7;
	JLabel attr8;
	JLabel attr9;
	JLabel attr10;
	JLabel attr11;
	JLabel attr12;
	JLabel attr13;
	JLabel attr14;
	JLabel attr15;

	static JTextField field1;
	static JTextField field2;
	static JTextField field3;
	static JTextField field4;
	static JTextField field5;
	static JTextField field6;
	static JTextField field7;
	static JTextField field8;
	static JTextField field9;
	static JTextField field10;
	static JTextField field11;
	static JTextField field12;
	static JTextField field13;
	static JTextField field14;
	static JTextField field15;

	JButton clearButton;
	JButton saveButtonInput;
	JButton saveButtonNot;
	JButton saveButtonAnd;
	JButton saveButtonOr;
	// JButton saveButtonInput;
	static JPanel DisplayPanel;
	JPanel DisplayPanel1;

	JPanel sidePanel;
	JPanel toolPanel;
	JPanel simulateButtons;
	static JPanel attributePanel;
	JPanel inputAttributePanel;
	JPanel andAttributePanel;
	JPanel orAttributePanel;
	JPanel notAttributePanel;
	JPanel wireAttributePanel;
	JPanel defAttributePanel;
	JPanel toolinputAttributePanel;
	JPanel toolandAttributePanel;
	JPanel toolorAttributePanel;
	JPanel toolnotAttributePanel;
	JPanel toolwireAttributePanel;

	String toolSelected;

	public AntGUI() {

		container = getContentPane();

		canvas = new DisplayCanvas();

		setJMenuBar(createMenuBar());

		DisplayPanel = new JPanel(new CardLayout());
		DisplayPanel1 = new JPanel(new BorderLayout());

		DisplayPanel1.add(canvas, BorderLayout.CENTER);

		DisplayPanel.add(DisplayPanel1, "canvas");

		setDisplayPanel("antcanvas");
		container.add(DisplayPanel, BorderLayout.CENTER);

		sidePanel = new JPanel();
		sidePanel.setLayout(new GridLayout(3, 1));
		sidePanel.setBackground(new Color(83, 83, 83));
		toolPanel = new JPanel();
		toolPanel.setBackground(new Color(83, 83, 83));
		// toolPanel.setLayout(new GridLayout(1, 8));
		toolPanel.setLayout(new BoxLayout(toolPanel, BoxLayout.LINE_AXIS));
		toolPanel.setPreferredSize(new Dimension(100, 50));
		toolPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		simulateButtons = new JPanel();
		simulateButtons.setBackground(new Color(83, 83, 83));
		// toolPanel.setLayout(new GridLayout(1, 8));
		simulateButtons.setLayout(new BoxLayout(simulateButtons,
				BoxLayout.LINE_AXIS));
		simulateButtons.setPreferredSize(new Dimension(200, 50));
		simulateButtons.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		toolPanel.add(simulateButtons, BorderLayout.EAST);

		andLabel = new JToggleButton();
		orLabel = new JToggleButton();
		notLabel = new JToggleButton();
		inputLabel = new JToggleButton();
		outputLabel = new JToggleButton();
		wireLabel = new JToggleButton("wire");
		wireLabel.setFont(new Font("Serif", Font.BOLD, 17));
		wireLabel.setForeground(new Color(255, 255, 255));
		wireLabel.setHorizontalAlignment(SwingConstants.CENTER);
		saveButtonInput = new JButton("save");
		saveButtonInput.setForeground(new Color(255, 255, 255));
		saveButtonOr = new JButton("save");
		saveButtonOr.setForeground(new Color(255, 255, 255));
		saveButtonAnd = new JButton("save");
		saveButtonAnd.setForeground(new Color(255, 255, 255));
		saveButtonNot = new JButton("save");
		saveButtonNot.setForeground(new Color(255, 255, 255));
		setDisplayPanel("canvas");

		andLabel.setIcon(new ImageIcon("./images/andTool.png"));
		andLabel.setHorizontalAlignment(SwingConstants.CENTER);
		// andLabel.setPreferredSize(new Dimension(200,20));

		andLabel.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent evt) {
				CompFLAG = COMP_AND;
				DisplayCanvas.selectComponent = "off";
				AntGUI.wireFLAG = AntGUI.NONE;

				// andLabel.setBorder(BorderFactory.createLoweredBevelBorder());

				orLabel.setSelected(false);
				notLabel.setSelected(false);
				inputLabel.setSelected(false);
				outputLabel.setSelected(false);
				wireLabel.setSelected(false);

				/*
				 * orLabel.setBackground(Color.white);
				 * notLabel.setBackground(Color.WHITE);
				 * wireLabel.setBackground(Color.WHITE);
				 * inputLabel.setBackground(Color.WHITE);
				 * outputLabel.setBackground(Color.WHITE);
				 */

				toolSelected = "AND";
				setAttributePanel("Tool Selected: AND GATE ", "AND", -1);

			}
		});

		orLabel.setIcon(new ImageIcon("./images/orTool.png"));
		orLabel.setHorizontalAlignment(SwingConstants.CENTER);
		orLabel.setSize(20, 20);
		orLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				CompFLAG = COMP_OR;
				AntGUI.wireFLAG = AntGUI.NONE;
				DisplayCanvas.selectComponent = "off";
				/*
				 * orLabel.setOpaque(true); andLabel.setOpaque(false);
				 * notLabel.setOpaque(false); wireLabel.setOpaque(false);
				 * inputLabel.setOpaque(false); outputLabel.setOpaque(false);
				 * orLabel.setForeground(Color.green);
				 * orLabel.setBackground(Color.green);
				 * andLabel.setBackground(Color.WHITE);
				 * notLabel.setBackground(Color.WHITE);
				 * wireLabel.setBackground(Color.WHITE);
				 * inputLabel.setBackground(Color.WHITE);
				 * outputLabel.setBackground(Color.WHITE);
				 */

				andLabel.setSelected(false);
				notLabel.setSelected(false);
				inputLabel.setSelected(false);
				outputLabel.setSelected(false);
				wireLabel.setSelected(false);

				toolSelected = "OR";
				setAttributePanel("Tool Selected: OR GATE   ", "OR", -1);
				orLabel.setBackground(new Color(0x80, 0x80, 0xFF));
				inputAttributePanel.setVisible(false);
				andAttributePanel.setVisible(false);
				notAttributePanel.setVisible(false);
				orAttributePanel.setVisible(false);
			}
		});

		notLabel.setIcon(new ImageIcon("./images/notTool.png"));
		notLabel.setHorizontalAlignment(SwingConstants.CENTER);

		notLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				CompFLAG = COMP_NOT;
				DisplayCanvas.selectComponent = "off";
				AntGUI.wireFLAG = AntGUI.NONE;
				/*
				 * notLabel.setOpaque(true); orLabel.setOpaque(false);
				 * andLabel.setOpaque(false); wireLabel.setOpaque(false);
				 * inputLabel.setOpaque(false); outputLabel.setOpaque(false);
				 * notLabel.setForeground(Color.green);
				 * notLabel.setBackground(Color.green);
				 * orLabel.setBackground(Color.WHITE);
				 * andLabel.setBackground(Color.WHITE);
				 * wireLabel.setBackground(Color.WHITE);
				 * inputLabel.setBackground(Color.WHITE);
				 * outputLabel.setBackground(Color.WHITE);
				 */

				andLabel.setSelected(false);
				orLabel.setSelected(false);
				inputLabel.setSelected(false);
				outputLabel.setSelected(false);
				wireLabel.setSelected(false);

				toolSelected = "NOT";

				setAttributePanel("Tool Selected: NOT GATE ", "NOT", -1);
				notLabel.setBackground(new Color(0x80, 0x80, 0xFF));
				inputAttributePanel.setVisible(false);
				andAttributePanel.setVisible(false);
				notAttributePanel.setVisible(false);
				orAttributePanel.setVisible(false);
			}
		});

		inputLabel.setIcon(new ImageIcon("./images/input.png"));
		inputLabel.setHorizontalAlignment(SwingConstants.CENTER);
		inputLabel.setSize(20, 20);
		inputLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				CompFLAG = COMP_INPUT;
				DisplayCanvas.selectComponent = "off";
				AntGUI.wireFLAG = AntGUI.NONE;
				/*
				 * inputLabel.setOpaque(true); orLabel.setOpaque(false);
				 * notLabel.setOpaque(false); wireLabel.setOpaque(false);
				 * andLabel.setOpaque(false); outputLabel.setOpaque(false);
				 * inputLabel.setForeground(Color.green);
				 * inputLabel.setBackground(Color.green);
				 * orLabel.setBackground(Color.WHITE);
				 * andLabel.setBackground(Color.WHITE);
				 * notLabel.setBackground(Color.WHITE);
				 * wireLabel.setBackground(Color.WHITE);
				 * outputLabel.setBackground(Color.WHITE);
				 */toolSelected = "INPUT";

				orLabel.setSelected(false);
				notLabel.setSelected(false);
				andLabel.setSelected(false);
				outputLabel.setSelected(false);
				wireLabel.setSelected(false);

				setAttributePanel("Tool Selected: INPUT ", "INPUT", -1);
				inputLabel.setBackground(new Color(0x80, 0x80, 0xFF));
				inputAttributePanel.setVisible(false);
				andAttributePanel.setVisible(false);
				notAttributePanel.setVisible(false);
				orAttributePanel.setVisible(false);
			}
		});

		outputLabel.setIcon(new ImageIcon("./images/output.png"));
		outputLabel.setHorizontalAlignment(SwingConstants.CENTER);
		outputLabel.setSize(20, 20);
		outputLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				CompFLAG = COMP_OUTPUT;
				DisplayCanvas.selectComponent = "off";
				AntGUI.wireFLAG = AntGUI.NONE;
				/*
				 * outputLabel.setOpaque(true); orLabel.setOpaque(false);
				 * notLabel.setOpaque(false); wireLabel.setOpaque(false);
				 * inputLabel.setOpaque(false); andLabel.setOpaque(false);
				 * outputLabel.setForeground(Color.green);
				 * outputLabel.setBackground(Color.green);
				 * orLabel.setBackground(Color.WHITE);
				 * andLabel.setBackground(Color.WHITE);
				 * notLabel.setBackground(Color.WHITE);
				 * inputLabel.setBackground(Color.WHITE);
				 * wireLabel.setBackground(Color.WHITE);
				 */
				orLabel.setSelected(false);
				notLabel.setSelected(false);
				andLabel.setSelected(false);
				inputLabel.setSelected(false);
				wireLabel.setSelected(false);

				outputLabel.setBackground(new Color(0x80, 0x80, 0xFF));
				toolSelected = "OUT";
				setAttributePanel("Tool Selected: OUTPUT ", "OUTPUT", -1);
				inputAttributePanel.setVisible(false);
				andAttributePanel.setVisible(false);
				notAttributePanel.setVisible(false);
				orAttributePanel.setVisible(false);
			}
		});

		wireLabel.setSize(20, 20);
		wireLabel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				wireFLAG = COMP_WIRE;
				CompFLAG = NONE;
				DisplayCanvas.selectComponent = "off";
				System.out.println("wireflag is " + wireFLAG);
				/*
				 * wireLabel.setOpaque(true); orLabel.setOpaque(false);
				 * notLabel.setOpaque(false); andLabel.setOpaque(false);
				 * inputLabel.setOpaque(false); outputLabel.setOpaque(false);
				 * wireLabel.setForeground(Color.white); wireLabel.setFont(new
				 * Font("Serif", Font.BOLD, 17)); wireLabel.setBackground(new
				 * Color(0x80, 0x80, 0xFF)); orLabel.setBackground(Color.WHITE);
				 * notLabel.setBackground(Color.WHITE);
				 * andLabel.setBackground(Color.WHITE);
				 * inputLabel.setBackground(Color.WHITE);
				 */
				toolSelected = "WIRE";
				setAttributePanel("Tool Selected: WIRE", "WIRE", -1);
				inputAttributePanel.setVisible(false);
				andAttributePanel.setVisible(false);
				notAttributePanel.setVisible(false);
				orAttributePanel.setVisible(false);
			}
		});

		clearButton = new JButton("Clear");
		clearButton.setHorizontalAlignment(SwingConstants.CENTER);
		clearButton.setSize(20, 20);
		// clearButton.setBackground(new Color(59, 89, 182));
		clearButton.setForeground(Color.WHITE);
		clearButton.setFocusPainted(false);
		clearButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setDisplayPanel("canvas");
				clearClicked = 1;
				DisplayCanvas.clear();
				inputAttributePanel.setVisible(false);
				andAttributePanel.setVisible(false);
				notAttributePanel.setVisible(false);
				orAttributePanel.setVisible(false);
			}
		});

		JButton genAntCircuit = new JButton("Ant Circuit");
		genAntCircuit.setHorizontalAlignment(SwingConstants.CENTER);
		genAntCircuit.setSize(20, 20);
		genAntCircuit.setBackground(new Color(59, 89, 182));
		genAntCircuit.setForeground(Color.WHITE);
		genAntCircuit.setFocusPainted(false);
		genAntCircuit.setFont(new Font("Tahoma", Font.BOLD, 12));
		genAntCircuit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SaveFile.saveImage();
			}
		});

		simulateButton.setHorizontalAlignment(SwingConstants.CENTER);
		simulateButton.setSize(20, 20);
		simulateButton.setBackground(new Color(59, 89, 182));
		simulateButton.setForeground(Color.WHITE);
		simulateButton.setFocusPainted(false);
		simulateButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		simulateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				simulateCaller();
			}
		});

		showGraphButton.setHorizontalAlignment(SwingConstants.CENTER);
		showGraphButton.setSize(20, 20);
		showGraphButton.setBackground(new Color(59, 89, 182));
		showGraphButton.setForeground(Color.WHITE);
		showGraphButton.setFocusPainted(false);
		showGraphButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		showGraphButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				showGraphCaller();
			}
		});

		toolPanel.add(Box.createHorizontalStrut(15));
		toolPanel.add(andLabel);
		toolPanel.add(Box.createHorizontalStrut(15));

		JSeparator separator = new JSeparator(JSeparator.VERTICAL);
		Dimension size = new Dimension(separator.getPreferredSize().width,
				separator.getMaximumSize().height);
		separator.setMaximumSize(size);
		toolPanel.add(separator);

		toolPanel.add(Box.createHorizontalStrut(15));
		toolPanel.add(orLabel);
		toolPanel.add(Box.createHorizontalStrut(15));

		separator = new JSeparator(JSeparator.VERTICAL);

		size = new Dimension(separator.getPreferredSize().width,
				separator.getMaximumSize().height);
		separator.setMaximumSize(size);
		toolPanel.add(separator);

		toolPanel.add(Box.createHorizontalStrut(15));
		toolPanel.add(notLabel);
		toolPanel.add(Box.createHorizontalStrut(15));
		separator = new JSeparator(JSeparator.VERTICAL);
		size = new Dimension(separator.getPreferredSize().width,
				separator.getMaximumSize().height);
		separator.setMaximumSize(size);
		toolPanel.add(separator);

		toolPanel.add(Box.createHorizontalStrut(15));
		toolPanel.add(wireLabel);
		toolPanel.add(Box.createHorizontalStrut(15));
		separator = new JSeparator(JSeparator.VERTICAL);
		size = new Dimension(separator.getPreferredSize().width,
				separator.getMaximumSize().height);
		separator.setMaximumSize(size);
		toolPanel.add(separator);

		toolPanel.add(Box.createHorizontalStrut(15));
		toolPanel.add(inputLabel);
		toolPanel.add(Box.createHorizontalStrut(15));
		separator = new JSeparator(JSeparator.VERTICAL);
		size = new Dimension(separator.getPreferredSize().width,
				separator.getMaximumSize().height);
		separator.setMaximumSize(size);
		toolPanel.add(separator);

		toolPanel.add(Box.createHorizontalStrut(15));
		toolPanel.add(outputLabel);
		toolPanel.add(Box.createHorizontalStrut(15));
		separator = new JSeparator(JSeparator.VERTICAL);
		size = new Dimension(separator.getPreferredSize().width,
				separator.getMaximumSize().height);
		separator.setMaximumSize(size);
		toolPanel.add(separator);

		toolPanel.add(Box.createHorizontalStrut(350));

		toolPanel.add(Box.createHorizontalStrut(15));
		toolPanel.add(genAntCircuit, BorderLayout.EAST);
		toolPanel.add(Box.createHorizontalStrut(15));
		separator = new JSeparator(JSeparator.VERTICAL);
		size = new Dimension(separator.getPreferredSize().width,
				separator.getMaximumSize().height);
		separator.setMaximumSize(size);
		toolPanel.add(separator);

		toolPanel.add(Box.createHorizontalStrut(15));
		toolPanel.add(simulateButton, BorderLayout.EAST);
		toolPanel.add(Box.createHorizontalStrut(15));
		separator = new JSeparator(JSeparator.VERTICAL);
		size = new Dimension(separator.getPreferredSize().width,
				separator.getMaximumSize().height);
		separator.setMaximumSize(size);
		toolPanel.add(separator);

		toolPanel.add(Box.createHorizontalStrut(15));
		toolPanel.add(showGraphButton, BorderLayout.EAST);
		toolPanel.add(Box.createHorizontalStrut(15));
		separator = new JSeparator(JSeparator.VERTICAL);
		size = new Dimension(separator.getPreferredSize().width,
				separator.getMaximumSize().height);
		separator.setMaximumSize(size);
		toolPanel.add(separator);

		toolPanel.add(Box.createHorizontalStrut(15));
		toolPanel.add(clearButton, BorderLayout.EAST);
		toolPanel.add(simulateButtons, BorderLayout.CENTER);

		attributePanel = new JPanel(new CardLayout());
		selectedLabel = new JLabel("Circuit : Untitled");

		setCombobox();

		setAttributes();
		setAttrPanels();

		defAttributePanel.setBackground(new Color(83, 83, 83));
		attributePanel.setBackground(new Color(83, 83, 83));
		attributePanel.add(defAttributePanel, "DEFAULT");
		attributePanel.add(inputAttributePanel, "TOOLINPUT");
		attributePanel.add(andAttributePanel, "TOOLAND");
		attributePanel.add(orAttributePanel, "TOOLOR");
		attributePanel.add(notAttributePanel, "TOOLNOT");
		attributePanel.add(wireAttributePanel, "WIRE");

		setAttributePanel("CIRCUIT : UNTITLED", "DEFAULT", -1);

		sidePanel.add(selectedLabel);
		sidePanel.add(attributePanel);

		container.add(toolPanel, BorderLayout.NORTH);
		container.add(sidePanel, BorderLayout.WEST);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}

	public JMenuBar createMenuBar() {

		JMenuBar menuBar;
		JMenu menu, submenu;
		JMenuItem menuItem;
		JRadioButtonMenuItem rbMenuItem;
		JCheckBoxMenuItem cbMenuItem;

		// Create the menu bar.
		menuBar = new JMenuBar();

		// Build the first menu.
		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);
		menuBar.add(menu);

		// a group of JMenuItems
		menuItem = new JMenuItem("New", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
				ActionEvent.ALT_MASK));
		menu.add(menuItem);
		menuItem.addActionListener(this);

		menuItem = new JMenuItem("Save Logic Circuit");
		menuItem.setMnemonic(KeyEvent.VK_D);
		menu.add(menuItem);
		menuItem.addActionListener(this);

		menuItem = new JMenuItem("Exit");
		menuItem.setMnemonic(KeyEvent.VK_D);
		menu.add(menuItem);
		menuItem.addActionListener(this);

		// a group of radio button menu items
		menu.addSeparator();
		ButtonGroup group = new ButtonGroup();

		// Build second menu in the menu bar.
		menu = new JMenu("Edit");
		menu.setMnemonic(KeyEvent.VK_E);
		menuBar.add(menu);
		menuItem.addActionListener(this);

		menuItem = new JMenuItem("Undo");
		menuItem.setMnemonic(KeyEvent.VK_B);
		menu.add(menuItem);
		menuItem.addActionListener(this);

		menu = new JMenu("Simulation");
		menu.setMnemonic(KeyEvent.VK_S);
		menuBar.add(menu);

		/*
		 * menuItem = new JMenuItem("Enter Values");
		 * menuItem.setMnemonic(KeyEvent.VK_E); menu.add(menuItem);
		 * menuItem.addActionListener(this);
		 */

		return menuBar;
	}

	protected static ImageIcon createImageIcon(String path) {
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		System.out.println("bakchodi");
		JMenuItem source = (JMenuItem) (a.getSource());
		if (source.getText().equals("Undo")) {
			AntGUI.undoCaller();
		} else if (source.getText().equals("Enter Values")) {
			AntGUI.simulateCaller();
		} else if (source.getText().equals("Save Logic Circuit"))
			AntGUI.saveCaller();
		else if (source.getText().equals("New"))
			AntGUI.newCaller();

		else if (source.getText().equals("Exit")) {
			if (countExit == 0)
				AntGUI.exitCaller();
			else
				countExit = 0;
		}
	}

	private static void newCaller() {
		// TODO Auto-generated method stub`
		clearClicked=1;
		DisplayCanvas.clear();

	}

	public static void setDisplayPanel(String s) {
		CardLayout cl = (CardLayout) (DisplayPanel.getLayout());
		if (s.equals("canvas")) {
			cl.show(DisplayPanel, "canvas");
		} else if (s.equals("antcanvas")) {
			cl.show(DisplayPanel, "antcanvas");
		}
	}

	static int main_id;

	public static void setAttributePanel(String name, String s, int id) {
		
		selectedLabel.setFont(new Font("Serif", Font.BOLD, 17));
		selectedLabel.setForeground(new Color(255, 255, 255));
		selectedLabel.setText(name);
		selectedLabel.setMaximumSize(new Dimension(250, 30));
		selectedLabel.setMinimumSize(new Dimension(250, 30));
		selectedLabel.setPreferredSize(new Dimension(250, 30));
		System.out.println(id);

		// Components c = DisplayCanvas.component.get(id);
		CardLayout cl = (CardLayout) (attributePanel.getLayout());
		Components comp = null;

		if (id != -1) {
			if (DisplayCanvas.component.get(id).compName == "INPUT") {

				cl.show(attributePanel, "TOOLINPUT");
				comp = DisplayCanvas.component.get(id);
				System.out.println("id for INPUT IS " + id);
				// inputValue=DisplayCanvas.component.get(id).input;
				main_id = id;
				field1.setText(Float.toString(DisplayCanvas.component
						.get(main_id).inputA));
				System.out
						.println("inputA for INPUT IS *** "
								+ Float.toString(DisplayCanvas.component
										.get(main_id).inputA));

			}
			if (DisplayCanvas.component.get(id).compName == "AND") {

				cl.show(attributePanel, "TOOLAND");
				comp = DisplayCanvas.component.get(id);
				main_id = id;
				field2.setText(Float.toString(DisplayCanvas.component
						.get(main_id).pump_a));
				field3.setText(Float.toString(DisplayCanvas.component
						.get(main_id).pump_b));
				field4.setText(Float.toString(DisplayCanvas.component
						.get(main_id).battery));

			} else if (DisplayCanvas.component.get(id).compName == "OR") {

				cl.show(attributePanel, "TOOLOR");
				comp = DisplayCanvas.component.get(id);
				main_id = id;
				field5.setText(Float.toString(DisplayCanvas.component
						.get(main_id).pump_a));
				field6.setText(Float.toString(DisplayCanvas.component
						.get(main_id).pump_b));
				field7.setText(Float.toString(DisplayCanvas.component
						.get(main_id).battery));

			} else if (DisplayCanvas.component.get(id).compName == "NOT") {

				cl.show(attributePanel, "TOOLNOT");
				comp = DisplayCanvas.component.get(id);
				System.out.println("id selected " + id);
				main_id = id;
				field8.setText(Float.toString(DisplayCanvas.component
						.get(main_id).pump_a));
				field9.setText(Float.toString(DisplayCanvas.component
						.get(main_id).pump_b));
				field10.setText(Float.toString(DisplayCanvas.component
						.get(main_id).battery));

			}
		} else if (CompFLAG == NONE) {

			cl.show(attributePanel, "DEFAULT");
		}
	}

	public Components getcComponents(Components comp) {
		return comp;
	}

	public void setCombobox() {
		if (DisplayCanvas.component.size() > 0
				&& ((DisplayCanvas.component.get(main_id).inputA)) > 0) {
		} else
			field1 = new JTextField("0");
		saveButtonInput.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DisplayCanvas.component.get(main_id).inputA = Float
						.parseFloat(field1.getText());
				for (int i = 0; i < DisplayCanvas.connection.size(); i++) {
					if (DisplayCanvas.connection.get(i).wire.p1 == DisplayCanvas.component
							.get(main_id)) {
						System.out.println("ghussa andar part 1 mein");
						if (DisplayCanvas.connection.get(i).wire.offSetY2 == 10
								|| DisplayCanvas.connection.get(i).wire.offSetY1 == 20)
							DisplayCanvas.connection.get(i).wire.p2.inputA = DisplayCanvas.component
									.get(main_id).inputA;
						else if (DisplayCanvas.connection.get(i).wire.offSetY2 == 30)
							DisplayCanvas.connection.get(i).wire.p2.inputB = DisplayCanvas.component
									.get(main_id).inputA;
					} else if (DisplayCanvas.connection.get(i).wire.p2 == DisplayCanvas.component
							.get(main_id)) {
						System.out.println("ghussa andar part 2 mein");
						if (DisplayCanvas.connection.get(i).wire.offSetY1 == 10
								|| DisplayCanvas.connection.get(i).wire.offSetY1 == 20)
							DisplayCanvas.connection.get(i).wire.p2.inputA = DisplayCanvas.component
									.get(main_id).inputA;
						else if (DisplayCanvas.connection.get(i).wire.offSetY1 == 30)
							DisplayCanvas.connection.get(i).wire.p2.inputB = DisplayCanvas.component
									.get(main_id).inputA;
					}
				}
				System.out.println();

			}
		});

		if (DisplayCanvas.component.size() > 0
				&& ((DisplayCanvas.component.get(main_id).pump_a)) > 0) {
		} else
			field2 = new JTextField("0");
		if (DisplayCanvas.component.size() > 0
				&& ((DisplayCanvas.component.get(main_id).pump_b)) > 0) {
		} else
			field3 = new JTextField("0");
		if (DisplayCanvas.component.size() > 0
				&& ((DisplayCanvas.component.get(main_id).battery)) > 0) {
		} else
			field4 = new JTextField("0");

		saveButtonAnd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DisplayCanvas.component.get(main_id).pump_a = Float
						.parseFloat(field2.getText());
				DisplayCanvas.component.get(main_id).pump_b = Float
						.parseFloat(field3.getText());
				DisplayCanvas.component.get(main_id).battery = Float
						.parseFloat(field4.getText());
			}
		});

		if (DisplayCanvas.component.size() > 0
				&& ((DisplayCanvas.component.get(main_id).pump_a)) > 0) {
		} else
			field5 = new JTextField("0");
		if (DisplayCanvas.component.size() > 0
				&& ((DisplayCanvas.component.get(main_id).pump_b)) > 0) {
		} else
			field6 = new JTextField("0");
		if (DisplayCanvas.component.size() > 0
				&& ((DisplayCanvas.component.get(main_id).battery)) > 0) {
		} else
			field7 = new JTextField("0");

		saveButtonOr.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DisplayCanvas.component.get(main_id).pump_a = Float
						.parseFloat(field5.getText());
				DisplayCanvas.component.get(main_id).pump_b = Float
						.parseFloat(field6.getText());
				DisplayCanvas.component.get(main_id).battery = Float
						.parseFloat(field7.getText());
			}
		});

		if (DisplayCanvas.component.size() > 0
				&& ((DisplayCanvas.component.get(main_id).pump_a)) > 0) {
		} else
			field8 = new JTextField("0");
		if (DisplayCanvas.component.size() > 0
				&& ((DisplayCanvas.component.get(main_id).pump_b)) > 0) {
		} else
			field9 = new JTextField("0");
		if (DisplayCanvas.component.size() > 0
				&& ((DisplayCanvas.component.get(main_id).battery)) > 0) {
		} else
			field10 = new JTextField("0");

		saveButtonNot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DisplayCanvas.component.get(main_id).pump_a = Float
						.parseFloat(field8.getText());
				DisplayCanvas.component.get(main_id).pump_b = Float
						.parseFloat(field9.getText());
				DisplayCanvas.component.get(main_id).battery = Float
						.parseFloat(field10.getText());
			}
		});
	}

	public void setAttributes() {

		attr1 = new JLabel("input");
		attr1.setForeground(new Color(255, 255, 255));

		attr2 = new JLabel("pumpA");
		attr2.setForeground(new Color(255, 255, 255));

		attr3 = new JLabel("pumpB");
		attr3.setForeground(new Color(255, 255, 255));

		attr4 = new JLabel("battery");
		attr4.setForeground(new Color(255, 255, 255));

		attr5 = new JLabel("pumpA");
		attr5.setForeground(new Color(255, 255, 255));

		attr6 = new JLabel("pumpB");
		attr6.setForeground(new Color(255, 255, 255));

		attr7 = new JLabel("Battery");
		attr7.setForeground(new Color(255, 255, 255));

		attr8 = new JLabel("pumpA");
		attr8.setForeground(new Color(255, 255, 255));

		attr9 = new JLabel("pumpB");
		attr9.setForeground(new Color(255, 255, 255));

		attr10 = new JLabel("battery");
		attr10.setForeground(new Color(255, 255, 255));

		field1.setText("0");
		field2.setText("0");
		field3.setText("0");
		field4.setText("0");
		field5.setText("0");
		field6.setText("0");
		field7.setText("0");
		field8.setText("0");
		field9.setText("0");
		field10.setText("0");

	}

	public void setAttrPanels() {

		attributePanel.setBackground(new Color(83, 83, 83));
		JPanel p1 = new JPanel();
		p1.setLayout(new BoxLayout(p1, BoxLayout.LINE_AXIS));
		p1.setBackground(new Color(83, 83, 83));
		inputAttributePanel = new JPanel(new GridLayout(5, 1));

		inputAttributePanel.add(attr1);
		inputAttributePanel.add(field1);
		inputAttributePanel.add(new JLabel());
		inputAttributePanel.add(new JLabel());
		inputAttributePanel.add(new JLabel());
		// p1.add(Box.createHorizontalStrut());
		p1.add(saveButtonInput);
		inputAttributePanel.add(p1);

		inputAttributePanel.setBackground(new Color(83, 83, 83));
		// inputAttributePanel.setBorder(BorderFactory.createEmptyBorder(5, 5,
		// 5, 5));

		JPanel p2 = new JPanel();
		p2.setLayout(new BoxLayout(p2, BoxLayout.LINE_AXIS));
		p2.setBackground(new Color(83, 83, 83));

		andAttributePanel = new JPanel(new GridLayout(5, 1));
		andAttributePanel.add(attr2);
		andAttributePanel.add(field2);
		andAttributePanel.add(attr3);
		andAttributePanel.add(field3);
		andAttributePanel.add(attr4);
		andAttributePanel.add(field4);

		p2.add(Box.createHorizontalStrut(90));
		p2.add(saveButtonAnd);
		andAttributePanel.add(p2);

		andAttributePanel.setBackground(new Color(83, 83, 83));
		andAttributePanel
				.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		toolorAttributePanel = new JPanel();
		orAttributePanel = new JPanel(new GridLayout(5, 1));
		JPanel p3 = new JPanel();
		p3.setLayout(new BoxLayout(p3, BoxLayout.LINE_AXIS));
		p3.setBackground(new Color(83, 83, 83));
		p3.add(Box.createHorizontalStrut(90));

		orAttributePanel.add(attr5);
		orAttributePanel.add(field5);
		orAttributePanel.add(attr6);
		orAttributePanel.add(field6);
		orAttributePanel.add(attr7);
		orAttributePanel.add(field7);
		p3.add(saveButtonOr);
		orAttributePanel.add(p3);

		orAttributePanel.setBackground(new Color(83, 83, 83));
		orAttributePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		toolnotAttributePanel = new JPanel();
		notAttributePanel = new JPanel(new GridLayout(4, 1));
		JPanel p4 = new JPanel();
		p4.setLayout(new BoxLayout(p4, BoxLayout.LINE_AXIS));
		p4.setBackground(new Color(83, 83, 83));
		p4.add(Box.createHorizontalStrut(90));

		notAttributePanel.add(attr8);
		notAttributePanel.add(field8);
		notAttributePanel.add(attr9);
		notAttributePanel.add(field9);
		notAttributePanel.add(attr10);
		notAttributePanel.add(field10);
		p4.add(saveButtonNot);
		notAttributePanel.add(p4);
		notAttributePanel.setBackground(new Color(83, 83, 83));
		notAttributePanel
				.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		wireAttributePanel = new JPanel(new GridLayout(2, 2));

		defAttributePanel = new JPanel();
	}

	public static void undoCaller() {

		canvas.undo();
	}

	public static void exitCaller() {
		if (countExit == 0) {
			int option = JOptionPane.showConfirmDialog(null,
					"Do you want to save file before exiting");
			if (option == 0) {
				try {
					ProjectName = JOptionPane
							.showInputDialog("Enter the name of the file");
					BufferedImage im = new BufferedImage(
							DisplayPanel.getWidth(), DisplayPanel.getHeight(),
							BufferedImage.TYPE_INT_ARGB);
					DisplayPanel.paint(im.getGraphics());

					if (ProjectName == null) {

					} else if ((ProjectName != null && ("".equals(ProjectName))))
						JOptionPane.showMessageDialog(null, "no name entered");
					else {
						File outputfile = new File(ProjectName + ".png");
						ImageIO.write(im, "png", outputfile);
						System.exit(0);
					}
				} catch (IOException e) {
				}
			} else if (option == 1)
				System.exit(0);
			else if (option == 2 || option == -1) {
				countExit += 1;
			}
		}
	}

	public static void saveCaller() {
		try {
			ProjectName = JOptionPane
					.showInputDialog("Enter the name of the file");

			BufferedImage im = new BufferedImage(DisplayPanel.getWidth(),
					DisplayPanel.getHeight(), BufferedImage.TYPE_INT_ARGB);
			DisplayPanel.paint(im.getGraphics());
			// ImageIO.write(im, "PNG", new File("shot.png"));

			if (ProjectName == null) {
			} else if ((ProjectName != null && ("".equals(ProjectName))))
				JOptionPane.showMessageDialog(null, "no name entered");
			else {

				File outputfile = new File("./"+ProjectName + ".png");
				ImageIO.write(im, "png", outputfile);
			}
		} catch (IOException e) {
		}
	}

	public static void simulateCaller() {

		JFrame frame = new JFrame("Simulate");

		// Create and set up the content pane.
		SimulationBox newContentPane = new SimulationBox(frame);
		newContentPane.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPane);

		frame.pack();
		frame.setVisible(true);
	}

	public static void showGraphCaller() {

		if (SimulationBox.simulationRun == true) {

			GraphSimulator demo = new GraphSimulator("ant");

			demo.pack();
			RefineryUtilities.centerFrameOnScreen(demo);
			demo.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null,
					"Please simulate the circuit first");
		}
	}

	public static void main(String arg[]) {

		try {
			UIManager.setLookAndFeel(new SyntheticaClassyLookAndFeel());
		} catch (Exception e) {
			e.printStackTrace();
		}

		new AntGUI();

	}

	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		System.out.println("ollalaalaa");
	}

}