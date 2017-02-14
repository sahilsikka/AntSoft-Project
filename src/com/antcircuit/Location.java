package com.antcircuit;

import java.util.ArrayList;

class Location {
	int flag;
	int index;
	Location next;
	Location orNext;
	Location prev;
	ArrayList<Float> phconc;

	public Location() {
		flag = 0;
		next = null;
		orNext = null;
		prev = null;
		this.index = 0;
		phconc = new ArrayList<Float>();
		phconc.add((float)0);
	}

	public int getFlag() {
		return flag;
	}

	public void writeFlag(int val) {
		flag = val;
	}
}
