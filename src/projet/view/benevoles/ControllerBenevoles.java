package projet.view.benevoles;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import jfox.javafx.util.UtilFX;
import jfox.javafx.view.IManagerGui;
import projet.data.Benevoles;
import projet.view.EnumView;

public class ControllerBenevoles {
@Inject
private IManagerGui			managerGui;
@Inject
private ModelBenevoles		modelBenevoles;

	@FXML
	private Button Accueil;
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
		modelBenevoles.actualiserListe();
		ListeBenevoles.setItems(modelBenevoles.getListe());
	}
	
	public void refresh() {
		modelBenevoles.actualiserListe();
		UtilFX.selectInListView( ListeBenevoles, modelBenevoles.getCourant() );
		ListeBenevoles.requestFocus();
	}
	
	// Clic sur la liste
		@FXML
		private void gererClicSurListe( MouseEvent event ) {
			if (event.getButton().equals(MouseButton.PRIMARY)) {
				if (event.getClickCount() == 2) {
					if ( ListeBenevoles.getSelectionModel().getSelectedIndex() == -1 ) {
						managerGui.showDialogError( "Aucun élément n'est sélectionné dans la liste.");
					} else {
						toDetails();
					}
				}
			}
		}
}
