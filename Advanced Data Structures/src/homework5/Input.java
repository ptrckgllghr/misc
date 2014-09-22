//Patrick Gallagher

package homework5;
import java.util.Random;

/**
 * Takes in various levels of data and 
 * @author Patrick Gallagher
 */
public class Input {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		for (int k = 1; k < 11; k++)
		{
			System.out.println("");
			System.out.println("Run number " + k);
			System.out.println("						  Shell Sorts");
			System.out.println("");
			System.out.println("Size\t  " + padRight("Insertion", 10) +  padRight("Merge", 10)  
					+ padRight("Heap", 10) + padRight("Quick", 10) + padRight("Original", 10) 
					+ padRight("Hibbard", 10) + padRight("Sedgewick", 10) + padRight("Ciura", 10) 
					+ "n*log(n)");
			for (int i = 1000; i <= 10000; i += 1000)
				System.out.println(generateRow(i));
		}//end for
		
	}//end main
	
	/**
	 * generates an array of Integers randomly
	 * @param size
	 * @param range
	 * @return Integer[]
	 */
	private static Integer[] generateNumbers(int size, int range)
	{
		Random rand = new Random();
		Integer[] list = new Integer[size];
		
		for (int i = 0; i < size; i++)
		{
			int rn = rand.nextInt(range);
			list[i] = new Integer(rn);	
		}	
		
		return list;
	}
	
	/**
	 * finds the n * log sub 2 (n) of the parameter
	 * @param x
	 * @return
	 */
	private static int nLogn(int x)
	{
		return x * (int) (Math.log(x)/Math.log(2));
	}
	
	/**
	 * pads a String s with empty spaces so it is n characters long
	 * @param s - string to format
	 * @param n - size of full string
	 * @return
	 */
	private static String padRight(String s, int n) 
	{
	     return String.format("%1$-" + n + "s", s);  
	}
	
	/**
	 * creates a string of a row of data for the the running times of the sort methods in it
	 * @param number
	 * @return
	 */
	private static String generateRow(int number)
	{
		int pad = 10;
		String value = Integer.toString(number);
		String row1 = padRight(value, 10);
		//insertionSort
		Integer[] a = generateNumbers(number, 1000);
		long insertion = Sort.insertionSort(a);
		String row2 = padRight(Long.toString(insertion), pad);
		//mergeSort
		a = generateNumbers(number, 1000);
		long merge = Sort.mergeSort(a);
		String row3 = padRight(Long.toString(merge), pad);
		//heapSort
		a = generateNumbers(number, 1000);
		long heap = Sort.heapsort(a);
		String row4 = padRight(Long.toString(heap), pad);
		//quickSort
		a = generateNumbers(number, 1000);
		long quick = Sort.quicksort(a);
		String row5 = padRight(Long.toString(quick), pad);
		//shellSort - Poor
		a = generateNumbers(number, 1000);
		long shell1 = Sort.shellsortOriginal(a);
		String row6 = padRight(Long.toString(shell1), pad);
		//shellSort - Hibbard
		a = generateNumbers(number, 1000);
		long shell2 = Sort.shellsortHibbard(a);
		String row7 = padRight(Long.toString(shell2), pad);
		//shellSort - Sedgewick
		a = generateNumbers(number, 1000);
		long shell3 = Sort.shellsortHibbard(a);
		String row8 = padRight(Long.toString(shell3), pad);
		//shellSort - Ciura
		a = generateNumbers(number, 1000);
		long shell4 = Sort.shellsortHibbard(a);
		String row9 = padRight(Long.toString(shell4), pad);
		
		String log = Integer.toString(nLogn(number));
		
		return row1 + row2 + row3 + row4 + row5 + row6 + row7 + row8 + row9 + log;
	}

}//end class
