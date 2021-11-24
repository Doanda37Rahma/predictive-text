package predictive;

/**
 * 
 * This is a command-line program for calling the signatureToWords method
 * that exists in the DictionaryMapImpl class
 *
 */

public class Sigs2WordsMap {
	public static void main(String[] args) {

		Dictionary dict = new DictionaryMapImpl();

		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i] + ": " + dict.signatureToWords(args[i]));
		}
	}
}
