package projet.view.participants;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import jfox.javafx.view.IManagerGui;
import projet.view.EnumView;

public class ControllerParticipants {
@Inject
private IManagerGui			managerGui;
	
	@FXML
	private Button Accueil;
	@FXML
	private Button ListeDemande;
	@FXML
	private Button ListeInscrits;
	
	@FXML
	private void toAccueil() {
		managerGui.showView( EnumView.Accueil );
	}
	
	@FXML
	private void toListeInscrit() {
		managerGui.showView( EnumView.ListeInscrits);
	}
	
	@FXML
	private void toListeDemandes() {
		managerGui.showView( EnumView.ListeDemandeInscrit);
	}

}
