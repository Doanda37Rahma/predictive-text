package predictive;

/**
 * 
 * This is a command-line program for calling the signatureToWords method
 * that exists in the DictionaryListImpl class
 *
 * 3.3975016 seconds. 3.3875082 s to insert words, 0.0099934 s to retrieve words. 
 */
public class Sigs2WordsList {

	public static void main(String[] args) {
		
		Dictionary dict = new DictionaryListImpl();

		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i] + " : " + dict.signatureToWords(args[i]));
		}
	}

}
