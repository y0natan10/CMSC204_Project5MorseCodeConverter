//Yonatan Rubin
//M21105076

/*
 * A generic linked binary tree which inherits from the LinkedConverterTreeInterface.
 * The class uses an external generic TreeNode class parameterized as a 
 * String: TreeNode<String>.  This class uses the private member of root.  
 * Nodes are added based on their morse code value.  
 * A ‘.’ (dot) means to traverse left and a ‘-‘ (dash) means to traverse right. 
 * The constructor will call the method to build the tree.
 * Follow the Javadoc that is provided. 
 * The Javadoc only lists those public methods that are required to pass the Junit tests.  
 * You may add any private methods you need for your design.
 */
import java.util.ArrayList;

/**
 * This is a MorseCodeTree which is specifically used for the conversion of
 * morse code to english It relies on a root (reference to root of the tree)
 * 
 * The root is set to null when the tree is empty.
 * 
 * The class uses an external generic TreeNode class which consists of a
 * reference to the data and a reference to the left and right child. The
 * TreeNode is parameterized as a String, TreeNode This class uses a private
 * member root (reference to a TreeNode)
 * 
 * The constructor will call the buildTree
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {

	TreeNode<String> root;
	// my eyes aren't good enough to tell the . and - apart
	// but i can read LEFT vs RIGHT
	private final char LEFT = '.';
	private final char RIGHT = '-';

	public MorseCodeTree() {
		this.root = new TreeNode<String>("");
		buildTree();
	}

	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {

		// see if we finished the code
		if (code.length() == 1) {
			if (code.charAt(0) == LEFT) {
				// don't add to a null node
				if (root.getLeft() == null) {
					root.setLeft(new TreeNode<String>(""));
				}
				root.getLeft().setData(letter);
			} else if (code.charAt(0) == RIGHT) {
				if (root.getRight() == null) {
					root.setRight(new TreeNode<String>(""));
				}
				root.getRight().setData(letter);
			}
			return;
			// cannot use 'this.root'
			// since that would refer to the one and only root of the main tree
		}

		// we're not at the end of the code, need to keep traversing
		if (code.charAt(0) == LEFT) {
			// cannot traverse to a null node
			if (root.getLeft() == null) {
				root.setLeft(new TreeNode<String>(""));
			}
			// .substring(1) takes everything from the 2nd letter to the end
			this.addNode(root.getLeft(), code.substring(1), letter);
		} else if (code.charAt(0) == RIGHT) {
			if (root.getRight() == null) {
				root.setRight(new TreeNode<String>(""));
			}
			this.addNode(root.getRight(), code.substring(1), letter);
		} else {
			// if we managed to get here that means the argument string 'e' has an invalid
			// character aka not a . or -
			throw new InvalidCodeException("Code can only contain . or -");
		}

	}

	@Override
	public void buildTree() {
		// was there a better way to do this
		this.insert(".-", "a");
		this.insert("-...", "b");
		this.insert("-.-.", "c");
		this.insert("-..", "d");
		this.insert(".", "e");
		this.insert("..-.", "f");
		this.insert("--.", "g");
		this.insert("....", "h");
		this.insert("..", "i");
		this.insert(".---", "j");
		this.insert("-.-", "k");
		this.insert(".-..", "l");
		this.insert("--", "m");
		this.insert("-.", "n");
		this.insert("---", "o");
		this.insert(".--.", "p");
		this.insert("--.-", "q");
		this.insert(".-.", "r");
		this.insert("...", "s");
		this.insert("-", "t");
		this.insert("..-", "u");
		this.insert("...-", "v");
		this.insert(".--", "w");
		this.insert("-..-", "x");
		this.insert("-.--", "y");
		this.insert("--..", "z");
		// i hated this with a burning passion
		// i know professors like when their students suffer
		// but man this was incredibly painful
		// good job
	}

	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Cannot delete from the MorseCodeTree");
	}

	@Override
	public String fetch(String code) {
		// all letters have a code length of 4 or less
		// if the code is longer than 4, there was a mistake
		if (code.length() > 4) {
			throw new UnsupportedOperationException("Code length must be 4 or less");
		}

		return this.fetchNode(this.root, code);
	}

	@Override
	public String fetchNode(TreeNode<String> root, String e) {
		// similar logic as addNode

		// see if we finished the code
		// checking null because the code might be a valid length
		// but it might lead to a place that doesn't exist
		if (e.length() == 1) {
			if (e.charAt(0) == LEFT && root.getLeft() != null) {
				return (String) root.getLeft().getData();
			} else if (e.charAt(0) == RIGHT && root.getRight() != null) {
				return (String) root.getRight().getData();
			}
			// if the length is 1 but LEFT and RIGHT are both null,
			// then we will be trying to traverse to a node that doesn't exist
			return null;
		}

		// sliiiiiiide to the left
		if (e.charAt(0) == LEFT) {
			if (root.getLeft() == null) {
				return null; // path ends before the code does
			}
			return this.fetchNode(root.getLeft(), e.substring(1));
		}

		// sliiiiiiide to the right
		else if (e.charAt(0) == RIGHT) {
			if (root.getRight() == null) {
				return null; // path ends before the code does
			}
			return this.fetchNode(root.getRight(), e.substring(1));
		}

		// CRISS CROSS
		// if we managed to get here that means the argument string 'e' has an invalid
		// character aka not a . or -
		throw new InvalidCodeException("Code can only contain . or -");
	}

	@Override
	public TreeNode<String> getRoot() {
		return this.root;
	}

	@Override
	public void insert(String code, String result) {
		// all letters have a code length of 4 or less
		// if the code is longer than 4, there was a mistake in the input
		if (code.length() > 4) {
			throw new UnsupportedOperationException("Code length must be 4 or less");
		}
		this.addNode(this.root, code, result);
	}

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if (root == null) {
			return;
		}
		this.LNRoutputTraversal(root.getLeft(), list);
		// can't use this because the test cases expect there to be an extra space
		// if (!root.getData().equals("")) {
		list.add(root.getData());

		this.LNRoutputTraversal(root.getRight(), list);
	}

	@Override
	public void setRoot(TreeNode<String> newNode) {
		this.root = new TreeNode<String>(newNode);
	}

	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> res = new ArrayList<String>();
		this.LNRoutputTraversal(root, res);
		return res;
	}

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Cannot update from the MorseCodeTree");
	}

}
