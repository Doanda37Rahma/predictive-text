package predictive;

import java.util.Set;

/**
 * Interface for dictionary
 *
 */
public interface Dictionary {

	/**
	 * Converts a word into its corresponding signature
	 * in a cell phone keypad. 
	 * 
	 * @param word
	 *            The word to be converted
	 * @return The signature
	 */
	public String wordToSignature(String word);
	
	/**
	 * Converts signature number into a potential list of strings
	 * it can represent
	 * 
	 * @param signature The signature to be converted
	 * @return The list of strings the signature can represent
	 */
	public Set<String> signatureToWords(String signature);
}