package predictivegui;


/**
 * Controller for predictive text GUI
 *
 */
public class PredictiveController {

	private PredictiveModel model;
	private PredictiveView view;

	public PredictiveController(PredictiveModel model, PredictiveView view) {
		this.model = model;
		this.view = view;
	}
	
	public void initView(String title) {
		view.init(title, model);
	}	
}
