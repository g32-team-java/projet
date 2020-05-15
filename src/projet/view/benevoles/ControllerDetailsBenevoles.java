package projet.view.benevoles;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import jfox.javafx.view.IManagerGui;
import projet.view.EnumView;
import projet.data.Benevoles;

public class ControllerDetailsBenevoles {
@Inject
private IManagerGui			managerGui;
@Inject
private ModelDetailsBenevoles modelDetailsBenevoles;

	@FXML
	private Button Retour;
	@FXML
	private Button Modifier;
	@FXML
	private Button Supprimer;
	
	@FXML
	private ListView<Benevoles> Details;
	
	
	@FXML
	private void initialize() {
		Details.setItems(modelDetailsBenevoles.getDetails());
		Details.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {configurerBoutons();});
		configurerBoutons();
	}
	
	@FXML
	private void toBenevoles() {
		managerGui.showView(EnumView.Benevoles);
	}
	
	@FXML
	private void modifierBenevole() {
		Benevoles item = Details.getSelectionModel().getSelectedItem();
		
	}
	
	@FXML
	private void supprimerBenevole() {
		
	}
	
	private void configurerBoutons() {
		
    	if( Details.getSelectionModel().getSelectedItems().isEmpty() ) {
			Modifier.setDisable(true);
			Supprimer.setDisable(true);
		} else {
			Modifier.setDisable(false);
			Supprimer.setDisable(false);
		}
	}
}
