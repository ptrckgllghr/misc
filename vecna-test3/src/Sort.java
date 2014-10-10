public class Sort {

	public static void main(String[] args) {
		// This code will sort the numbers in the array.
		// task: Modify the algorithm to reverse the sort, then comment on its
		// efficiency in the space provided below:
		//
		// Changing the direction of the sort was simply a matter of changing
		// around the indexes used to make calculations, from -1 to 101
		//
		// This sort requires the use of two for loops, making it an n^2
		// algorithm, which is not very effecient for large arrays, a shell sort
		// or quick sort algorithm would be more efficient
		//

		// unsorted start
		int[] unsorted = new int[100];// creates an array named unsorted, size
										// 100
		for (int i = 0; i < 100; i++)
			// loop that adds random numbers into the array
			unsorted[i] = (int) (Math.random() * 100);
		System.out.println("Here are the unsorted numbers:");
		for (int i = 0; i < 100; i++)
			System.out.print(unsorted[i] + " ");
		System.out.println();
		// unsorted end

		// sorted start
		// changed by using 100 as the index instead of - 1
		int[] sorted = new int[100];
		for (int i = 0; i < 100; i++) {
			int hi = 100; // switched to 100
			int hiIndex = 100; // switched to 100
			for (int j = 0; j < 100; j++) {
				if (unsorted[j] < hi) {// if less than h1 instead of greater
										// than
					hi = unsorted[j];
					hiIndex = j;
				}
			}// end for
			sorted[i] = hi;
			unsorted[hiIndex] = 100;// switched to 100
		}// end for
		System.out.println("Here are the sorted numbers:");
		for (int i = 0; i < 100; i++)
			System.out.print(sorted[i] + " ");
		System.out.println();
	}

}
// old sort for reference
// int[] sorted = new int[100];
// for (int i = 0; i < 100; i++) {
// int hi = -1;
// int hiIndex = -1;
// for (int j = 0; j < 100; j++) {
// if (unsorted[j] > hi) {
// hi = unsorted[j];
// hiIndex = j;
// }
// }
// sorted[i] = hi;
// unsorted[hiIndex] = -1;
// }//end for
// System.out.println("Here are the sorted numbers:");
// for (int i = 0; i < 100; i++)
// System.out.print(sorted[i] + " ");
// System.out.println();
