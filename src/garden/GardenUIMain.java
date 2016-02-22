package garden;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

import garden.GardenViewController;
import garden.Garden;

public class GardenUIMain extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		initRootLayout();
		showGardenView();
	}
	
	public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GardenUIMain.class.getResource("../RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
    public void showGardenView() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(GardenUIMain.class.getResource("../GardenView.fxml"));
            AnchorPane gardenView = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(gardenView);
            
            String image = GardenUIMain.class.getResource("../pics/grass.jpg").toExternalForm();
            rootLayout.setStyle("-fx-background-image: url('" + image + "'); " +
                       "-fx-background-position: center center; " +
                       "-fx-background-repeat: stretch;");
            
            GardenViewController controller = loader.getController();
            //controller.turnPalmHeater(true);
            
            new Garden(controller);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public static void main(String[] args) {
		launch(args);
	}
}
