package com.hectorflores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeMap;

public class FindMedianfromDataStream {

	ArrayList<Integer> list;
	 /** initialize your data structure here. */
    public FindMedianfromDataStream() {
       list = new ArrayList<>(); 
    }
    
    public void addNum(int num) {
    	
    	
    	list.add(num);
        
    }
    
    public double findMedian() {
        
    	Collections.sort(list);
    	
    	int size = list.size();
    	
    	double dob = 0;
    	
    	if (size % 2 == 0) {
			dob = list.get(size/2-1);
			
			dob += list.get(size/2);
			
			dob /= 2;
    		
    		
		}else {
			dob = list.get(size/2);
		}
    	return dob;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FindMedianfromDataStream s = new FindMedianfromDataStream();
		s.addNum(3);
		s.addNum(2);
		s.addNum(1);
	
		System.out.println(s.findMedian());
		
	}

}
