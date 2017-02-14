package com.antcircuit;

import java.awt.BasicStroke;
import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class DisplayCanvas extends JPanel implements MouseListener {

	public static final int OFF = 0;
	public static final int ON = 1;
	public static int idAssigned = 0;

	int hoverX, hoverY;
	int x, y, x2, y2;
	public static Graphics2D g;
	static BufferedImage bi;

	static BufferedImage bottom_left;
	static BufferedImage bottom_right;
	static BufferedImage top_left;
	static BufferedImage top_right;
	static BufferedImage vert_wire;

	public static ArrayList<Components> component = new ArrayList<Components>();
	public int clearScreen = ON;

	public static ArrayList<BufferedImage> bufferedImage = new ArrayList<BufferedImage>();
	public static ArrayList<Integer> xCoordinate = new ArrayList<Integer>();
	public static ArrayList<Integer> yCoordinate = new ArrayList<Integer>();

	public static ArrayList<WireComponent> wires = new ArrayList<WireComponent>();
	public static ArrayList<Connection> connection = new ArrayList<Connection>();
	public static ArrayList<WireComponent> wiresAttached = new ArrayList<WireComponent>();

	WireComponent wirecomponent;

	public static int wireMouseDragged = 0;
	public static int componentCount = 0;
	public static int connectionId = 0;
	public static int countWires = 0;
	public static int id = -1;
	public static int dragged = 0;
	public int startX, startY, newX, newY;
	public int point = 0;
	public static int selectionId = -1;
	public static String selectComponent = "off";

	public static ArrayList<String> lastUsed = new ArrayList<String>();

	public DisplayCanvas() {

		setBackground(Color.white);
		setSize(450, 400);
		addMouseListener(this);
		addMouseMotionListener(new MouseMotionHandler());

		// System.out.println("in displaycanvas()" + bufferedImage.size());
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		g2D.setStroke(new BasicStroke(3));
		if (AntGUI.clearClicked == 1) {
			AntGUI.clearClicked = 0;
			component.clear();
			idAssigned = 0;
			wires.clear();
			countWires = 0;
			g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
		} else {
			{
				for (WireComponent wire : wires) {
					wire.makeWire(g2D);
					repaint();
				}
			}
			if (dragged == 1) {
				if (component.size() > 0)
					for (int i = 0; i < id; i++)
						g2D.drawImage(component.get(i).img,
								(int) component.get(i).topLeft.getX(),
								(int) component.get(i).topLeft.getY(), null);

				for (int i = id + 1; i < component.size(); i++)
					g2D.drawImage(component.get(i).img,
							(int) component.get(i).topLeft.getX(),
							(int) component.get(i).topLeft.getY(), null);
				if (!(id >= 0)) {
				} else {
					g2D.drawImage(component.get(id).img, x, y, null);
					component.get(id).topLeft = new Point(x, y);
					for (WireComponent wire : wires) {
						wire.makeWire(g2D);
					}
				}
				repaint();
			} else {
				for (int i = 0; i < idAssigned; i++) {
					g2D.drawImage(component.get(i).img,
							(int) component.get(i).topLeft.getX(),
							(int) component.get(i).topLeft.getY(), null);
				}
			}
		}

		repaint();
	}

	class MouseMotionHandler extends MouseAdapter {
		public void mouseDragged(MouseEvent e) {
			x = e.getX();
			y = e.getY();

			if (AntGUI.wireFLAG == AntGUI.COMP_WIRE) {
				newX = getX() + (e.getX() - startX);
				newY = getY() + (e.getY() - startY);
				/*
				 * System.out .println("offsets in dragging are" +
				 * wirecomponent.offSetX1 + " " + wirecomponent.offSetY1);
				 */
				if (wireMouseDragged == 1) {
					wirecomponent.xCoord = e.getX();
					wirecomponent.yCoord = e.getY();
					wires.set(countWires, wirecomponent);
				}
			} else {
				dragged = 1;
			}
			repaint();
		}
		/*
		 * public void mouseMoved(MouseEvent e) { //Graphics2D g2D =
		 * (Graphics2D) g; System.out.println("hulalalal------"+e.getX());
		 * hoverX=e.getX(); hoverY=e.getY();
		 * 
		 * }
		 */
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		x = e.getX();
		y = e.getY();
		// System.out.println(x + " " + getX());
		int i, j, k;
		for (k = 0; k < component.size(); k++) {
			for (i = 0; i < 100; i++) {
				if (x == component.get(k).topLeft.getX() + i) {
					for (j = 0; j < 100; j++)
						if (y == component.get(k).topLeft.getY() + j) {
							selectionId = k;
							AntGUI.simulationComponentSelected = component
									.get(k);
							selectComponent = "ON";
							break;
						} else {
							selectionId = -1;
							selectComponent = "OFF";
						}
					break;
				}
			}
		}
		if (selectComponent == "ON") {

			AntGUI.wireFLAG = AntGUI.NONE;
			AntGUI.CompFLAG = AntGUI.NONE;

			AntGUI.setAttributePanel(
					"Component Selected : "
							+ component.get(selectionId).compName,
					component.get(selectionId).compName, selectionId);

			/*
			 * System.out.println("selection is " +
			 * component.get(selectionId).compName +
			 * component.get(selectionId).id);
			 */} else {
			if (AntGUI.CompFLAG == AntGUI.COMP_AND) {
				clearScreen = OFF;
				Components c = new AndGate(x, y);
				ToolLabelMouseListeners.andClicked();
				c.img = bi;
				c.id = idAssigned++;
				component.add(c);
				lastUsed.add("gate");
				for (i = 0; i < component.size(); i++)
					System.out.println("values are "
							+ component.get(i).topLeft.getX());
				// AntGUI.setAttributePanel("selection : "+
				// component.get(selectionId).compName,component.get(selectionId).compName,
				// selectionId);
				AntGUI.setAttributePanel(
						"Component Selected : "
								+ component.get(component.size() - 1).compName,
						component.get(component.size() - 1).compName,
						component.size() - 1);
				System.out.println("selection is "
						+ component.get(component.size() - 1).compName
						+ component.get(component.size() - 1).id);
			}

			if (AntGUI.CompFLAG == AntGUI.COMP_OR) {
				clearScreen = OFF;
				Components c = new OrGate(x, y);
				ToolLabelMouseListeners.orClicked();
				c.img = bi;
				c.id = idAssigned++;
				component.add(c);
				lastUsed.add("gate");
				AntGUI.setAttributePanel(
						"Component Selected : "
								+ component.get(component.size() - 1).compName,
						component.get(component.size() - 1).compName,
						component.size() - 1);
				System.out.println("selection is "
						+ component.get(component.size() - 1).compName
						+ component.get(component.size() - 1).id);
			}
			if (AntGUI.CompFLAG == AntGUI.COMP_NOT) {
				clearScreen = OFF;
				Components c = new NotGate(x, y);
				ToolLabelMouseListeners.notClicked();
				c.img = bi;
				c.id = idAssigned++;
				component.add(c);
				lastUsed.add("gate");
				AntGUI.setAttributePanel(
						"Component Selected : "
								+ component.get(component.size() - 1).compName,
						component.get(component.size() - 1).compName,
						component.size() - 1);
				System.out.println("selection is "
						+ component.get(component.size() - 1).compName
						+ component.get(component.size() - 1).id);
			}
			if (AntGUI.CompFLAG == AntGUI.COMP_INPUT) {
				clearScreen = OFF;
				Components c = new Input(x, y);
				ToolLabelMouseListeners.inputClicked();
				c.img = bi;
				c.id = idAssigned++;
				component.add(c);
				lastUsed.add("gate");
				AntGUI.setAttributePanel(
						"Component Selected : "
								+ component.get(component.size() - 1).compName,
						component.get(component.size() - 1).compName, c.id);
				System.out.println("selection is "
						+ component.get(component.size() - 1).compName
						+ component.get(component.size() - 1).id);
			}

			if (AntGUI.CompFLAG == AntGUI.COMP_OUTPUT) {
				clearScreen = OFF;
				Components c = new Output(x, y);
				ToolLabelMouseListeners.outputClicked();
				c.img = bi;
				c.id = idAssigned++;
				component.add(c);
				lastUsed.add("gate");
				AntGUI.setAttributePanel(
						"Component Selected : "
								+ component.get(component.size() - 1).compName,
						component.get(component.size() - 1).compName,
						component.size() - 1);
				System.out.println("selection is "
						+ component.get(component.size() - 1).compName
						+ component.get(component.size() - 1).id);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		wirecomponent = null;
		id = -1;
		x = e.getX();
		y = e.getY();
		int i = 0, j = 0, k = 0, flag = 0;
		point = 0;
		for (k = 0; k < component.size(); k++) {
			for (i = 0; i < 100; i++) {
				if (x == component.get(k).topLeft.getX() + i) {
					for (j = 0; j < 100; j++)
						if (y == component.get(k).topLeft.getY() + j) {
							flag = 1;
							break;
						}
					break;
				}
			}
		}
		if (flag == 0) {
			AntGUI.wireFLAG = AntGUI.NONE;
		}
		if (AntGUI.wireFLAG == AntGUI.COMP_WIRE) {
			Connection conn = new Connection();
			for (k = 0; k < component.size(); k++) {
				for (i = 0; i < 100; i++) {
					if (x == component.get(k).topLeft.getX() + i) {
						for (j = 0; j < 100; j++)
							if (y == component.get(k).topLeft.getY() + j) {
								id = k;
								break;
							}
						break;
					}
				}
			}

			wirecomponent = new WireComponent(component.get(id),
					component.get(id));
			wirecomponent.offSetX1 = (int) (e.getX() - component.get(id).topLeft
					.getX());
			wirecomponent.offSetY1 = (int) (e.getY() - component.get(id).topLeft
					.getY());
			conn.connection_id = connectionId;
			conn.start = component.get(id);

			conn.status = "input";
			conn.wire = wirecomponent;
			System.out.println("offsets are" + wirecomponent.offSetX1 + " "
					+ wirecomponent.offSetY1);
			if ((wirecomponent.offSetX1 >= -5 && wirecomponent.offSetX1 <= 5
					&& wirecomponent.offSetY1 % 10 >= 0 && wirecomponent.offSetY1 % 10 <= 5)
					|| (wirecomponent.offSetX1 <= 45
							&& wirecomponent.offSetX1 >= 35
							&& wirecomponent.offSetY1 <= 25 && wirecomponent.offSetY1 >= 15)
					|| (wirecomponent.offSetX1 >= 15)
					&& (wirecomponent.offSetX1 <= 25)) {
				conn.connection_id = connectionId;
				conn.start = component.get(id);
				conn.status = "input";
				conn.wire = wirecomponent;
				wireMouseDragged = 1;
				conn.wire = wirecomponent;
				// connection.add(conn);
				wires.add(wirecomponent);
				// connection.add(conn);
				if ((wirecomponent.offSetX1 >= -5
						&& wirecomponent.offSetX1 <= 5
						&& wirecomponent.offSetY1 % 10 >= 0 && wirecomponent.offSetY1 % 10 <= 5)) {

					wirecomponent.offSetX1 = 0;

					if (wirecomponent.offSetY1 >= 5
							&& wirecomponent.offSetY1 < 15) {
						wirecomponent.offSetY1 = 10;
						conn.Input = component.get(id);
						System.out
								.println("aaya input gate par displaycanvas mein on output*** "
										+ conn.Output.compName
										+ " "
										+ conn.wire.offSetY1);
					}

					if (wirecomponent.offSetY1 >= 25
							&& wirecomponent.offSetY1 < 35) {
						wirecomponent.offSetY1 = 30;
						conn.Input = component.get(id);
					}

				} else if (wirecomponent.offSetY1 <= 25
						&& wirecomponent.offSetY1 >= 15) {
					wirecomponent.offSetY1 = 20;

					if (wirecomponent.offSetX1 >= -5
							&& wirecomponent.offSetX1 <= 5) {
						wirecomponent.offSetX1 = 0;
						conn.Input = component.get(id);
					}

					else if (wirecomponent.offSetX1 <= 45
							&& wirecomponent.offSetX1 >= 35) {
						wirecomponent.offSetX1 = 40;
						conn.Output = component.get(id);
						System.out
								.println("aaya input gate par displaycanvas mein on output*** "
										+ conn.Output.compName);
					}

				}
				connection.add(conn);
				/*
				 * else if(wirecomponent.offSetX1 <= 25 &&
				 * wirecomponent.offSetX1 >= 15) {
				 * System.out.println("**********reaching mux");
				 * wirecomponent.offSetX1=20; wirecomponent.offSetY1=0; }
				 */
			} else
				wireMouseDragged = 2;
		} else {
			if (component.size() > 0)
				for (k = 0; k < component.size(); k++) {
					for (i = 0; i < 100; i++) {
						if (x == component.get(k).topLeft.getX() + i) {
							for (j = 0; j < 100; j++)
								if (y == component.get(k).topLeft.getY() + j) {
									id = k;
									break;
								}
							break;
						}
					}
				}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

		if (AntGUI.wireFLAG == AntGUI.COMP_WIRE) {
			x2 = e.getX();
			y2 = e.getY();
			int i = 0, j = 0, k = 0;
			System.out.println("new connection made");
			Connection conn = connection.get(connection.size() - 1);

			if (component.size() > 0)
				for (k = 0; k < component.size(); k++) {
					for (i = 0; i < 100; i++) {
						if (x2 == component.get(k).topLeft.getX() + i) {
							for (j = 0; j < 100; j++)
								if (y2 == component.get(k).topLeft.getY() + j) {
									id = k;
									break;
								}
							break;
						}
					}
				}
			wirecomponent.p2 = component.get(id);
			wirecomponent.offSetX2 = (int) (e.getX() - component.get(id).topLeft
					.getX());
			wirecomponent.offSetY2 = (int) (e.getY() - component.get(id).topLeft
					.getY());
			// conn.start = component.get(id);
			// connection.get(connection.size()-1).
			// conn.status = "output";
			// conn.wire = wirecomponent;
			// conn.connection_id = connectionId++;
			// connection.add(conn);
			lastUsed.add("wire");
			if (wireMouseDragged == 1) {
				wires.set(countWires, wirecomponent);
				countWires++;
				wireMouseDragged = 0;
				// connection.add(conn);
				System.out
						.println("offsets on release are"
								+ wirecomponent.offSetX2 + " "
								+ wirecomponent.offSetY2);
				if ((wirecomponent.offSetX2 >= -5
						&& wirecomponent.offSetX2 <= 5
						&& wirecomponent.offSetY2 % 10 >= 0 && wirecomponent.offSetY2 % 10 <= 5)) {
					wirecomponent.offSetX2 = 0;

					if (wirecomponent.offSetY2 >= 5
							&& wirecomponent.offSetY2 < 15) {
						wirecomponent.offSetY2 = 10;
						conn.Input = component.get(id);
						if (conn.Output.compName == "INPUT")
							component.get(id).inputA = conn.Output.inputA;
					}

					if (wirecomponent.offSetY2 >= 25
							&& wirecomponent.offSetY2 < 35) {
						wirecomponent.offSetY2 = 30;
						conn.Input = component.get(id);
						if (conn.Output.compName == "INPUT")
							component.get(id).inputB = conn.Output.inputA;
					}

					if (wirecomponent.offSetY2 >= 15
							&& wirecomponent.offSetY2 < 25) {
						wirecomponent.offSetY2 = 20;

						conn.Input = component.get(id);
						if (conn.Output.compName == "INPUT")
							component.get(id).inputA = conn.Output.inputA;
						// System.out.println("aaya input gate par displaycanvas mein on output***"+
						// );
					}

				} else if (wirecomponent.offSetX2 <= 45
						&& wirecomponent.offSetX2 >= 35
						&& wirecomponent.offSetY2 <= 25
						&& wirecomponent.offSetY2 >= 15) {
					wirecomponent.offSetX2 = 40;
					wirecomponent.offSetY2 = 20;
					conn.Output = component.get(id);
				}
				/*
				 * else
				 * if(wirecomponent.offSetX2>=15&&wirecomponent.offSetX2<=25) {
				 * wirecomponent.offSetX2 = 20; wirecomponent.offSetY2 = 0; }
				 */
				if (((wirecomponent.offSetX2 < -5 || wirecomponent.offSetX2 > 5) || (wirecomponent.offSetY2 % 10 < 0 || wirecomponent.offSetY2 % 10 > 5))
						&& ((wirecomponent.offSetX2 > 45 || wirecomponent.offSetX2 < 35) || (wirecomponent.offSetY2 > 25 || wirecomponent.offSetY2 < 15))) {
					wires.remove(--countWires);
					connection.remove(connection.size() - 1);
					connectionId--;
				}
				System.out.println("wirearray size is" + wires.size());
			}
		} else {
			dragged = 0;
			wiresAttached.clear();
		}
	}

	public static void clear() {
		System.out.println("connection###########" + connection.size());
		if (connection.size() != 0)
			for (int i = 0; i < connection.size(); i++)
				System.out.println("connections are between"
						+ connection.get(i).start.compName + " "
						+ connection.get(i).wire.p2.compName);
		new DisplayCanvas();
		System.out.println("clear reached");
		if (component.size() != 0)
			for (int i = 0; i < component.size(); i++)
				System.out.println(component.get(i).compName);
		if (connection.size() != 0) {
			connection.clear();
			idAssigned = 0;
		}
		if (component.size() != 0) {
			component.clear();
			idAssigned = 0;
		}
	}

	public static Point2D.Double getIntersectionPoint(int x1, int x2, int x3,
			int x4, int y1, int y2, int y3, int y4) {

		int px = x1, py = y1, rx = x2 - x1, ry = y2 - y1;
		int qx = x3, qy = y3, sx = x4 - x3, sy = y4 - y3;

		int det = sx * ry - sy * rx;
		if (det == 0) {
			return null;
		} else {
			int z = (sx * (qy - py) + sy * (px - qx)) / det;
			// intersection at end point!
			return new Point2D.Double((int) (px + z * rx), (int) (py + z * ry));
		}
	}

	public void undo() {
		// TODO Auto-generated method stub
		for (int i = 0; i < lastUsed.size(); i++) {
			System.out.println(lastUsed.get(i));
		}
		if (idAssigned != 0) {
			if (lastUsed.get(lastUsed.size() - 1).equals("gate")) {
				component.remove(component.size() - 1);
				idAssigned--;
				lastUsed.remove(lastUsed.size() - 1);
			} else if (lastUsed.get(lastUsed.size() - 1).equals("wire")) {
				wires.remove(wires.size() - 1);
				countWires--;
				lastUsed.remove(lastUsed.size() - 1);
			}
		}
	}
}