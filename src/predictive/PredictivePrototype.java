package predictive;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * ÅgPrototypeÅh for the predictive text problem
 *
 */
public class PredictivePrototype {
	

	/**
	 * Converts a word into its corresponding signature
	 * in a cell phone keypad. We use StringBuffer because it is easier
	 * to construct by being able to append individual characters whereas
	 * String cannot
	 * 
	 * @param word
	 *            The word to be converted
	 * @return The signature
	 */
	public static String wordToSignature(String word) {
		StringBuffer stringBuffer = new StringBuffer("");
		
		word = word.toLowerCase();
		
		for (int i = 0; i < word.length(); i++) 
			stringBuffer.append(letterToNum(word.charAt(i)));
		
		return stringBuffer.toString();
	}
	
	/**
	 * Converts signature number into a potential list of strings
	 * it can represent
	 * 
	 * @param signature The signature to be converted
	 * @return The list of strings the signature can represent
	 */
	public static Set<String> signatureToWords(String signature) {
		
		Set<String> wordList = new HashSet<String>();
		
		try {
			// get the file
			File file = new File("words.txt");
			Scanner words = new Scanner(file);
			
			while (words.hasNextLine()) {
				
				// getting the word from file
				String word = words.nextLine().toLowerCase();
				
				// checking if the current line of word matches the signature
				if (wordSigMatches(word, signature))
					wordList.add(word);
			}
			words.close();

		} catch (FileNotFoundException e) {
			System.out.println("Error while reading the file \"words.txt\"");
			e.printStackTrace();
		}
		
		return wordList;
	}
	

	// Helper/utility methods
	

	/**
	 * Check if word matches signature
	 * @param word The word
	 * @param signature The signature
	 * @return Whether word matches signature
	 */
	public static boolean wordSigMatches(String word, String signature) {

		if (signature.length() != word.length() || !isValidWord(word))
			return false;

		// checks each corresponding letter in signature and word  
		for (int i = 0; i < signature.length(); ++i) {
			char left = 0, right = 0;
			switch (signature.charAt(i)) {
			case '2':
				left = 'a'; right = 'c'; break;
			case '3':
				left = 'd'; right = 'f'; break;
			case '4':
				left = 'g'; right = 'i'; break;
			case '5':
				left = 'j'; right = 'l'; break;
			case '6':
				left = 'm'; right = 'o'; break;
			case '7':
				left = 'p'; right = 's'; break;
			case '8':
				left = 't'; right = 'v'; break;
			case '9':
				left = 'w'; right = 'z'; break;
			}
			if (left > word.charAt(i) || right < word.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Returns whether the word is valid.
	 * 
	 * @param word
	 * @return Whether word is comprised of only alphabet
	 */
	private static boolean isValidWord(String word) {
		return word.matches("[a-zA-Z]+");
	}

	
	/**
	 * Converts letter to corresponding number in cell phone keypad
	 * 
	 * @param letter The letter to be converted
	 * @return Corresponding number, or space if not an alphabet
	 */
	public static String letterToNum(char letter) {
		if (letter >= 'a' && letter <= 'c') return "2";
		if (letter >= 'd' && letter <= 'f') return "3";
		if (letter >= 'g' && letter <= 'i') return "4";
		if (letter >= 'j' && letter <= 'l') return "5";
		if (letter >= 'm' && letter <= 'o') return "6";
		if (letter >= 'p' && letter <= 's') return "7";
		if (letter >= 't' && letter <= 'v') return "8";
		if (letter >= 'w' && letter <= 'z') return "9";
		return " ";
	}
	
}
