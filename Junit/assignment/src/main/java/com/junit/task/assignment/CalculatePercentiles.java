package com.junit.task.assignment;

import java.util.Map;
import java.util.Map.Entry;

public class CalculatePercentiles {
	
	public CalculatePercentiles() {
	
	}

	static Map<Integer, Double> calulatePercentiles(Map<Integer, Double> marksMap,double maxMarks)throws IllegalArgumentException {
		
		try {
		if(maxMarks==0) 
			throw new IllegalArgumentException();
		}catch(IllegalArgumentException e){
			return null;
		}
		for (Entry<Integer, Double> entry : marksMap.entrySet())  {
            double percentile=(entry.getValue()/maxMarks)*100;
            entry.setValue(percentile);
		}
		return marksMap;
	}
}
