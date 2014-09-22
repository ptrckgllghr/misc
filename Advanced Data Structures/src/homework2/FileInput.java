package homework2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class FileInput {
	
	public static void main(String[] args) {
		Scanner inFile = null;  // creates Scanner object
		
		try
		{//reads in the input file
			inFile = new Scanner(new File("C:\\Users\\Patrick Gallagher\\workspace\\Advanced Data Structures\\src\\homework2"));
		} //assign2-in.dat  sample.txt
		catch (IOException e)
		{
			System.out.println(e.getMessage()); // display error
			System.exit(1);                     // terminate program
		}
		
		System.out.println("Hello!  This is a postfix form expression calculator.");
		System.out.println("");
		
		while (inFile.hasNextLine())
		{
			String eq = inFile.nextLine(); //scanner stores equation in a variable called eq, short for equation
			
			System.out.println("The expression to be evaluated is  " + eq);
			
			FindVariables fv = new FindVariables(eq);  //creates an object that scans through the line
			//if any variables are present prompts user to give an integer value
			String newEq = fv.getEndResult();//the updated line with integer values
			//creates an object that evaluates a postfix expression called newEq
			PostfixExpressionEvaluation post = new PostfixExpressionEvaluation(newEq);
			
			System.out.println("");//returns the post result
			if (!post.containsError())//if no error
				System.out.println("The value of the expression is " + post.getEndNum());
			else//post contains error
				System.out.println(post.getErrorMessage());
			System.out.println("");
			System.out.println("");
		}
		
		System.out.println("Goodbye.");
	}
}