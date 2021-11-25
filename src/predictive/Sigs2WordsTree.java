package predictive;

import java.util.Set;


/**
 * 
 * This is a command-line program for calling the signatureToWords method
 * that exists in the DictionaryTreeImpl class
 *
 * 3.6412612 seconds. 2.1178942 s to store words and prefixes, 1.523367 s to retrieve them
 */
public class Sigs2WordsTree {
	public static void main(String[] args) {

		Dictionary dict = new DictionaryTreeImpl("words.txt");

		
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i] + ": " + dict.signatureToWords(args[i]));
		}
	}
}