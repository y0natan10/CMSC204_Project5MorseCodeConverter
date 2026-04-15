//Yonatan Rubin
//M21105076

/*
 * Data Element - TreeNode This generic class is used in the MorseCodeTree
 * classes. The class consists of a reference to the data and a reference to the
 * left and right child. Follow the Javadoc that is provided. The Javadoc only
 * lists those public methods that are required to pass the Junit tests. You may
 * add any private methods you need for your design.
 *
 * above is copied from assignment sheet
 * next are methods from given javadoc
 * 
 * public TreeNode​(T dataNode)
 * Create a new TreeNode with left and right child set to null and data set to the dataNode
 * Parameters:
 * dataNode - the data to be stored in the TreeNode
 * 
 * TreeNode
 * public TreeNode​(TreeNode<T> node)
 * used for making deep copies
 * Parameters:
 * node - node to make copy of
 * 
 * getData
 * public T getData()
 * Return the data within this TreeNode
 * Returns:
 * the data within the TreeNode
 * 
 */

/**
 * Simple objects that represents a node in a tree
 * 
 * @param <T> the type of data stored within a node
 */
public class TreeNode<T> {
	private T data;
	private TreeNode<T> left;
	private TreeNode<T> right;

	/**
	 * Create a new TreeNode with left and right child set to null and data set to
	 * the dataNode
	 * 
	 * @param dataNode, the data to be stored in the TreeNode
	 */
	public TreeNode(T dataNode) {
		this.setData(dataNode);
		this.left = this.right = null;
	}

	/**
	 * used for making deep copies
	 * 
	 * @param node, node to make copy of
	 */
	public TreeNode(TreeNode<T> node) {
		this.setData(node.getData());
		// do not want to make a deep copy of a null node
		// if the node we are copying has a null child,
		// leave that child null in the new copy
		// but if the copied node's child is not null,
		// recursively call the deep copy constructor so we copy the whole subtree
		this.left = (node.left == null) ? null : new TreeNode<>(node.left);
		this.right = (node.right == null) ? null : new TreeNode<>(node.right);
	}

	/**
	 * Return the data within this TreeNode
	 * 
	 * @return the data within the TreeNode
	 * 
	 */
	public T getData() {
		return this.data;
	}

	// extra methods
	/**
	 * setter method for the private field 'data'
	 * 
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

	/**
	 * getter method for the private field 'right'
	 * 
	 * @return the right child of the calling node
	 */
	public TreeNode<T> getRight() {
		return this.right;
	}

	/**
	 * setter method for the private field 'right'
	 */
	public void setRight(TreeNode<T> _right) {
		this.right = _right;
	}

	/**
	 * getter method for the private field left
	 * 
	 * @return the left child of the calling node
	 */
	public TreeNode<T> getLeft() {
		return this.left;
	}

	/**
	 * setter method for the private field 'left'
	 */
	public void setLeft(TreeNode<T> _left) {
		this.left = _left;
	}

}
