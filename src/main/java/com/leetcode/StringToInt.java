package com.leetcode;


public class StringToInt {

	
	
	public static int atoi(String str) {
		//The var negative 1 mensa negative, 2 means positive
		int negative = 0;
		boolean start = false,take = false;
		long result = 0;
		String save = "";
		str.toLowerCase();
		char[] myarray = str.toCharArray();
		
		outerloop:
		for (int i = 0; i <myarray.length; i++) {
			if((myarray[i] >= '0' && myarray[i] <= '9') || (myarray[i] == ' ') || (myarray[i] == '-') || (myarray[i] == '+')) {
				
				if((myarray[i] == '-') && start == false){
					negative = 1;
					start = true;
				}else if((myarray[i] == '+') && start == false){
					negative = 2;
					start = true;
					if(myarray[i] != '+')save += String.valueOf(myarray[i]);
				}else if((start == true) || (myarray[i] >= '0' && myarray[i] <= '9')) {
					while(i < myarray.length) {
						if((myarray[i] >= '0' && myarray[i] <= '9')){	
							if(myarray[i] != '0' && take == false) {
								save += String.valueOf(myarray[i]);		
								take = true;
							}else if(take == true){
								save += String.valueOf(myarray[i]);	
							}
											
						}else {
							break outerloop;
						}
						i++;
					}
				}
			}else {
				break;
			}
		}
		
		if(!save.isEmpty() && save.length() < 12 ) {
			result = Long.parseLong(save);
		}else if(save.length() > 11 && negative != 1){
			return Integer.MAX_VALUE;
		}else if(save.length() > 11 && negative == 1){
			return Integer.MIN_VALUE;
		}else {
			return 0;
		}
		
		if (negative == 1) {
			result *= -1; 
		}
		
		
		if (result >= Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}else if(result <= Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		
		return (int) result;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = StringToInt.atoi("-90000000000000000000000");
		System.out.println(a);
	}

}
