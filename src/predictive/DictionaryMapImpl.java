package predictive;

import java.io.*;
import java.util.*;


public class DictionaryMapImpl implements Dictionary {
	
	HashMap<String, Set<String>> map;
	
	
	/**
	 * constructor that takes a path to a dictionary and stores the
	 * dictionary in a hash map which maps each signature to a set of words
	 * hash map because lookup is more efficient
	 */
	public DictionaryMapImpl() {
		HashMap<String, Set<String>> hmap = new HashMap<String, Set<String>>();
		try { 
			File dictionary = new File("words.txt");
			Scanner scanner = new Scanner(dictionary);
			
			while (scanner.hasNextLine()) {
				
				//getting the word from file
				String word = scanner.nextLine().toLowerCase();
				if (isValidWord(word)) {
					String signature = wordToSignature(word);
					if (hmap.containsKey(signature)) {
						hmap.get(signature).add(word);
					} else {
						Set<String> newSet = new HashSet<String>();
						newSet.add(word);
						hmap.put(signature, newSet);
					}
				}	
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		this.map = hmap;
	}
	
	
	/**
	 * signatureToWords is a method that takes a given numeric signature and returns
	 * the corresponding set of words from the HashMap
	 * @param signature - a numeric signature
	 * @return the set of words corresponding to signature
	 */
	public Set<String> signatureToWords(String signature) {
		if (map.containsKey(signature)) {
			return map.get(signature);
		} else {
			Set<String> emptySet = new HashSet<String>();
			return emptySet;
		}		
	}
	

	
	/**
	 * wordToSignature is a method that takes a word and returns a numeric signature. 
	 * Any non-alphabetic characters produce a space.
	 * 
	 * @param word - a word
	 * @return the numeric signature of the word
	 */
	public String wordToSignature(String word) {
		StringBuffer stringBuffer = new StringBuffer("");
		
		word = word.toLowerCase();
		
		for (int i = 0; i < word.length(); i++) {
			stringBuffer.append(letterToNum(word.charAt(i)));
		}
		
		return stringBuffer.toString();
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
	
	/**
	 * isValidWord is a method that checks if a given word is valid or not
	 * @param word - a string 
	 * @return true if word is a valid word, false otherwise
	 */
	private static boolean isValidWord(String word) {
		for (int i = 0; i < word.length(); i++) {
			if (!Character.isLetter(word.charAt(i)))
				return false;
		}
		return true;	
	}
	

}