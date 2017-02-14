package com.antcircuit;

public class AntSimulation {

	static float dissipate;
	static float diffusion;
	static float t;
	static float w;
	static float antSecrete;
	static float threshold;
	float finalOutput;
	boolean isWorking;
	AndConcentration a;
	NotConcentration n;
	OrConcentration o;
	static String finalresult;
	public AntSimulation(float d, float f, float s, float t) {
		AntSimulation.dissipate = d;
		AntSimulation.diffusion = f;
		AntSimulation.threshold = t;
		AntSimulation.antSecrete = s;

		setParameters();

		isWorking = findStatus();
		while (isWorking) {
			runSimulation();
		}

		for(Connection c : DisplayCanvas.connection) {
			if(c.Input.compName == "OUTPUT"){
				if(c.Output.compName == "NOT"){
					NotConcentration n = (NotConcentration) c.Output.gate;
					System.out.println("final output is"+n.sourceToOutput);
					finalresult="final output is"+n.sourceToOutput;
				}
				if(c.Output.compName == "OR"){
					OrConcentration n = (OrConcentration) c.Output.gate;
					System.out.println("final output is"+n.antsOutputted);
					finalresult="final output is"+n.antsOutputted;
				}
				if(c.Output.compName == "AND"){
					AndConcentration n = (AndConcentration) c.Output.gate;
					System.out.println("final output is"+n.antsOutputted);
					finalresult="final output is"+n.antsOutputted;
				}
				
			}
		}
		//printAll();
	}

	private void setParameters() {
		// TODO Auto-generated method stub

		for (Components c : DisplayCanvas.component) {
			if (c.compName.equals("NOT")) {

				n = (NotConcentration) c.gate;
				n.setValues(c.getPump_a(), c.getPump_b(), c.inputA,
						c.getBattery());
			}
			if (c.compName.equals("AND")) {
				a = (AndConcentration) c.gate;
				a.setValues(c.getPump_a(), c.getPump_b(), c.inputA, c.inputB,
						c.getBattery());
			}

			if (c.compName.equals("OR")) {
				o = (OrConcentration) c.gate;
				o.setValues(c.getPump_a(), c.getPump_b(), c.inputA, c.inputB,
						c.getBattery());
			}
		}
	}

	private void printAll() {
		// TODO Auto-generated method stub
		System.out.println("Simulation shuru");
		for (Components c : DisplayCanvas.component) {
			System.out.println(c.id + "--" + c.compName + " ");
			if (c.compName.equals("NOT")) {
				NotConcentration not = (NotConcentration) c.gate;
				System.out.println("loc[i] ka size hai-- "
						+ not.loc[1].phconc.size());
				for (int i = 0; i < 8; i++) {
					int j = 0;
					Float f = null;
					for (int k = 0; k < 8; k++) {
						f = not.loc[i].phconc.get(k);

						System.out.println("For Loc " + i);
						System.out.println(j + " " + f);
						j++;
					}
				}
			} else if (c.compName.equals("OR")) {
				OrConcentration or = (OrConcentration) c.gate;
				NotConcentration not = (NotConcentration) or.not1;
				for (int i = 0; i < 8; i++) {

					int j = 0;
					Float f = null;
					for (int k = 0; k < 5; k++) {
						f = not.loc[i].phconc.get(k);

						System.out.println("For Loc " + i);
						System.out.println(j + " " + f);
						j++;
					}
				}
				not = (NotConcentration) or.not2;
				for (int i = 0; i < 8; i++) {
					int j = 0;
					for (float f : not.loc[i].phconc) {
						System.out.println("For Loc " + i);
						System.out.println(j + " " + f);
						j++;
					}
				}
			} else if (c.compName.equals("AND")) {
				AndConcentration and = (AndConcentration) c.gate;
				NotConcentration not = (NotConcentration) and.not1;
				for (int i = 0; i < 8; i++) {
					int j = 0;
					for (float f : not.loc[i].phconc) {
						System.out.println(j + " " + f);
						j++;
					}
				}
				not = (NotConcentration) and.not2;
				for (int i = 0; i < 8; i++) {
					System.out.println("For Loc " + i);
					int j = 0;
					for (float f : not.loc[i].phconc) {
						System.out.println("For Loc " + i);
						System.out.println(j + " " + f);
						j++;
					}
				}
				not = (NotConcentration) and.not3;
				for (int i = 0; i < 8; i++) {
					int j = 0;
					for (float f : not.loc[i].phconc) {
						System.out.println("For Loc " + i);
						System.out.println(j + " " + f);
						j++;
					}
				}
			}
		}
		System.out.println("Simulation khatam");
	}

	private boolean findStatus() {
		// TODO Auto-generated method stub
		boolean statusMain = false;
		for (Components c : DisplayCanvas.component) {
			System.out.println("mainstatuswala id -" + c.id + " - "
					+ c.compName);
			System.out.println("snts avlue aaree -----" + c.inputA);
			if ((!c.compName.equals("INPUT")) && (!c.compName.equals("OUTPUT"))) {
		//		System.out.println("konsa gate aaya  -" + c.compName
		//				+ "with status  -" + o.orStatus);
				if (c.compName.equals("NOT")) {
					n = (NotConcentration) c.gate;
					if (n.notStatus) {
						System.out.println("status of respective gate"
								+ n.notStatus);
						statusMain = true;
					}
				} else if (c.compName.equals("AND")) {
					a = (AndConcentration) c.gate;
					if (a.andStatus) {
						System.out.println("status of respective gate"
								+ a.andStatus);
						statusMain = true;
					}
				} else if (c.compName.equals("OR")) {
					o = (OrConcentration) c.gate;
					if (o.orStatus) {
						System.out.println("status of respective gate"
								+ o.orStatus);
						statusMain = true;
					}
				}

			}
		}
		System.out.println("statusmain" + statusMain);
		return statusMain;
	}

	public void runSimulation() {
		System.out.println("runsimulation aaya");
		for (Components c : DisplayCanvas.component) {
			System.out.println("Component ki baari" + c.compName);
			if ((!c.compName.equals("INPUT")) && (!c.compName.equals("OUTPUT"))) {
				boolean ifOut = c.gate.Iteration();
				if (ifOut) {
					for (Connection con : DisplayCanvas.connection) {
						if (con.Output == c) {
							System.out.println("connection mil gaya--x1");
							if (con.Input.compName != "OUTPUT")
								if ((con.wire.offSetX1 == 0)
										&& (con.wire.offSetY1 == 20))
									con.Input.gate.updateAnts(1);
								else if ((con.wire.offSetX2 == 0)
										&& (con.wire.offSetY2 == 20))
									con.Input.gate.updateAnts(1);
								else if ((con.wire.offSetX1 == 0)
										&& (con.wire.offSetY1 == 40))
									con.Input.gate.updateAnts(2);
								else if ((con.wire.offSetX2 == 0)
										&& (con.wire.offSetY2 == 40))
									con.Input.gate.updateAnts(2);
						}
					}
				}
			}
		}
		isWorking = findStatus();
	}
}
