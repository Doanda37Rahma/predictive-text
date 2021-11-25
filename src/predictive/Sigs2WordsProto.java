package predictive;

/**
 * 
 * This is a command-line program for calling the signatureToWords method
 * that exists in the PredictivePrototype class
 *
 * Input - 843 3486377 4726 72237 8378 47 2 6858478243 2376242 22722489 8378 8428 7764737748359 4387 6673 343342858 27 48 266846837 843 8378 47 8733 86 6327873 2 7883368 7 2376242 22722489 27 7278 63 843 3486377 4726 2773776368 78833687 786 2225 263 36784 27 6269 84637 27 8439 226 3224 527 74462533 29 2 2337 76863
 * Execution time : 20.97584500 seconds
 */
public class Sigs2WordsProto {
	
	public static void main(String[] args) {


		for (int i=0; i<args.length; i++) {
			System.out.println(args[i] + " : " + PredictivePrototype.signatureToWords(args[i]));
		}
	}
}
