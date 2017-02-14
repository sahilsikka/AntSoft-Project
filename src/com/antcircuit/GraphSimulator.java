package com.antcircuit;

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * A simple demonstration application showing how to create a line chart using
 * data from an {@link XYDataset}.
 * 
 */
public class GraphSimulator extends JFrame implements WindowListener {

	/**
	 * Creates a new demo.
	 * 
	 * @param title
	 *            the frame title.
	 */
	public GraphSimulator(final String title)
	// TODO Auto-generated constructor stub
	{

		super(title);

		final XYDataset dataset = createDataset();
		final JFreeChart chart = createChart(dataset);
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		setContentPane(chartPanel);

	}

	/**
	 * Creates a sample dataset.
	 * 
	 * @return a sample dataset.
	 */
	private XYDataset createDataset() {
		NotConcentration not = null;
		AndConcentration and = null;
		OrConcentration or = null;

		XYSeries series1 = null, series2 = null, series3 = null, series4 = null, series5 = null, series6 = null, series7 = null, series8 = null, series1a = null, series2a = null, series3a = null, series4a = null, series5a = null, series6a = null, series7a = null, series8a = null, series1b = null, series2b = null, series3b = null, series4b = null, series5b = null, series6b = null, series7b = null, series8b = null, series1c = null, series2c = null, series3c = null, series4c = null, series5c = null, series6c = null, series7c = null, series8c = null, series1aa = null, series2aa = null, series3aa = null, series4aa = null, series5aa = null, series6aa = null, series7aa = null, series8aa = null, series1ba = null, series2ba = null, series3ba = null, series4ba = null, series5ba = null, series6ba = null, series7ba = null, series8ba = null;

		if (AntGUI.simulationComponentSelected.compName == "NOT") {
			not = (NotConcentration) AntGUI.simulationComponentSelected.gate;
			series1 = new XYSeries("First");

			for (int i = 0; i < not.loc[0].phconc.size() - 1; i++) {
				series1.add(i, (float) not.loc[0].phconc.get(i));
			}

			series2 = new XYSeries("Second");

			for (int i = 0; i < not.loc[1].phconc.size() - 1; i++) {
				series2.add(i, (float) not.loc[1].phconc.get(i));
			}
			series3 = new XYSeries("Third");

			for (int i = 0; i < not.loc[2].phconc.size() - 1; i++) {
				series3.add(i, (float) not.loc[2].phconc.get(i));
			}
			series4 = new XYSeries("Fourth");

			for (int i = 0; i < not.loc[3].phconc.size() - 1; i++) {
				series4.add(i, (float) not.loc[3].phconc.get(i));
			}
			series5 = new XYSeries("Fifth");

			for (int i = 0; i < not.loc[4].phconc.size() - 1; i++) {
				series5.add(i, (float) not.loc[4].phconc.get(i));
			}
			series6 = new XYSeries("Sixth");

			for (int i = 0; i < not.loc[5].phconc.size() - 1; i++) {
				series6.add(i, (float) not.loc[5].phconc.get(i));
			}
			series7 = new XYSeries("Seventh");

			for (int i = 0; i < not.loc[6].phconc.size() - 1; i++) {
				series7.add(i, (float) not.loc[6].phconc.get(i));
			}
			series8 = new XYSeries("Eighth");

			for (int i = 0; i < not.loc[7].phconc.size() - 1; i++) {
				series8.add(i, (float) not.loc[7].phconc.get(i));
			}
		}
		if (AntGUI.simulationComponentSelected.compName == "AND") {
			and = (AndConcentration) AntGUI.simulationComponentSelected.gate;
			series1a = new XYSeries("1");

			for (int i = 0; i < and.not1.loc[0].phconc.size() - 1; i++) {
			
				series1a.add(i, (float) and.not1.loc[0].phconc.get(i));
			}

			series2a = new XYSeries("2");

			for (int i = 0; i < and.not1.loc[1].phconc.size() - 1; i++) {
				series2a.add(i, (float) and.not1.loc[1].phconc.get(i));
			}
			series3a = new XYSeries("3");

			for (int i = 0; i < and.not1.loc[2].phconc.size() - 1; i++) {
				series3a.add(i, (float) and.not1.loc[2].phconc.get(i));
			}
			series4a = new XYSeries("4");

			for (int i = 0; i < and.not1.loc[3].phconc.size() - 1; i++) {
				series4a.add(i, (float) and.not1.loc[3].phconc.get(i));
			}
			series5a = new XYSeries("5");

			for (int i = 0; i < and.not1.loc[4].phconc.size() - 1; i++) {
				series5a.add(i, (float) and.not1.loc[4].phconc.get(i));
			}

			series6a = new XYSeries("6");

			for (int i = 0; i < and.not1.loc[5].phconc.size() - 1; i++) {
				series6a.add(i, (float) and.not1.loc[5].phconc.get(i));
			}

			series7a = new XYSeries("7");

			for (int i = 0; i < and.not1.loc[6].phconc.size() - 1; i++) {
				series7a.add(i, (float) and.not1.loc[6].phconc.get(i));
			}

			series8a = new XYSeries("8");

			for (int i = 0; i < and.not1.loc[7].phconc.size() - 1; i++) {
				series8a.add(i, (float) and.not1.loc[7].phconc.get(i));
			}

			series1b = new XYSeries("9");

			for (int i = 0; i < and.not2.loc[0].phconc.size() - 1; i++) {
				series1b.add(i, (float) and.not2.loc[0].phconc.get(i));
			}

			series2b = new XYSeries("10");

			for (int i = 0; i < and.not2.loc[1].phconc.size() - 1; i++) {
				series2b.add(i, (float) and.not2.loc[1].phconc.get(i));
			}
			series3b = new XYSeries("11");

			for (int i = 0; i < and.not2.loc[2].phconc.size() - 1; i++) {
				series3b.add(i, (float) and.not2.loc[2].phconc.get(i));
			}
			series4b = new XYSeries("12");

			for (int i = 0; i < and.not2.loc[3].phconc.size() - 1; i++) {
				series4b.add(i, (float) and.not2.loc[3].phconc.get(i));
			}
			series5b = new XYSeries("13");

			for (int i = 0; i < and.not2.loc[4].phconc.size() - 1; i++) {
				series5b.add(i, (float) and.not2.loc[4].phconc.get(i));
			}
			series6b = new XYSeries("14");

			for (int i = 0; i < and.not2.loc[5].phconc.size() - 1; i++) {
				series6b.add(i, (float) and.not2.loc[5].phconc.get(i));
			}
			series7b = new XYSeries("15");

			for (int i = 0; i < and.not2.loc[6].phconc.size() - 1; i++) {
				series7b.add(i, (float) and.not2.loc[6].phconc.get(i));
			}
			series8b = new XYSeries("16");

			for (int i = 0; i < and.not2.loc[7].phconc.size() - 1; i++) {
				series8b.add(i, (float) and.not2.loc[7].phconc.get(i));
			}

			series1c = new XYSeries("17");

			for (int i = 0; i < and.not3.loc[0].phconc.size() - 1; i++) {
				series1c.add(i, (float) and.not3.loc[0].phconc.get(i));
			}

			series2c = new XYSeries("18");

			for (int i = 0; i < and.not3.loc[1].phconc.size() - 1; i++) {
				series2c.add(i, (float) and.not3.loc[1].phconc.get(i));
			}
			series3c = new XYSeries("19");

			for (int i = 0; i < and.not3.loc[2].phconc.size() - 1; i++) {
				series3c.add(i, (float) and.not3.loc[2].phconc.get(i));
			}
			series4c = new XYSeries("20");

			for (int i = 0; i < and.not3.loc[3].phconc.size() - 1; i++) {
				series4c.add(i, (float) and.not3.loc[3].phconc.get(i));
			}
			series5c = new XYSeries("21");

			for (int i = 0; i < and.not3.loc[4].phconc.size() - 1; i++) {
				series5c.add(i, (float) and.not3.loc[4].phconc.get(i));
			}

			series6c = new XYSeries("22");

			for (int i = 0; i < and.not3.loc[5].phconc.size() - 1; i++) {
				series6c.add(i, (float) and.not3.loc[5].phconc.get(i));
			}

			series7c = new XYSeries("23");

			for (int i = 0; i < and.not3.loc[6].phconc.size() - 1; i++) {
				series7c.add(i, (float) and.not3.loc[6].phconc.get(i));
			}

			series8c = new XYSeries("24");

			for (int i = 0; i < and.not3.loc[7].phconc.size() - 1; i++) {
				series8c.add(i, (float) and.not3.loc[7].phconc.get(i));
			}

		} else if (AntGUI.simulationComponentSelected.compName == "OR") {
			or = (OrConcentration) AntGUI.simulationComponentSelected.gate;
			series1aa = new XYSeries("1");

			for (int i = 0; i < or.not1.loc[0].phconc.size() - 1; i++) {
				series1aa.add(i, (float) or.not1.loc[0].phconc.get(i));
			}

			series2aa = new XYSeries("2");

			for (int i = 0; i < or.not1.loc[1].phconc.size() - 1; i++) {
				series2aa.add(i, (float) or.not1.loc[1].phconc.get(i));
			}
			series3aa = new XYSeries("3");

			for (int i = 0; i < or.not1.loc[2].phconc.size() - 1; i++) {
				series3aa.add(i, (float) or.not1.loc[2].phconc.get(i));
			}
			series4aa = new XYSeries("4");

			for (int i = 0; i < or.not1.loc[3].phconc.size() - 1; i++) {
				series4aa.add(i, (float) or.not1.loc[3].phconc.get(i));
			}
			series5aa = new XYSeries("5");

			for (int i = 0; i < or.not1.loc[4].phconc.size() - 1; i++) {
				series5aa.add(i, (float) or.not1.loc[4].phconc.get(i));
			}

			series6aa = new XYSeries("6");

			for (int i = 0; i < or.not1.loc[5].phconc.size() - 1; i++) {
				series6aa.add(i, (float) or.not1.loc[5].phconc.get(i));
			}

			series7aa = new XYSeries("7");

			for (int i = 0; i < or.not1.loc[6].phconc.size() - 1; i++) {
				series7aa.add(i, (float) or.not1.loc[6].phconc.get(i));
			}

			series8aa = new XYSeries("8");

			for (int i = 0; i < or.not1.loc[7].phconc.size() - 1; i++) {
				series8aa.add(i, (float) or.not1.loc[7].phconc.get(i));
			}

			series1ba = new XYSeries("9");

			for (int i = 0; i < or.not2.loc[0].phconc.size() - 1; i++) {
				series1ba.add(i, (float) or.not2.loc[0].phconc.get(i));
			}

			series2ba = new XYSeries("10");

			for (int i = 0; i < or.not2.loc[1].phconc.size() - 1; i++) {
				series2ba.add(i, (float) or.not2.loc[1].phconc.get(i));
			}
			series3ba = new XYSeries("11");

			for (int i = 0; i < or.not2.loc[2].phconc.size() - 1; i++) {
				series3ba.add(i, (float) or.not2.loc[2].phconc.get(i));
			}
			series4ba = new XYSeries("12");

			for (int i = 0; i < or.not2.loc[3].phconc.size() - 1; i++) {
				series4ba.add(i, (float) or.not2.loc[3].phconc.get(i));
			}
			series5ba = new XYSeries("13");

			for (int i = 0; i < or.not2.loc[4].phconc.size() - 1; i++) {
				series5ba.add(i, (float) or.not2.loc[4].phconc.get(i));
			}
			series6ba = new XYSeries("14");

			for (int i = 0; i < or.not2.loc[5].phconc.size() - 1; i++) {
				series6ba.add(i, (float) or.not2.loc[5].phconc.get(i));
			}
			series7ba = new XYSeries("15");

			for (int i = 0; i < or.not2.loc[6].phconc.size() - 1; i++) {
				series7ba.add(i, (float) or.not2.loc[6].phconc.get(i));
			}
			series8ba = new XYSeries("16");

			for (int i = 0; i < or.not2.loc[7].phconc.size() - 1; i++) {
				series8ba.add(i, (float) or.not2.loc[7].phconc.get(i));
			}
		}

		final XYSeriesCollection dataset = new XYSeriesCollection();
		if (AntGUI.simulationComponentSelected.compName == "NOT") {
			dataset.addSeries(series1);
			dataset.addSeries(series2);
			dataset.addSeries(series3);
			dataset.addSeries(series4);
			dataset.addSeries(series5);
			dataset.addSeries(series6);
			dataset.addSeries(series7);
			dataset.addSeries(series8);
		} else if ((AntGUI.simulationComponentSelected.compName == "AND")) {
			dataset.addSeries(series1a);
			dataset.addSeries(series2a);
			dataset.addSeries(series3a);
			dataset.addSeries(series4a);
			dataset.addSeries(series5a);
			dataset.addSeries(series6a);
			dataset.addSeries(series7a);
			dataset.addSeries(series8a);
			dataset.addSeries(series1b);
			dataset.addSeries(series2b);
			dataset.addSeries(series3b);
			dataset.addSeries(series4b);
			dataset.addSeries(series5b);
			dataset.addSeries(series6b);
			dataset.addSeries(series7b);
			dataset.addSeries(series8b);
			dataset.addSeries(series1c);
			dataset.addSeries(series2c);
			dataset.addSeries(series3c);
			dataset.addSeries(series4c);
			dataset.addSeries(series5c);
			dataset.addSeries(series6c);
			dataset.addSeries(series7c);
			dataset.addSeries(series8c);

		} else if ((AntGUI.simulationComponentSelected.compName == "OR")) {
			dataset.addSeries(series1aa);
			dataset.addSeries(series2aa);
			dataset.addSeries(series3aa);
			dataset.addSeries(series4aa);
			dataset.addSeries(series5aa);
			dataset.addSeries(series6aa);
			dataset.addSeries(series7aa);
			dataset.addSeries(series8aa);
			dataset.addSeries(series1ba);
			dataset.addSeries(series2ba);
			dataset.addSeries(series3ba);
			dataset.addSeries(series4ba);
			dataset.addSeries(series5ba);
			dataset.addSeries(series6ba);
			dataset.addSeries(series7ba);
			dataset.addSeries(series8ba);
		}
		return dataset;
	}

	/**
	 * Creates a chart.
	 * 
	 * @param dataset
	 *            the data for the chart.
	 * 
	 * @return a chart.
	 */
	private JFreeChart createChart(final XYDataset dataset) {

		// create the chart...
		final JFreeChart chart = ChartFactory.createXYLineChart(
				"Line Chart for Locations", // chart title
				"Time", // x axis label
				"Pheromone", // y axis label
				dataset, // data
				PlotOrientation.VERTICAL, true, // include legend
				true, // tooltips
				false // urls
				);

		// NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
		chart.setBackgroundPaint(Color.white);

		// final StandardLegend legend = (StandardLegend) chart.getLegend();
		// legend.setDisplaySeriesShapes(true);

		// get a reference to the plot for further customisation...
		final XYPlot plot = chart.getXYPlot();
		plot.setBackgroundPaint(Color.white);
		// plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
		plot.setDomainGridlinePaint(Color.black);
		plot.setRangeGridlinePaint(Color.black);

		final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesLinesVisible(1, false);
		renderer.setSeriesShapesVisible(1, false);
		plot.setRenderer(renderer);

		// change the auto tick unit selection to integer units only...
		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		// OPTIONAL CUSTOMISATION COMPLETED.

		return chart;

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		SimulationBox.isSimulationCalled = false;
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	// ****************************************************************************
	// * JFREECHART DEVELOPER GUIDE *
	// * The JFreeChart Developer Guide, written by David Gilbert, is available
	// *
	// * to purchase from Object Refinery Limited: *
	// * *
	// * http://www.object-refinery.com/jfreechart/guide.html *
	// * *
	// * Sales are used to provide funding for the JFreeChart project - please *
	// * support us so that we can continue developing free software. *
	// ****************************************************************************

	/**
	 * Starting point for the demonstration application.
	 * 
	 * @param args
	 *            ignored.
	 */
	/*
	 * public static void main(final String[] args) {
	 * 
	 * GraphSimulator demo = new GraphSimulator("Line Chart Demo 6");
	 * demo.pack(); RefineryUtilities.centerFrameOnScreen(demo);
	 * demo.setVisible(true);
	 * 
	 * }
	 */

}
