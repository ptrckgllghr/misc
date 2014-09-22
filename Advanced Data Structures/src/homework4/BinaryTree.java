//Patrick Gallagher

package homework4;

/**
 * Implements a binary search tree with splay-tree functionality
 * Uses the Node class with an int value for the element
 * @author Patrick Gallagher
 *
 */
public class BinaryTree{

	private Node root;
	
	/**
	 *creates an empty binary tree
	 */
	public BinaryTree()
	{
		root = null;
	}
		
	/**
	 * Takes in an int value called x and adjusts the tree using the zig, zig-zig, and zig-zag methods
	 * @param x
	 */
	public void splay(int x)
	{
		//creates t, s and r Nodes as references to the root
		//t will traverse the tree searching for the Node with x as its element
		//s will follow t as it's parent
		//r will remain as a reference to the original root node
		Node t, r, s, parent;
		t = r = s = root;
		parent = null;; //parent Node to use when rotating, initialized to null
		
		while(true)//will run until the tree meets splay conditions, with the proper node as the new root
		{
			//if the root is null or the splay value, break from the loop
			if (r == null || r.element == x)
				break;
			//look to the left
			else if (t.left != null && x < t.element)//x is less than the element in t
			{
				//zig case
				if (x == t.left.element)
				{
					if (t == r)
					{// t is at the root
						t = rotateLeftChild(t);
						root = t;//the root is set to t 
						break;
					}
					else//t is further down in the tree
					{
						if (t == s.left) //t is the left of s
							s.left = rotateLeftChild(t);//rotate the left element to t's location
						else//t is the right of s
							s.right = rotateLeftChild(t);
						t = r; s = t;				 //set t back to the root, set s back to t
					}
				}//end if - zig case
				//zig-zig case
				else if(t.left.left != null && x == t.left.left.element)
				{
					parent = t.left;
					t.left = rotateLeftChild(parent); //rotate t.left.left to be t.left
					//zig case then enacted
				}
				//zig-zag case
				else if (t.left.right != null && x == t.left.right.element)
				{
					parent = t.left;
					t.left = rotateRightChild(parent);
					//zig case then enacted
				}
				else //x is further down the tree
				{
					s = t;
					t = t.left;
				}
			}//end else if - left
			
			//look right
			else if (t.right != null && x > t.element)
			{
				//zig case
				if (x == t.right.element)
				{
					if (t == r)
					{// t is at the root
						t = rotateRightChild(t);
						root = t;//the root is set to t 
						break;
					}
					else//t is further down in the tree
					{
						if (t == s.right)//if re-adjusting right node of s
							s.right = rotateRightChild(t);//rotate the left element to t's location
						else//t==s.left - if re-adjusting left node of s
							s.left = rotateRightChild(t);
						t = r; s = t;				 //set t back to the root, set s back to t
					}
				}//end if - zig case right
				//zig-zig case
				else if(t.right.right != null && x == t.right.right.element)
				{
					parent = t.right;
					t.right = rotateRightChild(parent); //rotate t.left.left to be t.left
					//zig case then enacted
				}
				//zig-zag case
				else if(t.right.left != null && x == t.right.left.element)
				{
					parent = t.right;
					t.right = rotateLeftChild(parent);
					//zig case then enacted
				}
				else //x is further down the tree
				{
					s = t;
					t = t.right;
				}
			}//end else if - right
			else//else if target is not found, next closest Node is made the root
			{
				//recursively calls a new splay for this element
				splay(t.element);
				break;
			}
		}//end while
	}//end splay

	/**
	 * inserts a node with the recusrive nsinsert method and then splays at that node
	 * @param x
	 */
	public void insert(int x)
	{
		nsinsert(x);//insert the value as a non-splay insert
		splay(x);	//splay the tree after, with the new value as the root
	}

	/**
	 * deletes the node with the value of x if it is in the tree
	 * @param x
	 * @return true/false
	 */
	public boolean delete(int x)
	{
		splay(x);			 //splay at x
		Node r = root;		//sets r to reference the root
		if (r == null)//if the tree is empty
			return false;
		else if (r.element == x)//if the root element is x after the splay
		{		
			if (root.left == null)
				root = root.right;// if there is no left tree, the root becomes the current roots right value
			else if (root.left.right == null)
			{//if the immediate left node of the root is the next highest value
				Node n = root.left;
				n.right = root.right;
				root = n;
			}
			else
			{
				Node leftMax = getMaxOfLeftTree();
				leftMax.left = r.left;
				leftMax.right = r.right;
				root = leftMax;
			}
			return true;//x Node is deleted successfully
		}
		else 
			return false;//x is not in the tree
	}

	/**
	 * searches for a value in the tree, if the tree contains it: true, otherwise: false
	 * @param x
	 * @return true/false
	 */
	public boolean search(int x)
	{
		splay(x);
		if (root.element == x)
			return true;
		return false;
	}

	/**
	 * inserts a value into the tree without using splay, ns for non-splay 
	 * @param value
	 */
	public void nsinsert(int value)
	{
		root = nsinsert(value, root);
	}
		
	/**
	 * makes the root null, therefore the tree empty
	 */
	public void makeEmpty()
	{
		root = null;
	}
	
	/**
	 * determines if the tree is empty
	 * @return true/false
	 */
	public boolean isEmpty()
	{
		return root == null;
	}
	
	/**
	 * returns the root of the BinaryTree
	 * @return
	 */
	public Node getRoot()
	{
		return root;
	}
		
	/**
	 * inserts a value x to a tree at root t without using splay, ns for non-splay
	 * @param x
	 * @param t
	 * @return
	 */
	private Node nsinsert(int x, Node t)
	{
		if(t == null)
			return new Node(x);//node isn't in the tree, a new one is created
		
		if(t.element > x)
			t.left = nsinsert(x, t.left);//move to the left node
		else if(t.element < x)
			t.right = nsinsert(x, t.right);//move to the right node
		else
			t.addDuplicate();//value already in tree, numOfDuplicates increased
	
		return t;//returns the node from the parameter
	}

	/**
	 * rotates a Node with it's left child
	 * @param n
	 * @return left Node
	 */
	private Node rotateLeftChild(Node n)
	{
		Node o = n.left;
		n.left = o.right;
		o.right = n;
		return o;
	}
	
	/**
	 *  rotates a Node with it's right child
	 * @param n
	 * @return right Node
	 */
	private Node rotateRightChild(Node n)
	{
		Node o = n.right;
		n.right = o.left;
		o.left = n;
		return o;
	}
	
	/**
	 * Takes the root of a tree and adjusts the tree to make the biggest Node in the left tree the new root
	 * @param r
	 * @return new root
	 */
	private Node getMaxOfLeftTree()
	{
		Node t = root.left;	//make a Node t, the root of the left tree
		if (t != null)
		{
			while (t.right != null)
				t = t.right;//moves t over to the right-most node of the tree
			Node s = root.left;
			if (s.right != null) //if there is 
			{
				while (s.right != t)
					s = s.right;   //s is set to be t's parent node
				s.right = t.left; //sets the left node of t to be the right node of s
			}
		return t; 		 //returns the node t
		}
		else
			return null; //return null if there is no left tree
	}//end getMaxOfLeftTree
	
}//end Binary Tree class
