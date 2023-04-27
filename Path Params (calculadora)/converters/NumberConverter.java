package br.com.anderson.converters;

public class NumberConverter {
	
	public static Double convertToDouble(String StringNumber) {
		if(StringNumber == null) return 0D;
		String number = StringNumber.replaceAll(",", ".");
		if (isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	public static boolean isNumeric(String StringNumber) {
		if(StringNumber == null) return false;
		String number = StringNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	

}
