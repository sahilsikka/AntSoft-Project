package com.antcircuit;

public class OrConcentration extends Concentration {

	NotConcentration not1, not2;
	static float OrOutputAnts = 0;
	boolean orStatus;
	public float antsOutputted = 0;
	
	public OrConcentration(float pumpA, float pumpB, float inputA,
			float inputB, float battery) {
		not1 = new NotConcentration(pumpA, pumpB, inputA + inputB, battery);
		not2 = new NotConcentration(pumpA, pumpB, not1.outputAnts, battery);
		OrOutputAnts = not2.getOutput();
		this.orStatus = true;
	}
	
	public OrConcentration() {
		this.orStatus=true;
		not1=new NotConcentration();
		not2=new NotConcentration();
	}
	
	public void setValues(float pumpA, float pumpB, float inputA, float inputB,
			float battery) {
		not1.setValues(pumpA, pumpB, inputA + inputB, battery);
		not2.setValues(pumpA, pumpB, not1.outputAnts, battery);
	}

	public boolean Iteration() {
		System.out.println("OrConcentration Iteration shuru");
		boolean b = true;
		if (orStatus) {
			b = not1.Iteration();
			if (b) {
				not2.updateAnts(1);
			}
			b = not2.Iteration();
		}
		if(b){
			antsOutputted++;
		}
		if (not1.notStatus || not2.notStatus)
			orStatus = true;
		else
			orStatus = false;
		return b;
	}

	public float getOutput() {
		return OrOutputAnts;
	}

	public void updateAnts(int i) {
		not1.updateAnts(1);
	}
}
