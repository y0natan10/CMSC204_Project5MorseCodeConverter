//Yonatan Rubin
//M21104076

/*
 * yoinked from the assignment sheet
 * The MorseCodeConverter contains a static MorseCodeTree object 
 * and constructs (calls the constructor for) the MorseCodeTree.
 * This class has two static methods convertToEnglish to convert from morse code to English. 
 * One method is passed a string object (“.-.. --- ...- . / .-.. --- --- -.- ...”).  
 * The other method is passed a file to be converted. 
 * These static methods use the MorseCodeTree to convert from morse code to English characters. 
 * Each method returns a string object of English characters. 
 * There is also a static printTree method that is used for testing purposes – to make sure the tree for MorseCodeTree was built properly.
 * Use the Javadoc provided to make sure that your MorseCodeConverter class follows the method headers so that the MorseCodeConverter Test will run correctly.
 */

import java.io.File;
import java.io.FileNotFoundException;

public class MorseCodeConverter {

	private static MorseCodeTree morseTree;

	public MorseCodeConverter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Converts a file of Morse code into English Each letter is delimited by a
	 * space (‘ ‘). Each word is delimited by a ‘/’. Example: a file that contains
	 * 
	 * ".... . .-.. .-.. --- / .-- --- .-. .-.. -.."
	 * 
	 * string returned = "Hello World"
	 * 
	 * @param codeFile - name of the File that contains Morse Code
	 * @return the English translation
	 * 
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		// TODO: whatever this is
		String res = "";
		return res;
	}

	/**
	 * Converts Morse code into English. Each letter is delimited by a space (‘ ‘).
	 * Each word is delimited by a ‘/’. Example: code =
	 * 
	 * ".... . .-.. .-.. --- / .-- --- .-. .-.. -.."
	 * 
	 * string returned = "Hello World"
	 * 
	 * @param code - the morse code
	 * @return the English translation
	 * 
	 */
	public static String convertToEnglish(String code) {
		// TODO: whatever this is
		String res = "";
		return res;
	}

	/**
	 * returns a string with all the data in the tree in LNR order with an space in
	 * between them.
	 * 
	 * Uses the toArrayList method in MorseCodeTree
	 * 
	 * It should return the data in this order:
	 * 
	 * "h s v i f u e l r a p w j b d x n c k y t z g q m o"
	 * 
	 * Note the extra space between j and b - that is because there is an empty
	 * string that is the root, and in the LNR traversal, the root would come
	 * between the right most child of the left tree (j) and the left most child of
	 * the right tree (b). This is used for testing purposes to make sure the
	 * MorseCodeTree has been built properly
	 * 
	 * @return the data in the tree in LNR order separated by a space.
	 */
	public static String printTree() {
		// TODO: whatever this is
		StringBuilder res = new StringBuilder("");
		return res.toString();
	}
}
