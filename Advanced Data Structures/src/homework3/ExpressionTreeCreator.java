package homework3;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

public class ExpressionTreeCreator {
	
	private Node root;
	
	public ExpressionTreeCreator(String postfix)
	{
		Scanner input = new Scanner(postfix);//scanner for postfix string
		String next;//string to store strings
		Stack<Node> store = new Stack<Node>(); //stack of Nodes used to create expression tree
		
		//creates the expression tree from the postfix string
		//establishes the root of the tree
		while(input.hasNext())
		{//while there are still tokens in the input
			if(input.hasNext(INT))
			{//if next is an integer
				next = input.next();//sets next to the next token
				Node operand = new Node(next);//creates a node with no references
				store.push(operand); //pushes the new Node to the stack
			}
			else//next is an operator
			{
				next = input.next();//sets next to the next token
				if (next.equals("$"))
				{//if next is the end character
					if(store.size() == 1)//if the stack is only one element, it is correct
						root = store.pop();//pop the remaining node, set it to be the root
					else
						System.out.println("Error in ExpressionTreeCreator");
					break;
				}
				else if(next.equals("!"))//special case for unary operation
				{
					Node r = store.pop();
					//creates a Node with a left value from the stack, but a null right Node to create a unary operation
					Node operator = new Node(next, null, r);
					store.push(operator);//pushes the new operator to the stack
				}
				else //normal case
				{
					Node r = store.pop();//pop the top, set it to be the right
					Node l = store.pop();//pop the 2nd, set it to be the left
					Node operator = new Node(next, l, r);//creates a new node with the operator as the value
					store.push(operator);//pushes the new operator to the stack
				}
			}//end else
		}//end while
	}//end constructor
	
	/**
	 * prints a sideways tree starting at the rightmost node, then to the root, then the left
	 * @param n
	 * @param depth
	 */
	private void printTree(Node n, int depth)
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
		
	/**
	 * recursive method that take the root and prints a fully parenthesized line to the screen
	 * @param n
	 */
	private void printInfix(Node n)
	{	
		if (n != null)//if n is not null
		{
			if (n.isLeaf())//if n is a leaf, therefore a number
				System.out.print(n.element);//print its element
			else//n is not a leaf
			{
				System.out.print("(");
				printInfix(n.left);
				System.out.print(" " + n.element + " ");
				printInfix(n.right);
				System.out.print(")");
			}//end else
		}//end if	
	}
	
	/**
	 * recursive method that calculates the value of the expression in the tree
	 * @param n
	 * @return int value of the expression
	 */
	private int evaluate(Node n)
	{
		if (n != null)
		{
			if (n.isLeaf())//n is a node with a number
				return Integer.parseInt(n.element);
			else//n contains an operator
			{
				int left = evaluate(n.left);//get the left value
				int right = evaluate(n.right);//get the right value
				return calculate(left, n.element, right);//calculate with the calculate method	
			}//end else
		}//end if
		else
			return 999999999;
	}//end evaluate
	
	/**
	 * calculates the value of two ints and a string value containing an operation
	 * @param l
	 * @param op
	 * @param r
	 * @return
	 */
	private int calculate(int l, String op, int r)
	{
		if (op.equals("+"))
			return l + r;
		else if(op.equals("-"))
			return l - r;
		else if(op.equals("*"))
			return l * r;
		else if(op.equals("/"))
			return l / r;
		else if(op.equals("%"))
			return l % r;
		else if(op.equals("^"))
			return (int) Math.pow(l, r);
		//logical, returns 1 or 0
		else if(op.equals("<"))
		{
			if(l < r)
				return 1;
			else
				return 0;
		}
		else if(op.equals(">"))
		{
			if(l > r)
				return 1;
			else
				return 0;
		}
		else if(op.equals("<="))
		{
			if(l <= r)
				return 1;
			else
				return 0;
		}
		else if(op.equals(">="))
		{
			if(l >= r)
				return 1;
			else
				return 0;
		}
		else if(op.equals("=="))
		{
			if (l == r)
				return 1;
			else
				return 0;
		}
		else if(op.equals("!="))
		{
			if(l != r)
				return 1;
			else
				return 0;
		}
		else if(op.equals("&&"))
		{
			if (l != 0 && r != 0)
				return 1;
			else
				return 0;
		}
		else if(op.equals("||"))
		{
			if(l != 0 || r != 0)
				return 1;
			else
				return 0;
		}
		else if(op.equals("!"))
		{
			if (r == 0)
				return 1;
			else
				return 0;
		}
		else
			return 9999999;//likely means an error in calculation error
	}//end calculate
	
	//creates an int pattern for the Scanner to detect
		private static final Pattern INT = Pattern.compile("[+-]?\\d+.*?");

	/**
	 * returns the root field
	 * @return root
	 */
	public Node getRoot()
	{
		return root;
	}
	
	/**
	 * prints a visual representation of the expression tree using the printTree method
	 */
	public void showTree()
	{
		printTree(root, 0);
	}
	
	/**
	 * takes the root of the tree and created a fully paranthesized infix expression
	 * by calling the printInfix method
	 */
	public void printInfixExpression()
	{
		printInfix(root);
	}
	
	/**
	 * evaluates the expression in the binary tree
	 * @return
	 */
	public int evaluateTree()
	{
		return evaluate(root);
	}
}
