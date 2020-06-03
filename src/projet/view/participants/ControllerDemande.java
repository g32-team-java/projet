package projet.view.participants;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import jfox.javafx.util.ConverterStringInteger;
import jfox.javafx.util.UtilFX;
import jfox.javafx.view.IManagerGui;
import projet.data.Participants;
import projet.view.EnumView;
import projet.view.memo.ModelMemo;

public class ControllerDemande {

	

	@FXML
	private Button b_Accepter;
	@FXML
	private Button b_Refuser;
	@FXML
	private Button b_Retour;
	@FXML
	private TextField tf_nom;
	@FXML
	private TextField tf_prenom;
	@FXML
	private TextField tf_adresse;
	@FXML
	private TextField tf_cp;
	@FXML
	private TextField tf_ville;
	@FXML
	private TextField tf_telephone;
	@FXML
	private TextField tf_mail;
	@FXML
	private ListView<Participants> lv_ListeDemande;

	@Inject
	private IManagerGui		managerGui;
	@Inject
	private ModelParticipant		modelParticipant;
	
	
	public void initialize() {
		
		Participants courant = modelParticipant.getCourant();
		
		tf_nom.textProperty().bindBidirectional( courant.nomProperty() );
		tf_prenom.textProperty().bindBidirectional( courant.prenomProperty() );
		tf_adresse.textProperty().bindBidirectional( courant.adresseProperty() );
		tf_cp.textProperty().bindBidirectional( courant.cpProperty(), new ConverterStringInteger() );
		tf_ville.textProperty().bindBidirectional( courant.villeProperty() );
		tf_telephone.textProperty().bindBidirectional( courant.telephoneProperty(),  new ConverterStringInteger());
		
	//	tf_mail.textProperty().bindBidirectional( courant.mailProperty() );
		
	}
	
	@FXML
	private void toListeDemandeInscritpion() {
		managerGui.showView( EnumView.ListeDemandeInscrit);
	}
	
	@FXML
	private void addToBase() {
		// Ajoute à la BD le participant en passant ça variable participant/valider à true
		modelParticipant.preparerAjoutBase(modelParticipant.getCourant());
	}
	@FXML
	private void removeFromBase() {
		// Remove l'individu de la BD
		modelParticipant.supprimer(modelParticipant.getCourant());
	}

}
