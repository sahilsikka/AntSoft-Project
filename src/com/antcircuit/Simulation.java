package com.antcircuit;

public class Simulation {
	
	public static void simulate()
	{
		int i;
		Components c1,c2;
		Connection conn=null;
		int output;
		for(i=0;i<DisplayCanvas.component.size();i++)
		{
			c1=DisplayCanvas.component.get(i);
			if(c1.compName=="Input")
			{
				conn.start=c1;
				c2=conn.wire.p2;					
				if(c2.compName=="NOT")
				{
	//				output=NotConcentration.
				}
			}
		}
	}
	
	
	

}
