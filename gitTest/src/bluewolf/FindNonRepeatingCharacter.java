package bluewolf;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Patrick Gallagher
 *	finds the first non-repeating character in a string
 */
public class FindNonRepeatingCharacter {

	public static void main(String args[])
	{
		System.out.println("Test runs: \n");
		
		String test1 = "DEFD"; System.out.println("1: " + test1);
		System.out.println("Should be E : is " + findNonRepeatingCharacter(test1) + "\n");
		
		String test2 = "abcdABC"; System.out.println("2: " + test2);
		System.out.println("Should be a : is " + findNonRepeatingCharacter(test2) + "\n");
		
		String test3 = "I<3NY"; System.out.println("3: " + test3);
		System.out.println("Should be I : is " + findNonRepeatingCharacter(test3) + "\n");
		
		String test4 = "all things must pass"; System.out.println("4: " + test4);
		System.out.println("Should be h : is " + findNonRepeatingCharacter(test4) + "\n");
		
		String test5 = "_whynot"; System.out.println("5: " + test5);
		System.out.println("Should be _ : is " + findNonRepeatingCharacter(test5) + "\n");
		
		String test6 = "abcdefghijklmnopqrstuvwxyz  abcdefghijklmnopqrstuvwxyz 1234567890"; System.out.println("6: " + test6);
		System.out.println("Should be 1 : is " + findNonRepeatingCharacter(test6) + "\n");
		
		String test7 = "asrgbasreve"; System.out.println("7: " + test7);
		System.out.println("Should be g : is " + findNonRepeatingCharacter(test7) + "\n");
		
		String test8 = "12341234"; System.out.println("8: " + test8);
		System.out.println("Should be null : is " + findNonRepeatingCharacter(test8) + "\n");
		
		String test9 = "55555555555655555555555"; System.out.println("9: " + test9);
		System.out.println("Should be 6 : is " + findNonRepeatingCharacter(test9) + "\n");
		
		String test10 = "asbqwrgbrgdff;wieohbsjfbaowefpqwnfq;lwiufoaigweubue"; System.out.println("10: " + test10);
		System.out.println("Should be d : is " + findNonRepeatingCharacter(test10) + "\n");
		
		String test11 = "99999999999999"; System.out.println("11: " + test11);
		System.out.println("Should be null : is " + findNonRepeatingCharacter(test11) + "\n");
		
		String test12 = "!@%!@$^@%&@#%&#$^^]*#$%%&@@${}{}'':><><><><><ONP"; System.out.println("12: " + test12);
		System.out.println("Should be ] : is " + findNonRepeatingCharacter(test12) + "\n");
	}
	
	
	/**
	 * finds the the first non-repeating character in a string
	 * @param token
	 * @return the first non-repeating character, or null if all characters repeat
	 */
	public static Character findNonRepeatingCharacter(String token)
	{
		char[] tokens = token.toCharArray();//char array of values in token input
		//charMap stores character as the key and place in array as the value
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
		//char hell, if a char is in this map it was already used
		HashMap<Character, Integer> charHell = new HashMap<Character, Integer>();
		//iterates through tokens array
		for (int i = 0; i < tokens.length; i++)
		{
			if (charMap.containsKey(tokens[i]))
			{//if the char is already in the charMap, it is a repeat and not the right answer
				charMap.remove(tokens[i]); //the char is removed from the charMap
				charHell.put(tokens[i], i);//the char is added to char hell
			}
			else
			{//element is not currently in the charMap
				if (!charHell.containsKey(tokens[i]))//if the char isn't already in char hell
					charMap.put(tokens[i], i);		 //it is added to the charMap
			}
		}//end for
		
		Character c = null;//stores the char value of the charMap
		Integer min = Integer.valueOf(Integer.MAX_VALUE );//Initializes min to max value
		for(Map.Entry<Character, Integer> e : charMap.entrySet())//goes through charMap values
		{
		    if(min.compareTo(e.getValue()) > 0) //if e is less than the running min value
		    {
		        c = e.getKey();		//c becomes the character key of e
		        min = e.getValue(); //min becomes the value of e
		    }
		}
		return c;
	}//end findNonRepeatingCharacter
}


