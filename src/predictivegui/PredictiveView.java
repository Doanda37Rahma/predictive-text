package predictivegui;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * View for predictive text GUI
 *
 */
public class PredictiveView implements Observer, ActionListener{
	
	private PredictiveGUI panel = new PredictiveGUI();
	private PredictiveModel model;
	
	// button rows and columns
	private final int rows = 4;
	private final int cols = 3;

	// initialize view
	public void init(String title, PredictiveModel model) {
		this.model = model;
		
		// make frame
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// center frame on screen
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((int) screen.getWidth() / 2 - frame.getWidth() / 2,
			(int) screen.getHeight() / 2 - frame.getHeight() / 2);		
		
		// add observer and action listeners
		this.model.addObserver(this);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				panel.buttons[i][j].addActionListener(this);
			}
		}
		
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);		
	}
	
	// method to update the text field
	public void update(Observable o, Object arg) {
        if (o instanceof PredictiveModel) {
            	panel.setText("" + arg);
        }
    }
	// method to take action on click
	public void actionPerformed(ActionEvent e) {
		 String s = e.getActionCommand();
		 System.out.println("Action: " + s);
		 model.handleKeyPress(s.charAt(0));
	}
}
