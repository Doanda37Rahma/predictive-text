package predictive;
import java.io.*;
import java.util.*;

/**
 * List implementation of dictionary
 *
 */
public class DictionaryListImpl  implements Dictionary {

	private ArrayList<WordSig> wordSigList;

	/**
	 * Constructor stores the sorted dictionary 
	 */
	public DictionaryListImpl() {
		ArrayList<WordSig> newList = new ArrayList<WordSig>();
		try {
			// get words
			File file = new File("words.txt");
			Scanner words = new Scanner(file);
			
			while (words.hasNextLine()) {

				// getting the word from file
				String word = words.nextLine().toLowerCase();
				
				
				if (isValidWord(word))
					newList.add(new WordSig(word, wordToSignature(word)));
			}
			
			Collections.sort(newList);
			this.wordSigList = newList;
			
			words.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Error while reading the file \"words.txt\"");
			e.printStackTrace();
		}
	}
	
	
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
	public String wordToSignature(String word) {
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
	public Set<String> signatureToWords(String signature) {
		
		Set<String> wordList = new HashSet<String>();

		// finds any single index of object with matching signature
		int ind = binarySearch(wordSigList, signature);
		// alt: with built in binarySearch
		// int ind = Collections.binarySearch(wordSigList, new WordSig(null, signature));
		
		// if not found return empty list
		if (ind < 0) {
			System.out.println("Error couldn't find any matching word");
			return wordList;
		}
		
		// if found, go to first instance of matching words then add words until last instance
		while (ind >= 0 && wordSigList.get(ind).compareTo(new WordSig(null, signature)) == 0) 
			ind--;
		ind++;
		while (ind < wordSigList.size() && wordSigList.get(ind).compareTo(new WordSig(null, signature)) == 0) 
			wordList.add(wordSigList.get(ind++).getWord());
		
		return wordList;
}



	// Helper methods
	
	/**
	 * Binary search implementation of signature in pair
	 * 
	 * @param wslist The list of word signature
	 * @param sig The signature to be searched
	 * @return Index of object with signature sig
	 */
	public static int binarySearch(ArrayList<WordSig> wslist, String sig) {
		int l = 0;
		int r = wslist.size() - 1;
		
		while (l < r) {
			int m = l + (r - l) / 2;
			
			if (wslist.get(m).compareTo(new WordSig(null, sig)) == 0) return m;
			if (wslist.get(m).compareTo(new WordSig(null, sig)) < 0) l = m + 1;
			else r = m - 1;
		}
		
		return -1;
	}
	    
	/**
	 * Checks whether the word is valid.
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
