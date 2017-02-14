package com.antcircuit;

public class AndConcentration extends Concentration {

	NotConcentration not1, not2, not3;
	static float AndOutputAnts = 0;
	boolean andStatus;
	public float antsOutputted = 0;

	public AndConcentration(float pumpA, float pumpB, float inputA,
			float inputB, float battery) {
		not1 = new NotConcentration(pumpA, pumpB, inputA, battery);
		not2 = new NotConcentration(pumpA, pumpB, inputB, battery);
		not3 = new NotConcentration(pumpA, pumpB, not1.getOutput()
				+ not2.getOutput(), battery);
		AndOutputAnts = not3.outputAnts;
		this.andStatus = true;
	}

	public AndConcentration() {
		this.andStatus=true;
		not1=new NotConcentration();
		not2=new NotConcentration();
		not3=new NotConcentration();
	}

	public void setValues(float pumpA, float pumpB, float inputA, float inputB,
			float battery) {
		not1.setValues(pumpA, pumpB, inputA, battery);
		not2.setValues(pumpA, pumpB, inputB, battery);
		not2.setValues(pumpA, pumpB, not1.getOutput() + not2.getOutput(),
				battery);
	}

	public boolean Iteration() {
		System.out.println("AndConcentration Iteration shuru with status"
				+ andStatus);
		if (not1.notStatus || not2.notStatus || not3.notStatus) {
			System.out.println("not1 baba  " + not1.notStatus + "  not2.baba"
					+ not2.notStatus + "  not3.baba " + not3.notStatus);
			andStatus = true;
		} else {
			System.out.println("AndConcentration Iteration false pe khatam");
			andStatus = false;

		}
		boolean b;
		boolean c = true;
		if (andStatus) {
			b = not1.Iteration();
			c = not2.Iteration();
			if (b) {
				not3.updateAnts(1);
			}
			if (c) {
				not3.updateAnts(1);
			}
			c = not3.Iteration();
		}
		if (not1.notStatus || not2.notStatus || not3.notStatus) {
			System.out.println("2nd baar not1 baba  " + not1.notStatus
					+ "  not2.baba" + not2.notStatus + "  not3.baba "
					+ not3.notStatus);
			andStatus = true;
		} else {
			System.out.println("AndConcentration Iteration false pe khatam");
			andStatus = false;

		}
		if(c){
			antsOutputted ++;
		}
		return c;
	}

	public static float getOutput() {
		return AndOutputAnts;
	}

	public void updateAnts(int i) {
		if (i == 1) {
			not1.updateAnts(1);
		} else if (i == 2) {
			not2.updateAnts(1);
		}
	}
}