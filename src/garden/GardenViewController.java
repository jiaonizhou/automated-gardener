package garden;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;


public class GardenViewController {
	@FXML
	private ImageView palmHeater;
	
	@FXML
	private ImageView deciduousHeater;
	
	@FXML
	private ImageView sunflowerHeater;
	
	@FXML
	private ImageView tulipHeater;
	
	public GardenViewController() {
    }
	
	@FXML
    private void initialize() {
    }
	
	public void turnPalmHeater(boolean on) {
		if (on) {
			Image img = new Image(getClass().getResource("../pics/heater-on.jpg").toExternalForm());
			palmHeater.setImage(img);
		} else {
			Image img = new Image(getClass().getResource("../pics/heater-off.png").toExternalForm());
			palmHeater.setImage(img);
		}
	}
}
