public class DogSearch {
	public static void main(String[] args) {
		// This code will not compile correctly until you fix it.
		//
		// We are trying to count the number of times the word
		// dog appears in some input text, but we can't seem to
		// remember the appropriate method call in the String class,
		// and are not sure our approach will work.
		// task: Use the JDK documentation to help us finish the code,
		// then discuss the ambiguity in the problem description, and
		// reword it to remove the ambiguity in the space provided below.
		//
		//
		//


		String input = new String(
				"The Dogman was no ordinary dog, nor man, but rather a peculiar dog-like man who barked like a dog, and panted like a dog, he even ate like a dog.  He owned a dog named Doglips, and interestingly enough, his favorite food was hotdogs.");
		System.out.println(input);
		int index = 0; // changing the index to start at 0 to line up with the
						// new logic for this test I'm using
		int count = 0;
		int inputSize = input.length();// added to get the size of the input
		String searchTerm = "dog";// a search term var to make this code more
									// adaptable to non-dog words in future
		int searchTermSize = searchTerm.length();// to get the size of the
													// search term
		System.out.print("Counting dogs: ");
		// I'm not sure if I'm supposed to be changing much about the code, but
		// I'm having a hard time understanding the logic of this loop and how a
		// negative index is useful here
		// I'm switching the loop to work using the new variables I created not
		// sure if that old kind of loop design is viable, but a simpler loop
		// structure makes more sense in this case
		do {
			// creates a substring of the characters in the input, based on the
			// index value and the size of the search term
			String testForTerm = input.substring(index, searchTermSize + index);
			// tests if the search term with the equalIgnoreCase, not specified
			// if case matters so I'm using this just in case, easy switch to
			// equals if it is meant to be
			if (testForTerm.equalsIgnoreCase(searchTerm)) {
				count++;
				System.out.print(count + " ");
			}
			index++; // old code lacked a means to avoid infinite loops
			// loop will stop before index reaches the point were the input String
			// is empty past the search term size to prevent index out of bounds error
		} while (index <= inputSize - searchTermSize);
		System.out.println();
		System.out.println("The word \"dog\" appears " + count + " times.");
	}
}
