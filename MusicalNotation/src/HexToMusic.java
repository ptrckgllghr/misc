public class HexToMusic {

	/**
	 * @author Patrick Gallagher
	 * @param args
	 * 
	 * Takes a string of hex values and converts it into a base12 number system 
	 * with musical notes as symbols for 0 - 12
	 */
	public static void main(String[] args) {
		System.out.println("Input: 9, Output: " + convertToMusic("9"));
		System.out.println("Input: 9abcc389003, Output: " + convertToMusic("9abcc389003"));
		System.out.println("Input: dead, Output: " + convertToMusic("dead"));
		System.out.println("Input: feedface, Output: " + convertToMusic("feedface"));
		System.out.println("Input: nothex, Output: " + convertToMusic("nothex"));
		
	}
	
	private static String convertToMusic(String input)
	{
		if (isHex(input)) //if input value is a valid hex value
		{
			return convertNotation(convertToBase12(input));
		}
		else
			return "Input is not a valid hex number";
	}

	private static boolean isHex(String input) {
		try {
			Long.parseLong(input, 16);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	
	/**
	 * converts a String in hex into a base12 number
	 * @param input
	 * @return
	 */
	private static String convertToBase12(String input) {
		long a = Long.parseLong(input, 16);
		return Long.toString(a, 12);
	}

	private static String convertNotation(String input) {
		
		char[] values = input.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < values.length; i++) {
			sb.append(changeNotation(values[i]));
		}
		return sb.toString();
	}

	private static String changeNotation(char input) {
		String result;

		if (input == '0')
			result = "A";
		else if (input == '1')
			result = "A#";
		else if (input == '2')
			result = "B";
		else if (input == '3')
			result = "C";
		else if (input == '4')
			result = "C#";
		else if (input == '5')
			result = "D";
		else if (input == '6')
			result = "D#";
		else if (input == '7')
			result = "E";
		else if (input == '8')
			result = "F";
		else if (input == '9')
			result = "F#";
		else if (input == 'a')
			result = "G";
		else if (input == 'b')
			result = "G#";
		else//default
			result ="X";
		return result;
	}
}
