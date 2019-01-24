package com.junit.task.assignment;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class GetSortedDetails {
	
	
		
		public GetSortedDetails() {
		
	}

		public static List<AllDetails> sortMap(List<AllDetails> fullDetails) {

	      
	        Collections.sort(fullDetails, new Comparator<AllDetails>() {
	            public int compare(AllDetails o1,
	            		AllDetails o2) {
	                if(o2.getPercentile()>o1.getPercentile())
	                	return 1;
	                else if(o1.getPercentile()>o2.getPercentile())
	                	return -1;
	                else {
	                	if (o1.getDOB().compareTo(o2.getDOB()) > 0) 
	                        return 1;
	                    else
	                    	return -1;
	                }
	            }
	        });

			
			return fullDetails;
		}
}
