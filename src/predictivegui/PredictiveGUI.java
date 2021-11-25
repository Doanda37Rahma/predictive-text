package predictivegui;

import java.awt.*;
import javax.swing.*;
import java.util.*;

/**
 * Class for GUI panel of Predictive Text
 */
public class PredictiveGUI extends JPanel{
	
	
	private JTextArea textArea;
	protected JButton[][] buttons;
	
	// button rows and columns
	private final int rows = 4;
	private final int cols = 3;
	
	/**
	 * Constructs the text and buttons components for the GUI
	 */
	PredictiveGUI() {
		// GUI layout
		GridLayout layout = new GridLayout(2, 1);
		setLayout(layout);
		
		// make panels
		JPanel textPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		// set 4 x 3 grid layout for buttons
		buttonPanel.setLayout(new GridLayout(rows, cols));
		
		// set text area
		textArea = new JTextArea();
		textArea.setPreferredSize(new Dimension(80*3, 40*4));
		
		// initialize each button contents
		buttons = new JButton[rows][cols];
		int key = 1;
		for (int i = 0; i < rows - 1; i++) {
			for (int j = 0; j < cols; j++) {
				String str;
				
				str = String.valueOf(key) + numToLetters(key);
				
				buttons[i][j] = new JButton(str);
				buttons[i][j].setActionCommand(String.valueOf(key));
				buttons[i][j].setPreferredSize(new Dimension(80, 40));
				
				key++;
			}
		}
		buttons[3][0] = new JButton("*");
		buttons[3][1] = new JButton("0 _");
		buttons[3][2] = new JButton("#");
		
		// wrap text area if too long to fit
		textArea.setLineWrap(true);
		
		// disable editing text field using computer keyboard
		textArea.setEditable(false);

		// add each button to the button component 
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				buttonPanel.add(buttons[i][j]);
			}
		}

		// add text field to the text component
		textPanel.add(textArea);
		
		// add components to GUI
		add(textPanel);
		add(buttonPanel);
	}
	
	/**
	 * Change text field content
	 * @param text The text
	 */
	public void setText(String text) {
		textArea.setText(text);
	}
	
	/**
	 * Helper method to turn a number into corresponding letters in cell phone keypad
	 * 
	 * @param num The number
	 * @return String in a cell phone keypad
	 */
	private String numToLetters(int num) {
		switch(num) {
		case 1:
			return "";
		case 2:
			return " abc";
		case 3:
			return " def";
		case 4:
			return " ghi";
		case 5:
			return " jkl";
		case 6:
			return " mno";
		case 7:
			return " pqrs";
		case 8:
			return " tuv";
		case 9:
			return " wxyz";
		}
		return "";
	}
	
}
