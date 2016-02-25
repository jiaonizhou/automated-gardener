package garden;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class HumanGardenerViewController {
	@FXML
	private TextField period11;	
	@FXML
	private TextField period12;
	@FXML
	private TextField period21;
	@FXML
	private TextField period22;
	@FXML
	private TextField lowFreq;
	@FXML
	private TextField mediumFreq;
	@FXML
	private TextField highFreq;
	@FXML
	private Button updateButton;
	
	@FXML
    private void initialize() {
		Garden.getGarden();
		
		updateButton.setOnAction(new EventHandler<ActionEvent>() {
		    @Override public void handle(ActionEvent e) {
				GrowingPlan.period1 = Integer.parseInt(period11.getText());
				GrowingPlan.period2 = Integer.parseInt(period21.getText());
				GrowingPlan.lowFreq = Integer.parseInt(lowFreq.getText());
				GrowingPlan.mediumFreq = Integer.parseInt(mediumFreq.getText());
				GrowingPlan.highFreq = Integer.parseInt(highFreq.getText());
				
				LogManager.getLogManager().getHumanLogger().info("Growing plan changed to");
				updateButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
				     @Override
				     public void handle(MouseEvent event) {
				    	 Parent root;
					     try {
					         root = FXMLLoader.load(GardenUIMain.class.getResource("../Confirm.fxml"));
					         Stage stage = new Stage();
					         stage.setScene(new Scene(root, 400, 50));
					         stage.show();
					     } catch (IOException e) {
					        e.printStackTrace();
					     }
				     }
				});
		    }
		});
		
		period11.setOnKeyReleased(new EventHandler<KeyEvent>() {
		    @Override public void handle(KeyEvent e) {
		    	period12.setText(period11.getText());
		    }
		});
		
		period12.setOnKeyReleased(new EventHandler<KeyEvent>() {
		    @Override public void handle(KeyEvent e) {
		    	period11.setText(period12.getText());
		    }
		});
		
		period21.setOnKeyReleased(new EventHandler<KeyEvent>() {
		    @Override public void handle(KeyEvent e) {
		    	period22.setText(period21.getText());
		    }
		});
		
		period22.setOnKeyReleased(new EventHandler<KeyEvent>() {
		    @Override public void handle(KeyEvent e) {
		    	period21.setText(period22.getText());
		    }
		});
	}
}
