package predictive;

import java.io.*;
import java.util.*;

/**
 * Tree implementation of dictionary
 *
 */
public class DictionaryTreeImpl implements Dictionary {

    private static final Hashtable<Character, Integer> signatures = new Hashtable<Character, Integer>();
    private DictionaryTreeImpl[] children = new DictionaryTreeImpl[8];
    private Set<String> words = new HashSet<String>();

    // hashtable for word to signature
    static {
        signatures.put('a', 2);
        signatures.put('b', 2);
        signatures.put('c', 2);
        signatures.put('d', 3);
        signatures.put('e', 3);
        signatures.put('f', 3);
        signatures.put('g', 4);
        signatures.put('h', 4);
        signatures.put('i', 4);
        signatures.put('j', 5);
        signatures.put('k', 5);
        signatures.put('l', 5);
        signatures.put('m', 6);
        signatures.put('n', 6);
        signatures.put('o', 6);
        signatures.put('p', 7);
        signatures.put('q', 7);
        signatures.put('r', 7);
        signatures.put('s', 7);
        signatures.put('t', 8);
        signatures.put('u', 8);
        signatures.put('v', 8);
        signatures.put('w', 9);
        signatures.put('x', 9);
        signatures.put('y', 9);
        signatures.put('z', 9);
    }

    public DictionaryTreeImpl(String fileName) {
        BufferedReader readWords;
        try {
            readWords = new BufferedReader(new FileReader(fileName));
            String word;
            while ((word = readWords.readLine()) != null) {
                word = word.toLowerCase();
                if (isValidWord(word)) {
                    String signature = wordToSignature(word);
                    add(word, signature);
                }
            }
            readWords.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DictionaryTreeImpl() {
    }

    /**
     * Takes in a word and returns the numerical signature for that word.
     *
     * @param word
     * @return
     */
    @Override
    public String wordToSignature(String word) {
        // Creates new string buffer to hold the signature.
        StringBuffer buffer = new StringBuffer();

        // Converts the word to lower case.
        word = word.toLowerCase();

        // Loops through each letter in the word.
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);

            // Compares the letter with each case and appends corresponding number to buffer.
            if (signatures.containsKey(letter))
                buffer.append(signatures.get(letter));
            else
                buffer.append(" ");
        }
        // Return the string version of the buffer.
        return buffer.toString();
    }

    /**
     * Takes in a numerical signature and returns all possible words matching the numbers.
     *
     * @param signature
     * @return
     */
    @Override
    public Set<String> signatureToWords(String signature) {
        if (!isValidSignature(signature)) {
            return new HashSet<String>();
        }
        Set<String> results = new HashSet<String>();
        DictionaryTreeImpl node = getNode(signature);
        results.addAll(node.getChildWords(signature));
        results.addAll(node.words);
        return results;
    }

    /**
     * Gets trimmed words from children nodes
     * @param signature The signature
     * @return Words 
     */
    public Set<String> getChildWords(String signature) {
        Set<String> results = new HashSet<String>();
        for (DictionaryTreeImpl current :children) {
            if (current != null) {
                for (String word : current.words) {
                    results.add(word.substring(0, signature.length()));
                }
                results.addAll(current.getChildWords(signature));
            }
        }
        return results;
    }

    /**
     * Check if word is valid
     * @param word Word to be checked
     * @return Whether word is valid lowercase alphabet
     */
    private boolean isValidWord(String word) {
        for (char ch : word.toCharArray()) {
            if (ch < 'a' || ch > 'z') {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if signature is valid
     * @param signature Signature to be checked
     * @return Whether signature is valid
     */
    private boolean isValidSignature(String signature) {
        for (char ch : signature.toCharArray()) {
            if (ch < '2' || ch > '9') {
                return false;
            }
        }
        return true;
    }

    private void add(String word, String signature) {
        getNode(signature).words.add(word);
    }

    /**
     * Traverse from root to leaf node corresponding to the signature
     * @param signature The signature
     * @return Node corresponding to the signature
     */
    private DictionaryTreeImpl getNode(String signature) {
        DictionaryTreeImpl node = this;
        for (char ch : signature.toCharArray()) {
            node = node.getChild(ch);
        }
        return node;
    }

    /**
     * Gets the child of the current tree node
     * @param ch The index corresponding to next number in signature
     * @return Child of current tree node
     */
    private DictionaryTreeImpl getChild(char ch) {
        if (ch < '2' || ch > '9') {
            return null;
        }
        int index = ch - '2';
        if (children[index] == null) {
            children[index] = new DictionaryTreeImpl();
        }
        return children[index];
    }
}