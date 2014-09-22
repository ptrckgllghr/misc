package homework4;

public class Node{
	
	public int element, numOfDuplicates;
	public Node left, right;
	
	/**
	 * takes an element and creates a node with null left and right values
	 * @param element
	 */
	public Node(int element)
	{
		this.element = element;
		left = null;
		right = null;
	}
	
	/**
	 * takes the element and a left and right node to create a node
	 * @param element
	 * @param left
	 * @param right
	 */
	public Node(int element, Node left, Node right)
	{
		this.element = element;
		this.left = left;
		this.right = right;
	}

	/**
	 * tests if the the Node is a leaf
	 * @return true/false
	 */
	public boolean isLeaf()
	{
		if (left == null && right == null)
			return true;
		return false;
	}
	
	public void addDuplicate()
	{
		numOfDuplicates++;
	}
	
}

