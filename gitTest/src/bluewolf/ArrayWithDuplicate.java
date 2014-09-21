package bluewolf;

import java.util.HashMap;
import java.util.Random;

/**
 * @author Patrick Gallagher
 * searches through an array with an int duplicated, returns that value when found
 */
public class ArrayWithDuplicate {

	public static void main(String[] args) 
	{
		System.out.println("Test runs:");
		final int as = 1000000;//array size set to 1,000,000
		Random rand = new Random();
		int properRuns = 0;
		for (int i = 0; i < as; i += 50000)
		{
			int rn = rand.nextInt(as);//generates a random number no bigger than the array size
			boolean success = false;
			int value = createTest(as, rn, i);//(array size, index to change, replacement value)
			if (value == i)
			{
				success = true;
				properRuns++;
			}
			System.out.println("Should be " + i + ": is : " + value + " : " + success);
		}
		System.out.println("");
		System.out.println("Should run correctly 20 times.  Proper runs : " + properRuns);
		System.out.println("Special cases:"); System.out.println("");
		int array0 = createTest(as, rand.nextInt(as), 0);
		int arrayLast = createTest(as, rand.nextInt(as), as);
		if (array0 == 0 && arrayLast == 1000000)
		{
			System.out.println("Value from first index should be 0 : is " + array0);
			System.out.println("Value from last index should be 1000000 : is " + arrayLast);
			System.out.println("Special cases work");
		}
		else
			System.out.println("Error in special cases");
	}//end main

	/**
	 * Takes in an array with a duplicate (awd), creates intMap, then iterates through
	 * the array, if the value is already in the intMap, it returns the value,
	 * else it is stored in the map.
	 * @param awd
	 * @return duplicated value in the array, or -1 if no duplicate values are found
	 */
	public static int findDuplicate(Integer[] awd)
	{	//Hashmap with value and key as the same thing
		HashMap<Integer, Integer> intMap = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < awd.length; i++)
		{
			if (intMap.get(awd[i]) != null)//if value is already in the intMap
				return awd[i];			   //return it
			else//value is not in intMap
				intMap.put(awd[i], awd[i]);//add it to the intMap		
		}
		return -1;//only reached if no duplicate found
	}//end findDuplicate
	
	/**
	 * generates an array of Integers in order
	 * @param size
	 * @param range
	 * @return Integer[]
	 */
	private static Integer[] generateArray(int size)
	{
		Integer[] list = new Integer[size + 1];
		//adds the values to the array named list
		for (int i = 0; i < size + 1; i++)
			list[i] = new Integer(i);	
		return list;
		
	}
	
	/**
	 * creates a test for the findDuplicate method, creates an array of arraySize, selects an index to 
	 * change and a value to replace it with
	 * @param arraySize
	 * @param indexToChange
	 * @param replacementValue
	 * @return duplicated value in the array
	 */
	private static int createTest(int arraySize, int indexToChange, int replacementValue)
	{
		Integer[] test = generateArray(arraySize); //generates test array
		test[indexToChange] = replacementValue;	   //changes the value at the index to replacement value
		return findDuplicate(test);				   
	}
}

