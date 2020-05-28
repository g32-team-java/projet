package projet.view.benevoles;

import java.util.List;

import javax.inject.Inject;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import jfox.javafx.view.IManagerGui;
import projet.view.EnumView;
import projet.dao.DaoBenevoles;
import projet.data.Benevoles;
import projet.data.Personne;

public class ControllerDetailsBenevoles {
@Inject
private IManagerGui			managerGui;
@Inject
private ModelBenevoles modelBenevoles;

	@FXML
	private Button Retour;
	@FXML
	private Button Modifier;
	@FXML
	private Button Supprimer;
	
	@FXML
	private CheckBox permis;
	@FXML
	private CheckBox majeur;
	
	@FXML
	private ListView<String> Details;
	
	@FXML
	private ListView<Benevoles>	listViewBenevoles;
	
	@FXML
	private void initialize() {
		Details.setItems(modelBenevoles.getDetails());
		List<Boolean> bools = modelBenevoles.getBools();
		if(bools.get(0)) majeur.setSelected(true);
		if(bools.get(1)) permis.setSelected(true);
		Details.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {configurerBoutons();});
		configurerBoutons();
	}
	
	@FXML
	private void toBenevoles() {
		managerGui.showView(EnumView.Benevoles);
	}
	
	@FXML
	private void modifierBenevole() {
		//DaoBenevoles.modifier(?);
	}
	
	@FXML
	private void supprimerBenevole() {
		//DaoBenevoles.supprimer();
		ObservableList<Benevoles> selectedItems = listViewBenevoles.getSelectionModel().getSelectedItems();
		for ( int i = selectedItems.size() - 1; i >= 0; --i ) {
			modelBenevoles.supprimer( selectedItems.get(i) );
		}
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
