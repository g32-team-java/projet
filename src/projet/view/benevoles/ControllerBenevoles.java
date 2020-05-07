package projet.view.benevoles;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import jfox.javafx.view.IManagerGui;
import projet.view.EnumView;

public class ControllerBenevoles {
@Inject
private IManagerGui			managerGui;

	@FXML
	private Button Accueil;
	@FXML
	private ListView ListeBenevoles;
	
	
	@FXML
	private void toAccueil() {
		managerGui.showView( EnumView.Accueil );
	}
}
