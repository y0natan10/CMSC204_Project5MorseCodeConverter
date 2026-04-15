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
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {

	private static MorseCodeTree morseTree = new MorseCodeTree();

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
		StringBuilder res = new StringBuilder();
		Scanner scanner = new Scanner(codeFile);
		String line;

		// make sure to check there is a next line to grab
		while (scanner.hasNextLine()) {
			// grab the line
			line = scanner.nextLine();

			// call the method that takes in morse code in String form
			res.append(convertToEnglish(line));
			// can't use 'this.' because static :[
		}
		scanner.close();

		return res.toString();
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
		StringBuilder res = new StringBuilder();
		// step 1 is to split the whole code by the different words
		String[] words = code.split(" / ");
		// need the space on either side since that's how it appears in the code

		// now for each letter inside each word
		for (int i = 0; i < words.length; ++i) {
			String[] letters = words[i].split(" ");
			// add each letter of the word, aka add the word
			for (String letter : letters) {
				res.append(morseTree.fetch(letter));
			}
			// after adding the whole word, put a space at the end
			// so the next word can be seen
			res.append(" ");
		}

		// get rid of the extra space at the end
		return res.toString().trim();
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
		// use the existing method to turn morseTree to an ArrayList
		ArrayList<String> myList = morseTree.toArrayList();
		StringBuilder sb = new StringBuilder();
		// for each string (letter) in the tree, append it and add a space
		for (String s : myList) {
			sb.append(s).append(" ");
		}
		// can't use myList.toString() because that method puts
		// ', ' between each letter
		return sb.toString().trim();
		// need .trim() because one of the given test cases fails otherwise
	}
}
