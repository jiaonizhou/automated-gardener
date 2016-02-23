package garden;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class HumanGardenerViewController {
	@FXML
	private TextField sprinklerInterval;	
	@FXML
	private TextField heaterInterval;
	@FXML
	private TextField pesticideInterval;
	@FXML
	private TextField fertilizerInterval;
	@FXML
	private Button updateButton;
	
	@FXML
    private void initialize() {
		Garden garden = Garden.getGarden();
		
		//sprinklerInterval.setText(garden.);
	}
}
