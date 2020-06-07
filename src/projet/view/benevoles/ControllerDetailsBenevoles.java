package projet.view.benevoles;

import javax.inject.Inject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
	private Button Bmajeur;
	@FXML
	private Button Bpermis;
	
	@FXML
	private CheckBox permis;
	@FXML
	private CheckBox majeur;

	@FXML
	private TextField Nom;
	@FXML
	private TextField Prenom;
	@FXML
	private TextField Telephone;
	@FXML
	private TextField Poste;
	

	@FXML
	private void initialize() {
		Benevoles courant = modelBenevoles.getCourant();
		
		Nom.textProperty().bindBidirectional(courant.nomProperty());
		Prenom.textProperty().bindBidirectional(courant.prenomProperty());
		Telephone.textProperty().bindBidirectional(courant.telephoneProperty(), new ConverterStringInteger() );
		Poste.textProperty().bindBidirectional(courant.posteProperty());
		
		majeur.selectedProperty().bind(courant.majeurProperty());
		permis.selectedProperty().bind(courant.permisProperty());
		
		Bmajeur.setOpacity(0);
		Bpermis.setOpacity(0);
		
	}

	@FXML
	private void doPermis() {
		modelBenevoles.getCourant().setPermis(!modelBenevoles.getCourant().getPermis());
	}
	
	@FXML
	private void doMajeur() {
		modelBenevoles.getCourant().setMajeur(!modelBenevoles.getCourant().getMajeur());
	}
	
	@FXML
	private void toBenevoles() {
		managerGui.showView(EnumView.Benevoles);
	}
	
	@FXML
	private void modifierBenevole() {
		if(!modif) {					//passe en mode modification
			modif=true;
			
			Nom.setDisable(false);
			Prenom.setDisable(false);
			Telephone.setDisable(false);
			
			Bmajeur.setOpacity(1);
			Bpermis.setOpacity(1);
			Bmajeur.setDisable(false);
			Bpermis.setDisable(false);
			
			Retour.setDisable(true);
			Modifier.setText("Valider");
			Supprimer.setText("Annuler");
		}
		else {							//valide la modification
			modif=false;				
			
			Nom.setDisable(true);
			Prenom.setDisable(true);
			Telephone.setDisable(true);
			
			Bmajeur.setOpacity(0);
			Bpermis.setOpacity(0);
			Bmajeur.setDisable(true);
			Bpermis.setDisable(true);

			Retour.setDisable(false);
			Modifier.setText("Modifier");
			Supprimer.setText("Supprimer");
			modelBenevoles.getCourant().setTelephone(Integer.parseInt(Telephone.getText()));
			modelBenevoles.modifier(modelBenevoles.getCourant());
			managerGui.showView(EnumView.Benevoles);
		}
	}
	
	public void refresh() {
		modelBenevoles.infoActualiserBenevoles(modelBenevoles.getCourant());
	}
	
	@FXML
	private void supprimerBenevole() {
		if(modif) {						//annule la modification
			modif=false;
			
			Nom.setDisable(true);
			Prenom.setDisable(true);
			Telephone.setDisable(true);
			
			Bmajeur.setOpacity(0);
			Bpermis.setOpacity(0);
			Bmajeur.setDisable(true);
			Bpermis.setDisable(true);
			
			Retour.setDisable(false);
			Modifier.setText("Modifier");
			Supprimer.setText("Supprimer");
		}
		else {
			modelBenevoles.supprimer(modelBenevoles.getCourant());
			managerGui.showView(EnumView.Benevoles);
		}
		
	}
	

}
