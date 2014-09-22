
public class StringDemo {

	public static void main(String[] args) {
//		String s1 = new String("Hello");
//		String s2 = "Hello";
//		String s3 = "Hello";
//		//comparing references
//		System.out.println(s1 == s2);
//		System.out.println(s2 == s3);
//		
//		//comparing values
//		System.out.println(s1.equals(s2));
//		System.out.println(s2.equals(s3));
//			
//		s1 = s1 + "World";
//		System.out.println(s1);
//		System.out.println(s1.length());
//		System.out.println(s1.toUpperCase());
//		System.out.println(s1.toLowerCase());
//		
//		System.out.println(s1.substring(3));
//		System.out.println(s1.substring(3,5));
//		System.out.println(s1.replace('o', 'a'));
//		
//		System.out.println(s1.indexOf('o'));
//		System.out.println(s1.lastIndexOf('o'));
//		System.out.println(s1.charAt(5));
//		
//		//Print index of all 'l' in string
//		
//		printCharIndex("Hello World", 'l');
		
		
		//validate emial id
		//1. should have only 1 '@' in string...
		//2. There should be at least 4 chars before '@'
		//3. There should be at least 3 chars between '@' and '.'
		//4. There should be at least 2 chars after '.'
		String email = "zubair@gmail.com";
		String email2 = "paddycakes@real.nz";
		String email3 = "wrong@n.xx";
		String email4 = "wro@n.ne";
		String email5 = "wrong@this.y";
		
		//optimized email validation
		int indexDot = email.indexOf('.');
		int indexAt = email.indexOf('@');
		int len = email.length();
		
		if (indexAt == email.lastIndexOf('@') &&
				indexDot == email.lastIndexOf('.') &&
				indexAt > 4 && (indexDot - indexAt) > 3 
				&& len > (indexDot + 2))
			System.out.println("Valid email");
		else
			System.out.println("Invalid email");
				
		
		
		System.out.println(validateEmail(email));
		System.out.println(validateEmail(email2));
		System.out.println(validateEmail(email3));
		System.out.println(validateEmail(email4));
		System.out.println(validateEmail(email5));
		
	}
	
	public static boolean validateEmail(String input)
	{
		if (!confirmAtAndPeriod(input))//tests if their are the appropriate chars in the email
			return false;
		String[] dividedByAt = input.split("@");//splits at @
		String beginning = dividedByAt[0];		//beginning of email address, the name
		String[] dividedByPeriod = dividedByAt[1].split("\\.");	//split at .
		String middle = dividedByPeriod[0];		//middle of the email address, the provider
		String end = dividedByPeriod[1];		//the end of the email address, the domain
		
		//test if part before @ is properly sized
		if (beginning.length() >= 4  && middle.length() >= 3 && end.length() >= 2)
			return true;
		return false;
	}
	
	
	/**
	 * tests if an input has only 1 @ and . symbol in it
	 * @param input
	 * @return boolean
	 */
	public static boolean confirmAtAndPeriod(String input)
	{
		char[] charArray = input.toCharArray();
		int numOfAt = 0, numOfPeriod = 0;
		for (int i = 0; i < charArray.length; i++)
		{
			if (charArray[i] == '@')
				numOfAt++;
			if (charArray[i] == '.')
				numOfPeriod++;
		}
		if (numOfAt == 1 && numOfPeriod == 1)
			return true;
		//else
		return false;
	}
	
	public static void printCharIndex(String input, char charWanted)
	{
		char[] charArray = input.toCharArray();
		for (int i = 0; i < charArray.length; i++)
		{
			if (charArray[i] == charWanted)
				System.out.println(i);
		}
	}

}
