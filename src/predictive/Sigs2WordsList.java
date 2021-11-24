package predictive;

public class Sigs2WordsList {

	public static void main(String[] args) {
		
		Dictionary dict = new DictionaryListImpl();
		
		// TODO compare time
		
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i] + " : " + dict.signatureToWords(args[i]));
		}
	}

}
