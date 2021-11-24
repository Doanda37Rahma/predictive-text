package predictive;

public class Sigs2WordsTree {
	
	public static void main(String[] args) {

		Dictionary dict = new DictionaryTreeImpl();

		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i] + ": " + dict.signatureToWords(args[i]));
		}
	}
}
