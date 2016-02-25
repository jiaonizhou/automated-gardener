package garden;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;

public class LogViewController {
	@FXML
	private TabPane lagTabs;
	@FXML
	private Tab regularTab;
	@FXML
	private Tab randomTab;
	@FXML
	private Tab humanTab;
	@FXML
	private TextArea regularLog;
	@FXML
	private TextArea randomLog;
	@FXML
	private TextArea humanLog;
	
	@FXML
    private void initialize() {
		refresh();
	}
	
	public void refresh() {
		regularLog.setText(LogManager
				.getLogManager()
				.getRegularLogger()
				.logMessages());
		regularLog.appendText("");
		randomLog.setText(LogManager
				.getLogManager()
				.getRandomLogger()
				.logMessages());
		randomLog.appendText("");
		humanLog.setText(LogManager
				.getLogManager()
				.getHumanLogger()
				.logMessages());
		humanLog.appendText("");
	}
}
