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
	@FXML
	private ImageView palmSprinkler;
	@FXML
	private ImageView deciduousSprinkler;
	@FXML
	private ImageView sunflowerSprinkler;
	@FXML
	private ImageView tulipSprinkler;
	@FXML
	private ImageView palmFertilizer;
	@FXML
	private ImageView deciduousFertilizer;
	@FXML
	private ImageView sunflowerFertilizer;
	@FXML
	private ImageView tulipFertilizer;
	@FXML
	private ImageView palmRandomEvent;
	@FXML
	private ImageView palmLadybug;
	@FXML
	private ImageView palmPesticide;
	@FXML
	private ImageView deciduousRandomEvent;
	@FXML
	private ImageView deciduousLadybug;
	@FXML
	private ImageView deciduousPesticide;
	@FXML
	private ImageView sunflowerRandomEvent;
	@FXML
	private ImageView sunflowerLadybug;
	@FXML
	private ImageView sunflowerPesticide;
	@FXML
	private ImageView tulipRandomEvent;
	@FXML
	private ImageView tulipLadybug;
	@FXML
	private ImageView tulipPesticide;
	
	
	public GardenViewController() {
    }
	
	@FXML
    private void initialize() {
    }
	
	public void turnPalmHeater(boolean on) {
		if (on) {
			Image img = new Image(getClass().getResource("../pics/heater-on.png").toExternalForm());
			palmHeater.setImage(img);
		} else {
			Image img = new Image(getClass().getResource("../pics/heater-off.png").toExternalForm());
			palmHeater.setImage(img);
		}
	}
	
	public void turnPalmSprinkler(boolean on) {
		if (on) {
			Image img = new Image(getClass().getResource("../pics/sprinkler-on.png").toExternalForm());
			palmSprinkler.setImage(img);
		} else {
			Image img = new Image(getClass().getResource("../pics/sprinkler-off.png").toExternalForm());
			palmSprinkler.setImage(img);
		}
	}
	
	public void turnPalmFertilizer(boolean on) {
		if (on) {
			Image img = new Image(getClass().getResource("../pics/fertilizer-on.png").toExternalForm());
			palmFertilizer.setImage(img);
		} else {
			Image img = new Image(getClass().getResource("../pics/fertilizer-off.png").toExternalForm());
			palmFertilizer.setImage(img);
		}
	}
	
	public void turnPalmRandomEvent(int n) {
		if (n == 1) {
			Image img = new Image(getClass().getResource("../pics/sunny.png").toExternalForm());
			palmRandomEvent.setImage(img);
		} else if (n == 2) {
			Image img = new Image(getClass().getResource("../pics/rainy.png").toExternalForm());
			palmRandomEvent.setImage(img);
		} else if (n == 3) {
			Image img = new Image(getClass().getResource("../pics/cold-day.png").toExternalForm());
			palmRandomEvent.setImage(img);
		} else if (n == 4) {
			Image img = new Image(getClass().getResource("../pics/hot-day.png").toExternalForm());
			palmRandomEvent.setImage(img);
		} else if (n == 5){
			Image img = new Image(getClass().getResource("../pics/pest.png").toExternalForm());
			palmRandomEvent.setImage(img);
		} else {
			Image img = new Image(getClass().getResource("../pics/normal.png").toExternalForm());
			palmRandomEvent.setImage(img);
		}
	}
	
	public void turnPalmPesticide(boolean on) {
		if (on) {
			Image img1 = new Image(getClass().getResource("../pics/ladybug.png").toExternalForm());
			palmLadybug.setImage(img1);
			Image img2 = new Image(getClass().getResource("../pics/pesticide.png").toExternalForm());
			palmPesticide.setImage(img2);
		} else {
			Image img1 = new Image(getClass().getResource("../pics/dove.png").toExternalForm());
			palmLadybug.setImage(img1);
			Image img2 = new Image(getClass().getResource("../pics/chipmunk.png").toExternalForm());
			palmPesticide.setImage(img2);
		}
	}
	
	public void turnDeciduousHeater(boolean on) {
		if (on) {
			Image img = new Image(getClass().getResource("../pics/heater-on.png").toExternalForm());
			deciduousHeater.setImage(img);
		} else {
			Image img = new Image(getClass().getResource("../pics/heater-off.png").toExternalForm());
			deciduousHeater.setImage(img);
		}
	}
	
	public void turnDeciduousSprinkler(boolean on) {
		if (on) {
			Image img = new Image(getClass().getResource("../pics/sprinkler-on.png").toExternalForm());
			deciduousSprinkler.setImage(img);
		} else {
			Image img = new Image(getClass().getResource("../pics/sprinkler-off.png").toExternalForm());
			deciduousSprinkler.setImage(img);
		}
	}
	
	public void turnDeciduousFertilizer(boolean on) {
		if (on) {
			Image img = new Image(getClass().getResource("../pics/fertilizer-on.png").toExternalForm());
			deciduousFertilizer.setImage(img);
		} else {
			Image img = new Image(getClass().getResource("../pics/fertilizer-off.png").toExternalForm());
			deciduousFertilizer.setImage(img);
		}
	}

	public void turnDeciduousRandomEvent(int n) {
		if (n == 1) {
			Image img = new Image(getClass().getResource("../pics/sunny.png").toExternalForm());
			deciduousRandomEvent.setImage(img);
		} else if (n == 2) {
			Image img = new Image(getClass().getResource("../pics/rainy.png").toExternalForm());
			deciduousRandomEvent.setImage(img);
		} else if (n == 3) {
			Image img = new Image(getClass().getResource("../pics/cold-day.png").toExternalForm());
			deciduousRandomEvent.setImage(img);
		} else if (n == 4) {
			Image img = new Image(getClass().getResource("../pics/hot-day.png").toExternalForm());
			deciduousRandomEvent.setImage(img);
		} else if (n == 5){
			Image img = new Image(getClass().getResource("../pics/pest.png").toExternalForm());
			deciduousRandomEvent.setImage(img);
		} else {
			Image img = new Image(getClass().getResource("../pics/normal.png").toExternalForm());
			deciduousRandomEvent.setImage(img);
		}
	}
	
	public void turnDeciduousPesticide(boolean on) {
		if (on) {
			Image img1 = new Image(getClass().getResource("../pics/ladybug.png").toExternalForm());
			deciduousLadybug.setImage(img1);
			Image img2 = new Image(getClass().getResource("../pics/pesticide.png").toExternalForm());
			deciduousPesticide.setImage(img2);
		} else {
			Image img1 = new Image(getClass().getResource("../pics/dove.png").toExternalForm());
			deciduousLadybug.setImage(img1);
			Image img2 = new Image(getClass().getResource("../pics/chipmunk.png").toExternalForm());
			deciduousPesticide.setImage(img2);
		}
	}
	
	public void turnSunflowerHeater(boolean on) {
		if (on) {
			Image img = new Image(getClass().getResource("../pics/heater-on.png").toExternalForm());
			sunflowerHeater.setImage(img);
		} else {
			Image img = new Image(getClass().getResource("../pics/heater-off.png").toExternalForm());
			sunflowerHeater.setImage(img);
		}
	}
	
	public void turnSunflowerSprinkler(boolean on) {
		if (on) {
			Image img = new Image(getClass().getResource("../pics/sprinkler-on.png").toExternalForm());
			sunflowerSprinkler.setImage(img);
		} else {
			Image img = new Image(getClass().getResource("../pics/sprinkler-off.png").toExternalForm());
			sunflowerSprinkler.setImage(img);
		}
	}
	
	public void turnSunflowerFertilizer(boolean on) {
		if (on) {
			Image img = new Image(getClass().getResource("../pics/fertilizer-on.png").toExternalForm());
			sunflowerFertilizer.setImage(img);
		} else {
			Image img = new Image(getClass().getResource("../pics/fertilizer-off.png").toExternalForm());
			sunflowerFertilizer.setImage(img);
		}
	}

	public void turnSunflowerRandomEvent(int n) {
		if (n == 1) {
			Image img = new Image(getClass().getResource("../pics/sunny.png").toExternalForm());
			sunflowerRandomEvent.setImage(img);
		} else if (n == 2) {
			Image img = new Image(getClass().getResource("../pics/rainy.png").toExternalForm());
			sunflowerRandomEvent.setImage(img);
		} else if (n == 3) {
			Image img = new Image(getClass().getResource("../pics/cold-day.png").toExternalForm());
			sunflowerRandomEvent.setImage(img);
		} else if (n == 4) {
			Image img = new Image(getClass().getResource("../pics/hot-day.png").toExternalForm());
			sunflowerRandomEvent.setImage(img);
		} else if (n == 5){
			Image img = new Image(getClass().getResource("../pics/pest.png").toExternalForm());
			sunflowerRandomEvent.setImage(img);
		} else {
			Image img = new Image(getClass().getResource("../pics/normal.png").toExternalForm());
			sunflowerRandomEvent.setImage(img);
		}
	}
	
	public void turnSunflowerPesticide(boolean on) {
		if (on) {
			Image img1 = new Image(getClass().getResource("../pics/ladybug.png").toExternalForm());
			sunflowerLadybug.setImage(img1);
			Image img2 = new Image(getClass().getResource("../pics/pesticide.png").toExternalForm());
			sunflowerPesticide.setImage(img2);
		} else {
			Image img1 = new Image(getClass().getResource("../pics/dove.png").toExternalForm());
			sunflowerLadybug.setImage(img1);
			Image img2 = new Image(getClass().getResource("../pics/chipmunk.png").toExternalForm());
			sunflowerPesticide.setImage(img2);
		}
	}
	
	public void turnTulipHeater(boolean on) {
		if (on) {
			Image img = new Image(getClass().getResource("../pics/heater-on.png").toExternalForm());
			tulipHeater.setImage(img);
		} else {
			Image img = new Image(getClass().getResource("../pics/heater-off.png").toExternalForm());
			tulipHeater.setImage(img);
		}
	}
	
	public void turnTulipSprinkler(boolean on) {
		if (on) {
			Image img = new Image(getClass().getResource("../pics/sprinkler-on.png").toExternalForm());
			tulipSprinkler.setImage(img);
		} else {
			Image img = new Image(getClass().getResource("../pics/sprinkler-off.png").toExternalForm());
			tulipSprinkler.setImage(img);
		}
	}
	
	public void turnTulipFertilizer(boolean on) {
		if (on) {
			Image img = new Image(getClass().getResource("../pics/fertilizer-on.png").toExternalForm());
			tulipFertilizer.setImage(img);
		} else {
			Image img = new Image(getClass().getResource("../pics/fertilizer-off.png").toExternalForm());
			tulipFertilizer.setImage(img);
		}
	}

	public void turnTulipRandomEvent(int n) {
		if (n == 1) {
			Image img = new Image(getClass().getResource("../pics/sunny.png").toExternalForm());
			tulipRandomEvent.setImage(img);
		} else if (n == 2) {
			Image img = new Image(getClass().getResource("../pics/rainy.png").toExternalForm());
			tulipRandomEvent.setImage(img);
		} else if (n == 3) {
			Image img = new Image(getClass().getResource("../pics/cold-day.png").toExternalForm());
			tulipRandomEvent.setImage(img);
		} else if (n == 4) {
			Image img = new Image(getClass().getResource("../pics/hot-day.png").toExternalForm());
			tulipRandomEvent.setImage(img);
		} else if (n == 5){
			Image img = new Image(getClass().getResource("../pics/pest.png").toExternalForm());
			tulipRandomEvent.setImage(img);
		} else {
			Image img = new Image(getClass().getResource("../pics/normal.png").toExternalForm());
			tulipRandomEvent.setImage(img);
		}
	}
	
	public void turnTulipPesticide(boolean on) {
		if (on) {
			Image img1 = new Image(getClass().getResource("../pics/ladybug.png").toExternalForm());
			tulipLadybug.setImage(img1);
			Image img2 = new Image(getClass().getResource("../pics/pesticide.png").toExternalForm());
			tulipPesticide.setImage(img2);
		} else {
			Image img1 = new Image(getClass().getResource("../pics/dove.png").toExternalForm());
			tulipLadybug.setImage(img1);
			Image img2 = new Image(getClass().getResource("../pics/chipmunk.png").toExternalForm());
			tulipPesticide.setImage(img2);
		}
	}
}
