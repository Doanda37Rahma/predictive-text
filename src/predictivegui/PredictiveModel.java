package predictivegui;

import predictive.*;
import predictive.Dictionary;
import predictive.DictionaryTreeImpl;

import java.util.*;

/**
 * Model for predictive text GUI
 *
 */
public class PredictiveModel extends Observable {
	
	private static Dictionary dict;
	private String text;
	private String currentWord;
	private String currentSig;
	private List<String> wordMatches;
	private List<String> sigs;
	private int index;
	
	PredictiveModel() {
		dict = new DictionaryTreeImpl("words.txt");
		text = "";
		currentWord = "";
		currentSig = "";
		wordMatches = new ArrayList<String>();
		sigs = new ArrayList<String>();
		index = 0;
	}
	
	public void handleKeyPress(char key) {
		// do nothing if 1 is pressed
		if (key == '1') {}
		// show next matching word if * is pressed
		else if (key == '*')
			nextWord();
		// make new word if 0 is pressed
		else if (key == '0') 
			newWord();
		// delete last letter of word if # is pressed
		else if (key == '#') 
			backSpace();
		// add to current signature if 2-9 is pressed
		else 
			addSig(key);
		
		// update the text field
		setChanged();
		notifyObservers(text + currentWord);
	}

	private void addSig(char key) {
		// appends key to current signature
		currentSig += key;
		
		setupWords();
	}

	private void setupWords() {
		// set words from signature and point index to first word
		wordMatches = new ArrayList<String>(dict.signatureToWords(currentSig));
		index = 0;
		
		setupCurrentWord();
	}

	private void setupCurrentWord() {
		// if word is found show it
		if (wordMatches.size() > 0)
			currentWord = wordMatches.get(index);
		// if not found show the current signature
		else
			currentWord = currentSig;
	}

	private void backSpace() {
		// if current signature isn't an empty string, remove last character
		if (currentSig.length() > 0) {
			currentSig = currentSig.substring(0, currentSig.length()-1);
			index = 0;
		}
		// if text field isn't empty and current signature is, then edit last completed signature
		else if (sigs.size() > 0) {
			currentSig = sigs.get(sigs.size() - 1);
			sigs.remove(sigs.size() - 1);
			
			text = text.substring(0, text.length() - currentSig.length() - 1);
		}

		setupWords();
	}

	private void newWord() {
		// store completed signature to array
		sigs.add(currentSig);
		
		// store completed word to text field only if word is not empty
		if (!currentWord.isEmpty()) 
			text += currentWord + " ";			

		// reset word, signature, and index
		currentWord = new String();	
		currentSig = new String();
		index = 0;
	}

	private void nextWord() {
		// if no signature, do nothing
		if (currentSig.length() == 0) 
			return;
		// go to next index or 0 if at the end
		index++;
		if (index >= wordMatches.size())
			index = 0;
		
		setupCurrentWord();
	}
	
	
	
	
	
}
