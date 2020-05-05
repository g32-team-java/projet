package projet.view.participants;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import jfox.javafx.view.IManagerGui;
import projet.view.EnumView;

public class ControllerParticipants {
@Inject
private IManagerGui			managerGui;
	
	@FXML
	private Button Accueil;
	
	@FXML
	private Button Benevoles;
	
	@FXML
	private void toAccueil() {
		managerGui.showView( EnumView.Accueil );
	}
	
	@FXML
	private void toBenevoles() {
		managerGui.showView( EnumView.Benevoles );
	}
}
