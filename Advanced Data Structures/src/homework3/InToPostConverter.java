//Patrick Gallagher

package homework3;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

public class InToPostConverter {

	private String endResult; 
	
	/**
	 * takes in an infix expresssion and converts it to a postfix expression String called endResult
	 * @param infixEq
	 */
	public InToPostConverter(String infixEq)
	{
		Scanner input = new Scanner(infixEq);//scanner for infixEq string	
		StringBuilder sb = new StringBuilder(1000);//creates a stringBuilder with the capicity of 1000 characters
		String next;//string to store strings
		@SuppressWarnings("unused")
		String delete; //a string to send to the java garbage collector to store deleted items from the stack top
		Stack<String> store = new Stack<String>(); //stack used to evaluate

		while (input.hasNext())
		{
			if(input.hasNext(INT))
			{//put integer to output
				next = input.next();//next becomes the next token in input
				sb.append(next + " ");//adds the int to output
			}
			else//next is an operator
			{
				next = input.next();//next becomes the next token in input
				if (next.equals("$"))//tests for end character
				{	
					while(!store.isEmpty())
					{//pops the stack until it is empty
						sb.append(store.pop() + " ");//adds the operator to output	
					}
					sb.append("$");//appends the $ to the end
					break;
				}//1
				else if(next.equals("("))
				{//next is a ( and pushed to the stack
					store.push(next);//pushes next to the stack
				}//2
				else if(next.equals(")"))
				{//next equals )
					while (!store.peek().equals("("))
					{//while the stacktop is not left paren
						sb.append(store.pop() + " ");//adds the operator to output
					}//after the loop the stack top is (, which is deleted
					delete = store.pop();//delete stores the ( to be collected by garbage collector
				}//3
				else if(store.isEmpty() || store.peek().equals("("))//if stack is empty or top is left paran, push
				{//the stack is empty or the top is ( and the operator is pushed to the stack
					store.push(next);//pushes next to the stack
				}//4
				else if(testPrecedence(next) > testPrecedence(store.peek()))
				{//next has a higher precedence than the stack top
					store.push(next);//pushes next to the stack
				}//5
				else if(testPrecedence(next) <= testPrecedence(store.peek()))  
				{//next has a lower or equal precedence
					if((testPrecedence(next) == testPrecedence(store.peek())) && 
						(isRightAssoc(next) && isRightAssoc(store.peek())))
					{//exception for right to left associative operators
						store.push(next);
					}
					else//normal case
					{
						while (!store.isEmpty() && !store.peek().equals("("))
						{//while the stack is not empty or the stacktop is not a left paren
							if(testPrecedence(next) <= testPrecedence(store.peek()))
							{//if the next token is lower or equal precedence to the stack top
								sb.append(store.pop() + " ");//adds the operator to output
							}
							else {break;}//break out of the while loop when next has a lower precedence than the stack top
						}//end while
						store.push(next);//push next after completing the loop or if the stacktop is right-left assoc
					}//end else	
				}//end else if number 5
				else
					System.out.println("Error in InToPostConverter");
			}//end else
		}//end while
		endResult = sb.toString();//creates the endResult from the string builder
	}//end constructor
	
	/**
	 * determines the precedence of an operator, the higher the rank, the higher the precedence
	 * ! is 8
	 * ^ is 7
	 * *  /  % is 6
	 * + - is 5
	 * < <= > >= is 4
	 * == != is 3
	 * && is 2
	 * || is 1
	 * 0 for anything else
	 * @param token
	 * @return int
	 */
	private int testPrecedence(String token)
	{
		if (token.equals("!"))
			return 8;
		else if (token.equals("^"))
			return 7;
		else if(token.equals("*") || token.equals("/") || token.equals("%"))
			return 6;
		else if(token.equals("+") || token.equals("-"))
			return 5;
		else if(token.equals("<") || token.equals("<=") || token.equals(">") || token.equals(">="))
			return 4;
		else if(token.equals("==") || token.equals("!="))
			return 3;
		else if(token.equals("&&"))
			return 2;
		else if(token.equals("||"))
			return 1;
		else
			return 0;//0 means an error or some other item
	}//end testPrecendence
	
	/**
	 * tests if the value of a token is ! or ^, which are right to left associative
	 * @param token
	 * @return true/false
	 */
	private boolean isRightAssoc(String token)
	{
		if (token.equals("!") || token.equals("^"))
			return true;
		return false;
	}
	
	//creates an int pattern for the Scanner to detect
	private static final Pattern INT = Pattern.compile("[+-]?\\d+.*?");

	/**
	 * returns the endResult that stores the result of the the conversion
	 * @return String
	 */
	public String getEndResult() 
	{
		return endResult;
	}
}
