//Patrick Gallagher

package homework4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * takes in the data file and prompts user control
 * @author Patrick Gallagher
 *
 */
public class FileInput {

	static BinaryTree tree;
	
	public static void main(String[] args) 
	{
		Scanner inFile = null;  // creates Scanner object
		
		try
		{//reads in the input file
			inFile = new Scanner(new File("C:\\Users\\Patrick\\Desktop\\Advanced Data Structures\\assign4-in.dat"));
		} //assign4-in.dat  sample.txt 
		catch (IOException e)
		{
			System.out.println(e.getMessage()); // display error
			System.exit(1);                     // terminate program
		}
		
		//creates a Binary Tree called tree, also has splay tree functionality
		tree = new BinaryTree();
		
		while(inFile.hasNextInt())
		{
			int num = inFile.nextInt();
			tree.nsinsert(num);
		}
		
		
		System.out.println("This is the initial tree:");
		System.out.println("");
		Node r = tree.getRoot();//sets the Node r as the root of the tree		
		printTree(r, 0);//prints the tree
		System.out.println("---------");
	
		interact();	
	}
		
	private static void interact()
	{
		promptUser();//list commands
		Scanner in = new Scanner(System.in);
		String option = in.nextLine();
		Scanner command = new Scanner(option);
		
		while (command.hasNext())
		{
			String t = command.next();
			int v = command.nextInt();
			callMethod(t,v);
		}
		Node printRoot = tree.getRoot();
		System.out.println("");
		printTree(printRoot, 0);
		System.out.println("");
		interact();//call itself
	}
	
	private static void callMethod(String type, int value)
	{
		if (type.equalsIgnoreCase("S"))//splay
		{
			tree.splay(value);
			System.out.println("Splay done");
		}
		else if (type.equalsIgnoreCase("I")) //insert
		{
			tree.splay(value);
			if (!tree.isEmpty())
			{
				if(tree.getRoot().element == value)
					System.out.println("Duplicated keys");
			}
			else
				System.out.println("Insertion is successful");
			tree.insert(value);
		}
		else if (type.equalsIgnoreCase("D"))  //delete
		{
			if (tree.delete(value))
				System.out.println("Deletion is successful");
			else
				System.out.println("Key not in the tree");
		}
		else if (type.equalsIgnoreCase("F"))//search
		{
			if (!tree.isEmpty())
			{
				if(tree.search(value))
					System.out.println("Search is successful");
			}
			else
				System.out.println("Search is unsuccessful");
		}
		else
			System.out.println("Invalid command");
	}//end callMethod
	
	
	private static void promptUser()
	{
		System.out.println("---------");
		System.out.println("To adjust the tree, enter one of these commands and a value");
		System.out.println("example: S 10");
		System.out.println("");
		System.out.println("S - to splay the tree at a value");
		System.out.println("I - to insert a value to the tree");
		System.out.println("D - to delete a value from the tree");
		System.out.println("F - search for the value from the tree");
		System.out.println("");
		System.out.println("Enter: ");
	}
	
	/**
	 * prints a sideways tree starting at the rightmost node, then to the root, then the left
	 * @param n
	 * @param depth
	 */
	static void printTree(Node n, int depth)
	{
		if (n != null)
		{
			printTree(n.right, depth + 1);
			for (int i = 0; i < depth; i++)
				System.out.print("\t");
			System.out.println(n.element);
			printTree(n.left, depth + 1);
		}
	}
	
}//end class
