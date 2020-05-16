package projet.view.participants;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import jfox.javafx.view.IManagerGui;
import projet.view.EnumView;

public class ControllerListeDemandeInscrit {
	@Inject
	private IManagerGui			managerGui;

	@FXML
	private Button b_Accueil;
	@FXML
	private Button b_ListeInscrits;
	@FXML
	private ListView lv_ListeDemande;


	@FXML
	private void toAccueil() {
		managerGui.showView( EnumView.Accueil );
	}

	@FXML
	private void toListeDemande() {
		managerGui.showView( EnumView.ListeInscrits);
	}



}	
