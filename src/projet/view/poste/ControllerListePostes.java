package projet.view.poste;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import jfox.javafx.util.UtilFX;
import jfox.javafx.view.IManagerGui;
import projet.data.Participants;
import projet.data.Poste;
import projet.view.EnumView;

public class ControllerListePostes {
	
	@Inject
	private IManagerGui			managerGui;
	
	@Inject 
	private ModelPoste  modelPoste;

	@FXML
	private Button b_retour;
	
	@FXML
	private Button b_Supprimer;
	
	@FXML
	private Button b_Ajouter;
	
	@FXML
	private Button b_Modifier;
	
	
	@FXML
	private ListView<Poste> lv_ListePoste;


	@FXML
	private void toRetour() {
		managerGui.showView( EnumView.Accueil );
	}
	
	
	@FXML
	private void initialize() {
		lv_ListePoste.setItems(modelPoste.getListe());
		lv_ListePoste.setCellFactory( UtilFX.cellFactory( item -> item.getNom() ) );

		lv_ListePoste.getSelectionModel().selectedItemProperty().addListener(
				(obs, oldVal, newVal) -> {
					configurerBoutons();
				});
		configurerBoutons();
	}
	
	public void refresh() {
		modelPoste.actualiserListeInscrits();
		UtilFX.selectInListView( lv_ListePoste, modelPoste.getCourant() );
		lv_ListePoste.requestFocus();
	}
	
	@FXML
	private void doAjouter() {
		modelPoste.preparerAjouter();
		managerGui.showView( EnumView.DetailsPostes );
	}

	@FXML
	private void doModifier() {
		Poste item = lv_ListePoste.getSelectionModel().getSelectedItem();
		if ( item == null ) {
			managerGui.showDialogError( "Aucun élément n'est sélectionné dans la liste.");
		} else {
			modelPoste.preparerModifier(item);
			managerGui.showView( EnumView.DetailsPostes );
		}
	}

	@FXML
	private void doSupprimer() {
		Poste item = lv_ListePoste.getSelectionModel().getSelectedItem();
		if ( item == null ) {
			managerGui.showDialogError( "Aucun élément n'est sélectionné dans la liste.");
		} else {
			boolean reponse = managerGui.showDialogConfirm( "Confirmez-vous la suppresion ?" );
			if ( reponse ) {
				modelPoste.supprimer( item );
				refresh();
			}
		}
	}
	
	
	@FXML
	private void gererClicSurListe( MouseEvent event ) {
		if (event.getButton().equals(MouseButton.PRIMARY)) {
			if (event.getClickCount() == 2) {
				if ( lv_ListePoste.getSelectionModel().getSelectedIndex() == -1 ) {
					managerGui.showDialogError( "Aucun élément n'est sélectionné dans la liste.");
				} else {
					Poste item =  lv_ListePoste.getSelectionModel().getSelectedItem();
					System.out.println(item.getId());
				}
			}
		}
	}

	private void configurerBoutons() {

		if( lv_ListePoste.getSelectionModel().getSelectedItems().isEmpty() ) {
			b_Supprimer.setDisable(true);

		} else {
			b_Supprimer.setDisable(false);

		}
	}


}
