package projet.view.participants;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import jfox.javafx.util.UtilFX;
import jfox.javafx.view.IManagerGui;
import projet.view.EnumView;

public class ControllerListeInscrits {
	@Inject
	private IManagerGui			managerGui;
	
	@Inject 
	private ModelParticipant  modelParticipant;

	@FXML
	private Button b_Accueil;
	@FXML
	private Button b_ListeDemande;
	@FXML
	private ListView lv_ListeInscrits;


	@FXML
	private void toAccueil() {
		managerGui.showView( EnumView.Accueil );
	}

	@FXML
	private void toListeDemande() {
		managerGui.showView( EnumView.ListeDemandeInscrit);
	}
	
	@FXML
	private void initialize() {
		modelParticipant.actualiserListeInscrits();
		lv_ListeInscrits.setItems(modelParticipant.getListe());
	}
	
	public void refresh() {
		modelParticipant.actualiserListeInscrits();
		UtilFX.selectInListView( lv_ListeInscrits, modelParticipant.getCourant() );
		lv_ListeInscrits.requestFocus();
	}


}
