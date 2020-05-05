package projet.view.accueil;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import jfox.javafx.view.IManagerGui;
import projet.view.EnumView;

public class ControllerAccueil {
@Inject
private IManagerGui			managerGui;
	
	@FXML
	private Button Participants;
	
	@FXML
	private Button Benevoles;
	
	@FXML
	private void toParticipants() {
		managerGui.showView( EnumView.Participants );
	}
	
	@FXML
	private void toBenevoles() {
		managerGui.showView( EnumView.Benevoles );
	}
}
