package predictive;

import java.util.Set;

public interface Dictionary {

	/**
	 * Converts a word to its signature
	 * @param word The word to convert
	 * @return Signature of a the word, given as a string but will be integers
	 */
	public String wordToSignature(String word);
	
	/**
	 * Converts a word signature to a list of possible word found in the dictionary
	 * @param signature The signature to convert
	 * @return A list of word with the given signature, the type of the list does not matter
	 */
	public Set<String> signatureToWords(String signature);
}