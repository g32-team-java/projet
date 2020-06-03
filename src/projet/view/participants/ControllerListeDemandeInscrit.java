package projet.view.participants;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import jfox.javafx.util.UtilFX;
import jfox.javafx.view.IManagerGui;
import projet.data.Participants;
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
	private Button b_Modifier;
	@FXML
	private ListView<Participants> lv_ListeDemande;


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
		lv_ListeDemande.setItems(modelParticipant.getListe());
		lv_ListeDemande.setCellFactory( UtilFX.cellFactory( item -> item.getNom() ) );

		lv_ListeDemande.getSelectionModel().selectedItemProperty().addListener(
				(obs, oldVal, newVal) -> {
					configurerBoutons();
				});
		configurerBoutons();
	}

	public void refresh() {
		modelParticipant.actualiserListeDemandes();
		UtilFX.selectInListView( lv_ListeDemande, modelParticipant.getCourant() );
		lv_ListeDemande.requestFocus();
	}

	@FXML
	private void doModifier() {
		Participants item =  lv_ListeDemande.getSelectionModel().getSelectedItem();
		if ( item == null ) {
			managerGui.showDialogError( "Aucun élément n'est sélectionné dans la liste.");
		} else {
			managerGui.showView( EnumView.DemandeForm );
		}
	}

	@FXML
	private void gererClicSurListe( MouseEvent event ) {
		if (event.getButton().equals(MouseButton.PRIMARY)) {
			if (event.getClickCount() == 2) {
				if ( lv_ListeDemande.getSelectionModel().getSelectedIndex() == -1 ) {
					managerGui.showDialogError( "Aucun élément n'est sélectionné dans la liste.");
				} else {
					doModifier();
				}
			}
		}
	}

	private void configurerBoutons() {

		if( lv_ListeDemande.getSelectionModel().getSelectedItems().isEmpty() ) {
			b_Modifier.setDisable(true);

		} else {
			b_Modifier.setDisable(false);

		}
	}

}	
