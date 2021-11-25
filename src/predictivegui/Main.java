package predictivegui;
import java.awt.*;
import javax.swing.*;

/**
 * Main class to run GUI
 */
public class Main {
	public static void main(String[] args) throws Exception {

		
		javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
   		PredictiveModel model = new PredictiveModel();
		PredictiveView view = new PredictiveView();
		PredictiveController controller = new PredictiveController(model, view);

		controller.initView("Predictive Text");
	}
}
