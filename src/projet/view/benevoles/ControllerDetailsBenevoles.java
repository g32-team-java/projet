package projet.view.benevoles;

import javax.inject.Inject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import jfox.javafx.util.ConverterStringInteger;
import jfox.javafx.view.IManagerGui;
import projet.data.Benevoles;
import projet.view.EnumView;

public class ControllerDetailsBenevoles {
@Inject
private IManagerGui			managerGui;
@Inject
private ModelBenevoles modelBenevoles;

	boolean modif=false;

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
	private TextField Id;
	@FXML
	private TextField Nom;
	@FXML
	private TextField Prenom;
	@FXML
	private TextField Telephone;

	@FXML
	private void initialize() {
		Benevoles courant = modelBenevoles.getCourant();
		
		Id.textProperty().bindBidirectional(courant.idProperty(), new ConverterStringInteger() );
		Nom.textProperty().bindBidirectional(courant.nomProperty());
		Prenom.textProperty().bindBidirectional(courant.prenomProperty());
		Telephone.textProperty().bindBidirectional(courant.telephoneProperty(), new ConverterStringInteger() );
	
		majeur.selectedProperty().bind(courant.majeurProperty());
		permis.selectedProperty().bind(courant.permisProperty());
	}

	@FXML
	private void toBenevoles() {
		managerGui.showView(EnumView.Benevoles);
	}
	
	@FXML
	private void modifierBenevole() {
		if(!modif) {					//passe en mode modification
			modif=true;
			Telephone.setDisable(false);
			Modifier.setText("Valider");
			Supprimer.setText("Annuler");
		}
		else {
			modif=false;				//valide la modification
			Telephone.setDisable(true);
			Modifier.setText("Modifier");
			Supprimer.setText("Supprimer");
			modelBenevoles.getCourant().setTelephone(Integer.parseInt(Telephone.getText()));
			modelBenevoles.modifier(modelBenevoles.getCourant());
		}
	}
	
	@FXML
	private void supprimerBenevole() {
		if(modif) {						//annule la modification
			modif=false;
			Nom.setDisable(true);
			Prenom.setDisable(true);
			Telephone.setDisable(true);
			Modifier.setText("Modifier");
			Supprimer.setText("Supprimer");
		}
		else {
			modelBenevoles.supprimer(modelBenevoles.getCourant());
		}
	}
}
