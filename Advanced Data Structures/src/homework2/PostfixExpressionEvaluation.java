package homework2;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

public class PostfixExpressionEvaluation {
	
	private Stack<Integer> store;
	private int endNum;
	private boolean error;
	private String errorMessage;
	
	public PostfixExpressionEvaluation(String postEq)
	{
		Scanner input = new Scanner(postEq);//scanner for postEq string
		error = false;//error initialized to false
		String next;//string to store strings
		store = new Stack<Integer>(); //stack used to evaluate
		
		while (input.hasNext() )
		{
			if (input.hasNext(INT))//if the next String is not an operator, its an int, so it is pushed to the stack
			{
				next = input.next();
				store.push(new Integer(next));  //converts the String to an Integer and pushs it to the Stack
			}
			else//next string is an operator
			{
				next = input.next();
				calculate(next);
			}	
		}
	}
	
	/**
	 * when the input is an operator for this postfix expression this method calls the Stack store 
	 * and performs the neccesary operations based on the mathmatical function of the parameter
	 * @param op
	 */
	private void calculate(String op)
	{
		//integer division test
		int operand1, operand2;
		//java formatting issues
		if(op.equals("+"))
		{
			operand2 = store.pop(); 
			operand1 = store.pop();
			int answer =  (operand1 + operand2); //addition
			store.push(answer);
		}
		else if(op.equals("-"))
		{
			operand2 = store.pop();
			operand1 = store.pop();
			int answer = (operand1 - operand2); //subtraction
			store.push(answer);
		}
		else if(op.equals("*"))
		{
			operand2 = store.pop();
			operand1 = store.pop();
			int answer = (operand1 * operand2);  //multiplication
			store.push(answer);
		}
		else if(op.equals("/"))
		{
			int answer;
			operand2 = store.pop();
			operand1 = store.pop();
			if (operand2 != 0)//tests that the divisor is not zero
			{
				answer = (operand1 / operand2);  //division
				store.push(answer);
			}
			else//if division by zero sets error to true and creates an error message
			{
				error = true;
				errorMessage = "Error: division by zero";
			}
		}
		else if(op.equals("_"))
		{
			operand1 = store.pop();
			int answer = (operand1 * -1); //unary negation
			store.push(answer);
		}
		else if(op.equals("!"))
		{
			operand1 = store.pop();
			if (operand1 > 0)//tests if operand1 is greater than 0
			{
				int answer = factorial(operand1);	//factorial
				store.push(answer);
			}
			else//sets error to true and creates error message
			{
				error = true;
				errorMessage = "Error: Cannot take the factorial of a negative number";
			}
		}
		else if(op.equals("#"))
		{
			operand1 = store.pop();
			if(operand1 >= 0)//tests if operand1 is positive
			{
				int answer = (int) Math.sqrt(operand1); 	//square root
				store.push(answer);
			}
			else//sets error to true and creates errorMessage
			{
				error = true;
				errorMessage = "Error: Cannot take the square root of a negative number";
			}
		}
		else if(op.equals("^"))
		{
			operand2 = store.pop();
			operand1 = store.pop();
			int answer = (int) Math.pow(operand1, operand2);	//operand1 ^ operand2
			store.push(answer);
		}//logical operators return 1 for true and 0 for false
		else if(op.equals("<"))
		{
			operand2 = store.pop();
			operand1 = store.pop();
			if(operand1 < operand2)
				store.push(1);
			else
				store.push(0);
		}
		else if(op.equals("<="))
		{
			operand2 = store.pop();
			operand1 = store.pop();
			if(operand1 <= operand2)
				store.push(1);
			else
				store.push(0);
		}
		else if(op.equals(">"))
		{
			operand2 = store.pop();
			operand1 = store.pop();
			if(operand1 > operand2)
				store.push(1);
			else
				store.push(0);
		}
		else if(op.equals(">="))
		{
			operand2 = store.pop();
			operand1 = store.pop();
			if(operand1 >= operand2)
				store.push(1);
			else
				store.push(0);
		}
		else if(op.equals("=="))
		{
			operand2 = store.pop();
			operand1 = store.pop();
			if(operand1 == operand2)
				store.push(1);
			else
				store.push(0);
		}
		else if(op.equals("!="))
		{
			operand2 = store.pop();
			operand1 = store.pop();
			if (operand1 != operand2)
				store.push(1);
			else
				store.push(0);
		}//tests values as zero
		else if(op.equals("&&"))
		{
			operand2 = store.pop();
			operand1 = store.pop();
			if (operand1 != 0 && operand2 != 0)
				store.push(1);
			else
				store.push(0);
		}
		else if(op.equals("||"))
		{
			operand2 = store.pop();
			operand1 = store.pop();
			if (operand1 != 0 || operand2 != 0)
				store.push(1);
			else
				store.push(0);
		}
		else if(op.equals("$"))//signals the end of the equation
		{
			if (store.size() != 1)//if the store is not only one number, it is an illegal expression
			{
				System.out.println("Illegal input expression");
				return;
			}
			endNum = store.pop();//makes the endNum field variable the remaining item in the store stack
			return;
		}
		else //op is not a valid operator
			throw new IllegalArgumentException("Not a valid operator or operand");
	}
	
	/**
	 * calculates the factorial value of n
	 * @param n
	 * @return fact
	 */
	private int factorial(int n)
	{
        int fact = 1; // this will be the result
        for (int i = 1; i <= n; i++) 
            fact *= i;
        return fact;
	}
	
	/**
	 * returns the endNum that stores the result of the 
	 * @return int
	 */
	public int getEndNum()
	{
		return endNum;
	}
	
	public boolean containsError()
	{
		return error;
	}
	
	public String getErrorMessage()
	{
		return errorMessage;
	}
	
	//creates an int pattern for the Scanner to detect
	private static final Pattern INT = Pattern.compile("[+-]?\\d+.*?");
	

}