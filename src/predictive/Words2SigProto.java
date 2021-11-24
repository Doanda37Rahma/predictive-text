package predictive;
import java.util.Arrays;

public class Words2SigProto {

	public static void main(String[] args) {
		
		System.out.print("input : ");
		System.out.print(Arrays.toString(args));
		System.out.println();

		System.out.print("output : ");
		for (int i = 0; i < args.length; i++) {
			System.out.print(PredictivePrototype.wordToSignature(args[i]) + " ");
		}
		System.out.println();
	}
}
