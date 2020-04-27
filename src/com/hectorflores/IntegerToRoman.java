package com.hectorflores;

public class IntegerToRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(integerToRoman(3999));
	}

	public static String integerToRoman(int in) {
		String result = "";
		String s = String.valueOf(in);
		
		char myarr[] = s.toCharArray();
		char myarray[] = {0,0,0,0};
		if (s.length() == 1) {
			myarray[3] = myarr[0];
			myarray[2] = 0;
			myarray[1] = 0;
			myarray[0] = 0;
		}else if (s.length() == 2) {
			myarray[3] = myarr[1];
			myarray[2] = myarr[0];
			myarray[1] = 0;
			myarray[0] = 0;
		}else if (s.length() == 3) {
			myarray[3] = myarr[2];
			myarray[2] = myarr[1];
			myarray[1] = myarr[0];
			myarray[0] = 0;
		}else {
			myarray = myarr;
		}

		switch (myarray[0]) {
		case '1':
			result += "M";
			break;

		case '2':
			result += "MM";
			break;
		case '3':
			result += "MMM";
			break;
		default:
			break;
		}

	
			switch (myarray[1]) {
			case '1':
				result += "C";
				break;

			case '2':
				result += "CC";
				break;
			case '3':
				result += "CCC";
				break;
			case '4':
				result += "CD";
				break;
			case '5':
				result += "D";
				break;
			case '6':
				result += "DC";
				break;
			case '7':
				result += "DCC";
				break;
			case '8':
				result += "DCCC";
				break;
			case '9':
				result += "CM";
				break;
			default:
				break;
			}
		
		
			switch (myarray[2]) {
			case '1':
				result += "X";
				break;

			case '2':
				result += "XX";
				break;
			case '3':
				result += "XXX";
				break;
			case '4':
				result += "XL";
				break;
			case '5':
				result += "L";
				break;
			case '6':
				result += "LX";
				break;
			case '7':
				result += "LXX";
				break;
			case '8':
				result += "LXXX";
				break;
			case '9':
				result += "XC";
				break;
			default:
				break;
			}
		
	
			switch (myarray[3]) {
			case '1':
				result += "I";
				break;

			case '2':
				result += "II";
				break;
			case '3':
				result += "III";
				break;
			case '4':
				result += "IV";
				break;
			case '5':
				result += "V";
				break;
			case '6':
				result += "VI";
				break;
			case '7':
				result += "VII";
				break;
			case '8':
				result += "VIII";
				break;
			case '9':
				result += "IX";
				break;
			default:
				break;
			}
		
		return result;
	}

}
