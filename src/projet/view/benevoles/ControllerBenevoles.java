package projet.view.benevoles;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import jfox.javafx.view.IManagerGui;
import projet.view.EnumView;

public class ControllerBenevoles {
@Inject
private IManagerGui			managerGui;

	@FXML
	private Button Participants;
	
	@FXML
	private Button Accueil;
	
	@FXML
	private void toParticipants() {
		managerGui.showView( EnumView.Participants );
	}
	
	@FXML
	private void toAccueil() {
		managerGui.showView( EnumView.Accueil );
	}
}
