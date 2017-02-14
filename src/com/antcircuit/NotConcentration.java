package com.antcircuit;

import java.util.Random;

public class NotConcentration extends Concentration {

	float pumpA; //
	float pumpB; //
	int outputAnts = 0;
	float inputAnts;//
	float sourceAnts;//
	Location[] loc = new Location[10];
	float inpToSink;
	float sourceToOutput;
	private int sourceTosink;
	boolean notStatus;
	Location location;

	public NotConcentration(float pumpA, float pumpB, float input, float battery) {

		this.pumpA = pumpA;
		this.pumpB = pumpB;
		this.inputAnts = input;
		this.sourceAnts = battery;
		this.notStatus = true;

		loc[0] = new Location();
		for (int i = 0; i < 9; i++) {
			loc[i] = new Location();
			loc[i].writeFlag(0);
		}
		loc[0].next = loc[1];
		loc[0].prev = null;
		loc[1].next = loc[2];
		loc[1].prev = loc[0];
		loc[2].next = loc[3];
		loc[2].prev = loc[1];
		loc[3].prev = loc[2];
		loc[4].next = loc[3];		
		loc[4].orNext = loc[5];
		loc[4].prev = null;
		loc[5].next = loc[6];
		loc[5].prev = loc[4];
		loc[6].next = loc[7];
		loc[6].prev = loc[5];
		loc[7].next = null;
		loc[7].prev = loc[6];
	}

	public NotConcentration() {
		// TODO Auto-generated constructor stub
		this.pumpA = 0;
		this.pumpB = 0;
		this.inputAnts = 0;
		this.sourceAnts = 0;
		this.notStatus = true;
		
		loc[0] = new Location();
		for (int i = 0; i < 9; i++) {
			loc[i] = new Location();
			loc[i].writeFlag(0);
		}
		loc[0].next = loc[1];
		loc[0].prev = null;
		loc[1].next = loc[2];
		loc[1].prev = loc[0];
		loc[2].next = loc[3];
		loc[2].prev = loc[1];
		loc[3].prev = loc[2];
		loc[4].next = loc[3];		
		loc[4].orNext = loc[5];
		loc[4].prev = null;
		loc[5].next = loc[6];
		loc[5].prev = loc[4];
		loc[6].next = loc[7];
		loc[6].prev = loc[5];
		loc[7].next = null;
		loc[7].prev = loc[6];
	}

	public void setValues(float pumpA, float pumpB, float input, float battery) {
		this.pumpA = pumpA;
		this.pumpB = pumpB;
		this.inputAnts = input;
		this.sourceAnts = battery;
	}

	public void updatePheromoneAtLocation() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 8; i++) {
			Location l = loc[i];
			float avgConc = average_conc(l);
			System.out
					.println("avgconc-" + avgConc + "  array index" + l.index);
			l.phconc.add((1 - AntSimulation.dissipate)
					* ((1 - AntSimulation.diffusion) * l.phconc.get(l.index) + AntSimulation.diffusion
							* (avgConc)) + AntSimulation.antSecrete
					+ pump(l, pumpA, pumpB));
			l.index++;
		}

	}

	public boolean Iteration() {

		System.out.println("NotConcentration Iteration shuru");
		boolean antOutputted = false;
		notStatus = checkGate();
		System.out.println("dekho dekho status dekho  -  " + notStatus);
		if (notStatus == true) {
			inputAnts--;
			if (inputAnts < 1&&sourceAnts<1)
				notStatus = false;
			System.out.println("inputAnts--abhi--" + inputAnts);
			System.out.println("source ant----= " +sourceAnts);
			if (sourceAnts > 0) {
				loc[4].flag = 1;
			}
			if (inputAnts > 0) {
				loc[0].flag = 1;
			}
			if (sourceAnts == 0) {
				loc[4].flag = 2;

			}
			updatePheromoneAtLocation();
			for (int i = 0; i < 8; i++) {
				Location l = loc[i];
				Location f;

				if (loc[i].flag == 1) {
					f = chooseaction(l);
					if (l == loc[7] && f == null) {
						antOutputted = true;
						sourceToOutput++;
					}
					if (l == loc[3] && f == loc[2]) {
						inpToSink++;
					}
					if (l == loc[3]) {
						sourceAnts--;
					}
					if (l == loc[4] && f == loc[3]) {
						sourceTosink++;
					}
					if (f == loc[0]) {
						if (loc[0].flag == 0)
							loc[0].flag = 1;
					}
					if (f == loc[1]) {
						if (loc[1].flag == 0)
							loc[1].flag = 1;
					}
					if (f == loc[2]) {
						if (loc[2].flag == 0)
							loc[2].flag = 1;
					}
					if (f == loc[3]) {
						if (loc[3].flag == 0)
							loc[3].flag = 1;
					}
					if (f == loc[4]) {
						if (loc[4].flag == 0)
							loc[4].flag = 1;
					}
					if (f == loc[5]) {
						if (loc[5].flag == 0)
							loc[5].flag = 1;
					}
					if (f == loc[6]) {
						if (loc[6].flag == 0)
							loc[6].flag = 1;
					}
					if (f == loc[7]) {
						if (loc[7].flag == 0)
							loc[7].flag = 1;
					}
				}
			}
			if (sourceAnts == 0) {
				setSAllLoc();
			}
			if (inputAnts == 0) {
				setIloc();
			}
		} else {
			return false;
		}
		System.out.println("jo hua acha hua" + antOutputted);
		return antOutputted;
	}

	private void setIloc() {
		// TODO Auto-generated method stub
		loc[0].flag = 0;
		loc[1].flag = 0;
		loc[2].flag = 0;
		loc[3].flag = 0;
	}

	private void setSAllLoc() {
		// TODO Auto-generated method stub
		loc[4].flag = 2;
		loc[5].flag = 2;
		loc[6].flag = 2;
		loc[7].flag = 2;

	}

	private boolean checkGate() {
		// TODO Auto-generated method stub
		System.out.println("checkGate aaya");
		boolean f = true;
		System.out.println("inputants--" + inputAnts + "  sourceants--"
				+ sourceAnts);
		if (inputAnts == 0 && sourceAnts == 0) {
			f = false;
		}
		System.out.println("checkGate gaya");
		return f;
	}

	public Location chooseaction(Location l) {

		if (l.equals(loc[4])) {
			Random randomGenerator = new Random();
			int random = randomGenerator.nextInt(10);
			if (random > 2) {
				if (loc[3].phconc.get(loc[3].index) > loc[5].phconc
						.get(loc[5].index)) {
					if (loc[3].phconc.get(loc[3].index) > AntSimulation.threshold) {
						loc[4].phconc
								.set(loc[4].phconc.size() - 1,
										(loc[4].phconc.get(loc[4].index) + AntSimulation.antSecrete));
					}
					return loc[3];
				} else {
					if (loc[5].phconc.get(loc[5].index) > AntSimulation.threshold) {
						loc[4].phconc
								.set(loc[4].phconc.size() - 1,
										(loc[4].phconc.get(loc[4].index) + AntSimulation.antSecrete));
					}
					return loc[5];
				}
			} else {
				if (loc[3].phconc.get(loc[3].index) < loc[5].phconc
						.get(loc[5].index)) {
					if (loc[5].phconc.get(loc[5].index) > AntSimulation.threshold) {
						loc[4].phconc
								.set(loc[4].phconc.size() - 1,
										(loc[4].phconc.get(loc[4].index) + AntSimulation.antSecrete));
					}
					return loc[3];
				} else {
					if (loc[5].phconc.get(loc[5].index) > AntSimulation.threshold) {
						loc[4].phconc
								.set(loc[4].phconc.size() - 1,
										(loc[4].phconc.get(loc[4].index) + AntSimulation.antSecrete));
					}
					return loc[5];
				}
			}
		} else if (l.equals(loc[0])) {
			if (loc[1].phconc.get(loc[1].index) > AntSimulation.threshold) {
				loc[0].phconc
						.set(loc[0].phconc.size() - 1,
								(loc[0].phconc.get(loc[0].index) + AntSimulation.antSecrete));
			}
			return loc[1];
		} else if (l.equals(loc[1])) {
			if (loc[2].phconc.get(loc[2].index) > AntSimulation.threshold) {
				loc[1].phconc
						.set(loc[1].phconc.size() - 1,
								(loc[1].phconc.get(loc[1].index) + AntSimulation.antSecrete));
			}
			return loc[2];
		} else if (l.equals(loc[3])) {
			if (loc[4].phconc.get(loc[4].index) > AntSimulation.threshold) {
				loc[4].phconc
						.set(loc[4].phconc.size() - 1,
								(loc[4].phconc.get(loc[4].index) + AntSimulation.antSecrete));
			}
			return null;
		} else if (l.equals(loc[5])) {
			if (loc[6].phconc.get(loc[6].index) > AntSimulation.threshold) {
				loc[5].phconc
						.set(loc[5].phconc.size() - 1,
								(loc[5].phconc.get(loc[5].index) + AntSimulation.antSecrete));
			}
			return loc[6];
		} else if (l.equals(loc[6])) {
			if (loc[7].phconc.get(loc[7].index) > AntSimulation.threshold) {
				loc[6].phconc
						.set(loc[6].phconc.size() - 1,
								(loc[6].phconc.get(loc[6].index) + AntSimulation.antSecrete));
			}
			return loc[7];
		} else {
			if (loc[6].phconc.get(loc[6].index) > AntSimulation.threshold) {
				loc[7].phconc
						.set(loc[7].phconc.size() - 1,
								(loc[7].phconc.get(loc[7].index) + AntSimulation.antSecrete));
			}
			return null;
		}
	}

	public float average_conc(Location l) {
		// System.out.println("index of loc"+l.index+"next ka index"+l.next.index);
		if (l == loc[0])
			return (loc[0].phconc.get(loc[0].index) + loc[1].phconc
					.get(loc[1].index)) / 2;
		else if (l == loc[1])
			return (loc[1].phconc.get(loc[1].index)
					+ loc[0].phconc.get(loc[0].index) + loc[2].phconc
						.get(loc[2].index)) / 3;
		else if (l == loc[2])
			return (loc[2].phconc.get(loc[2].index)
					+ loc[1].phconc.get(loc[1].index) + loc[3].phconc
						.get(loc[3].index)) / 3;
		else if (l == loc[3])
			return (loc[3].phconc.get(loc[3].index)
					+ loc[2].phconc.get(loc[2].index)
					+ loc[4].phconc.get(loc[4].index) + loc[5].phconc
						.get(loc[5].index)) / 4;
		else if (l == loc[4])
			return (loc[3].phconc.get(loc[3].index)
					+ loc[4].phconc.get(loc[4].index) + loc[5].phconc
						.get(loc[5].index)) / 3;
		else if (l == loc[5])
			return (loc[4].phconc.get(loc[4].index)
					+ loc[5].phconc.get(loc[5].index) + loc[6].phconc
						.get(loc[6].index)) / 3;
		else if (l == loc[6])
			return (loc[5].phconc.get(loc[5].index)
					+ loc[6].phconc.get(loc[6].index) + loc[7].phconc
						.get(loc[7].index)) / 3;
		else
			return (loc[6].phconc.get(loc[6].index) + loc[7].phconc
					.get(loc[7].index)) / 2;
	}

	public float prev_conc(float p) {
		float total_conc = 8;
		return total_conc;
	}

	public float pump(Location location, float pump_a, float pump_b) {
		float value = 0;
		float diff_a = Math.abs(location.phconc.get(location.index) - 2);
		float diff_b = Math.abs(location.phconc.get(location.index) - 5);

		value = (float) (pump_a * 0.5 * Math.pow(2, 1 - diff_a) + (pump_b * 0.5)
				* ((Math.pow(2, 1 - diff_b))));

		return value;
	}

	public float getOutput() {
		return outputAnts;
	}

	public void updateAnts(int i) {

		inputAnts++;
		System.out.println("inputants badhi--" + inputAnts);
	}
}