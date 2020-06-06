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
	private Button b_Afficher;
	@FXML
	private ListView<Participants> lv_ListeInscrits;


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
		lv_ListeInscrits.setItems(modelParticipant.getListe());
		lv_ListeInscrits.setCellFactory( UtilFX.cellFactory( item -> item.getNom() ) );

		lv_ListeInscrits.getSelectionModel().selectedItemProperty().addListener(
				(obs, oldVal, newVal) -> {
					configurerBoutons();
				});
		configurerBoutons();
	}
	
	public void refresh() {
		modelParticipant.actualiserListeInscrits();
		UtilFX.selectInListView( lv_ListeInscrits, modelParticipant.getCourant() );
		lv_ListeInscrits.requestFocus();
	}
	
	@FXML
	private void doAfficher() {
		Participants item =  lv_ListeInscrits.getSelectionModel().getSelectedItem();
		if ( item == null ) {
			managerGui.showDialogError( "Aucun élément n'est sélectionné dans la liste.");
		} else {
			modelParticipant.preparerModifier(item);
			managerGui.showView( EnumView.AffichageInscrit);
		}
	}
	
	@FXML
	private void gererClicSurListe( MouseEvent event ) {
		if (event.getButton().equals(MouseButton.PRIMARY)) {
			if (event.getClickCount() == 2) {
				if ( lv_ListeInscrits.getSelectionModel().getSelectedIndex() == -1 ) {
					managerGui.showDialogError( "Aucun élément n'est sélectionné dans la liste.");
				} else {
					doAfficher();
				}
			}
		}
	}

	private void configurerBoutons() {

		if( lv_ListeInscrits.getSelectionModel().getSelectedItems().isEmpty() ) {
			b_Afficher.setDisable(true);

		} else {
			b_Afficher.setDisable(false);

		}
	}


}
