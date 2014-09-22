package homework2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;

public class FindVariables {

	private ArrayList<Variable> variables;
	private String result;
	
	public FindVariables(String line)
	{
		String next;
		variables = new ArrayList<Variable>(); //creates variables ArrayList
		Scanner in = new Scanner(line);		  //the line being scanned
		Scanner key = new Scanner(System.in);//keyboard input
		StringBuilder sb = new StringBuilder(1000);//creates a stringBuilder with the capicity of 1000 characters
		
		while (in.hasNext())
		{
			if(in.hasNext(VAR))
			{
				next = in.next();//advances to next token
				
				if (alreadyVariable(next)) //if next is found in the variables array
				{
					int varValue = findVarValue(next);  //finds the value in the variables arraylist
					String replacement = Integer.toString(varValue);  //converts the integer to a string
					next = next.replace(next, replacement);  //replaces next with the replacement value				
				}
				else//new variable
				{
					System.out.println("");
					System.out.println("Enter the value of " + next + " > ");  //prompts new int
					int replacementInt = key.nextInt();  //takes in an int from the keyboard
					String replacement = Integer.toString(replacementInt);  //converts the integer to a string
					variables.add(new Variable(next, replacementInt));  //stores this Variable symbol and its value
					next = next.replace(next, replacement);//replaces the String in the line at next with the converted int
				}
			}
			else //token is an operator or a number and left unchanged
			{
				next = in.next();
				if (next.equals("$"))//if the next token is a $ sign, append a dollar sign to make the result
				{
					sb.append("$");
					break;
				}
			}		
			sb.append(next + " "); //appends the string builder with next and an empty space
		}		
		result = sb.toString();
		
	}
	
	/**
	 * scans through the variables arraylist to see if the variable is already being accounted for
	 * @param token
	 * @return true/false
	 */
	private boolean alreadyVariable(String token)
	{
		for (Variable e : variables)
		{
			if (e.getVar().equals(token))
				return true;
		}
		return false;
	}
	
	/**
	 * finds the value for the variable inputted based on previous input from the keyboard
	 * @param token
	 * @return
	 */
	@SuppressWarnings("null")
	private int findVarValue(String token)
	{
		for (Variable e : variables)
		{
			if(e.getVar().equals(token))
				return e.getValue();
		}
		return (Integer) null;//won't be needed most likely
	}
	
	/**
	 * returns the endResult String, which stores the updated equation 
	 * @return endResult
	 */
	public String getEndResult()
	{
		return result;
	}
	
	//pattern that identifies alphabetical characters as variables in the equation
	private static final Pattern VAR = Pattern.compile("[a-zA-Z].*?");
	
}
