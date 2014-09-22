//Patrick Gallagher

package homework3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class FileInput {
	
	public static void main(String[] args) {
		Scanner inFile = null;  // creates Scanner object
		
		try
		{//reads in the input file
			inFile = new Scanner(new File("C:\\Users\\Patrick\\Desktop\\Advanced Data Structures\\assign3-in.dat"));
		} //assign3-in.dat  sample.txt 
		catch (IOException e)
		{
			System.out.println(e.getMessage()); // display error
			System.exit(1);                     // terminate program
		}
		
		while (inFile.hasNextLine())
		{
			String eq = inFile.nextLine(); //scanner stores equation in a variable called eq, short for equation
			
			System.out.println("The equation to be evaluated is : " + eq);
			//creates an infix to postfix converter called converter
			System.out.println(""); pause();	
			
			//takes the infix expression and converts it to a postfix expression
			InToPostConverter converter = new InToPostConverter(eq);
			
			//creates a String called postfixEq that stores the converted equation
			String postfixEq = converter.getEndResult();
			System.out.println("The postfix form of this exprssion is : " + postfixEq);
			System.out.println(""); pause();
			
			//creates an expression tree called etc
			ExpressionTreeCreator etc = new ExpressionTreeCreator(postfixEq);
			
			System.out.print("A visual representation of the expression tree:");
			System.out.println("");
			System.out.println("");
	
			etc.showTree();
			System.out.println(""); pause();
			
			System.out.print("The fully paranthesized expression : ");
			etc.printInfixExpression();
			System.out.println(""); System.out.println(""); System.out.println(""); pause();
			
			System.out.println("The result of the expression : " + etc.evaluateTree());
			
			System.out.println("");System.out.println("");System.out.println("");
			endPause();//move on to the next expression
			System.out.println(""); System.out.println(""); 
			System.out.println(""); System.out.println("");	
		}
	}
	
	/**
	 * prompts user to press the enter button to continue
	 */
	public static void pause()
	{
		System.out.println("Press enter to continue...");
		Scanner in = new Scanner(System.in);
		in.nextLine();
	}
	
	/**
	 * variation of pause method used for last pause when moving on to another expression from the infile
	 */
	public static void endPause()
	{
		System.out.println("Press enter to start the next expression...");
		Scanner in = new Scanner(System.in);
		in.nextLine();
	}
}