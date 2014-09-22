package bluewolf;

import java.util.Random;

/**
 * @author Patrick Gallagher
 *creates a "deck" of 52 cards and then shuffles them
 */
public class ShuffleDeck {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		for (int j = 1; j < 11; j++)
		{
			System.out.println("Run " + j);
			Integer[] test = generateArray(52);
			System.out.print("Oringinal Deck: ");
			for (int i = 0; i < 52; i++)
				System.out.print(test[i] + " \n");	
			
			System.out.print("Shuffled:       ");
			shuffleDeck(test);
			for (int i = 0; i < 52; i++)
				System.out.print(test[i] + " ");
			System.out.println("\n \n");
			
		}//end for
	}

	/**
	 * takes in an Intger array and shuffles the values
	 * @param inDeck
	 */
	public static void shuffleDeck(Integer[] inDeck)
	{  
		Random rand = new Random();
		for (int i = inDeck.length - 1; i >= 0; i--)
	    {
			int j = rand.nextInt(i + 1);//j stores a random index in the deck
		    int a = inDeck[j];			//a stores the value at index j
		    inDeck[j] = inDeck[i];		//the value at index j is replaced by value at i
		    inDeck[i] = a;				//the value at index i is replaced by a
		 }//end for
	}//end shuffleDeck

	
	/**
	 * generates an array of Integers in order
	 * @param size
	 * @param range
	 * @return Integer[]
	 */
	private static Integer[] generateArray(int size)
	{
		Integer[] list = new Integer[size];
		for (int i = 0; i < size; i++)
			list[i] = new Integer(i);	
		return list;
	}
}
