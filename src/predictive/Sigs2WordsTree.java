package predictive;
import java.util.Set;



public class Sigs2WordsTree {
	public static void main(String[] args) {

		Dictionary dict = new DictionaryTreeImpl("words.txt");

		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i] + ": " + dict.signatureToWords(args[i]));
		}
	}
}
