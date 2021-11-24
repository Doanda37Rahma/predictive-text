package predictive;

public class WordSig implements Comparable<WordSig> {
	
	private String word;
	private String signature;
	
	/**
	 * Construct the signature-word pair
	 * 
	 * @param word The word 
	 * @param signature The signature
	 */
	public WordSig(String word, String signature) {
		this.word = word;
		this.signature = signature;
	}
	
	/**
	 * Compares current word signature object to target object
	 * 
	 * @param ws Word sig to be compared
	 * @return -1 if current object is less, 1 if more, 0 if equal;
	 */
	@Override
	public int compareTo(WordSig ws) {
		
		int lengthDiff = this.getSignature().length() - ws.getSignature().length();

		if (lengthDiff != 0) 
			return (lengthDiff < 0 ? -1 : 1);

		for (int i = 0; i < this.getSignature().length(); i++) {
			if (this.getSignature().charAt(i) > ws.getSignature().charAt(i)) 
				return 1;
			else if (this.getSignature().charAt(i) < ws.getSignature().charAt(i)) 
				return -1;
		}
		
		return 0;
	}

	/**
	 * Gets the signature
	 * 
	 * @return The signature
	 */
	public String getSignature() {
		return this.signature;
	}

	/**
	 * Gets the word
	 * 
	 * @return The word
	 */
	public String getWord() {
		return this.word;
	}
}
