package projet.view.benevoles;

import javax.inject.Inject;

import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import jfox.javafx.util.UtilFX;
import jfox.javafx.view.IManagerGui;
import projet.data.Benevoles;
import projet.data.Participants;
import projet.view.EnumView;

public class ControllerBenevoles {
@Inject
private IManagerGui			managerGui;
@Inject
private ModelBenevoles		modelBenevoles;

	@FXML
	private Button Accueil;
	@FXML
	private Button Details;
	
	
	@FXML
	private ListView<Benevoles> ListeBenevoles;
	
	@FXML
	private void toAccueil() {
		managerGui.showView( EnumView.Accueil );
	}
	@FXML
	private void toDetails() {
		managerGui.showView( EnumView.DetailsBenevoles);
	}
	
	
	@FXML
	private void initialize() {
		ListeBenevoles.setItems(modelBenevoles.getListe());
		ListeBenevoles.setCellFactory( UtilFX.cellFactory( item -> item.getNom() ) );
		ListeBenevoles.getSelectionModel().selectedItemProperty().addListener(
				(obs, oldVal, newVal) -> {
					configurerBoutons();
				});
		configurerBoutons();
	}

	public void refresh() {
		modelBenevoles.actualiserListe();
		UtilFX.selectInListView( ListeBenevoles, modelBenevoles.getCourant() );
		ListeBenevoles.requestFocus();
	}
	
	@FXML
	private void doModifier() {
		Benevoles item =  ListeBenevoles.getSelectionModel().getSelectedItem();
		if ( item == null ) {
			managerGui.showDialogError( "Aucun élément n'est sélectionné dans la liste.");
		} else {
			modelBenevoles.preparerModifier(item);
			managerGui.showView( EnumView.DetailsBenevoles );
		}
	}
		 
	@FXML
	private void gererClicSurListe( MouseEvent event ) {
		if (event.getButton().equals(MouseButton.PRIMARY)) {
			if (event.getClickCount() == 2) {
				if ( ListeBenevoles.getSelectionModel().getSelectedIndex() == -1 ) {
					managerGui.showDialogError( "Aucun élément n'est sélectionné dans la liste.");
				} else {
					doModifier();
				}
			}
		}
	}

	private void configurerBoutons() {

		if( ListeBenevoles.getSelectionModel().getSelectedItems().isEmpty() ) {
			Details.setDisable(true);

		} else {
			Details.setDisable(false);

		}
	}
}
