package projet.view.participants;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import jfox.javafx.util.UtilFX;
import jfox.javafx.view.IManagerGui;
import projet.view.EnumView;

public class ControllerListeDemandeInscrit {

	@Inject
	private IManagerGui			managerGui;

	@Inject 
	private ModelParticipant  modelParticipant;

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
	private void toListeInscrit() {
		managerGui.showView( EnumView.ListeInscrits);
	}

	@FXML
	private void initialize() {
		modelParticipant.actualiserListeDemandes();
		lv_ListeDemande.setItems(modelParticipant.getListe());
	}
	
	public void refresh() {
		modelParticipant.actualiserListeDemandes();
		UtilFX.selectInListView( lv_ListeDemande, modelParticipant.getCourant() );
		lv_ListeDemande.requestFocus();
	}



}	
