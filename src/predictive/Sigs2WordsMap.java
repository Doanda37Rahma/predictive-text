package predictive;

/**
 * 
 * This is a command-line program for calling the signatureToWords method
 * that exists in the DictionaryMapImpl class
 *
 *  1.8617005 seconds. 1.8567037 s to store words, 0.0049968 to retreive words
 */
public class Sigs2WordsMap {
	public static void main(String[] args) {

		Dictionary dict = new DictionaryMapImpl();

		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i] + ": " + dict.signatureToWords(args[i]));
		}
	}
}
