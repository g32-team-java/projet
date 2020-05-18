package projet.view.participants;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import jfox.javafx.util.ConverterStringInteger;
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

	@Inject
	private IManagerGui		managerGui;
	@Inject
	private ModelParticipant		modelParticipant;

	
	@FXML
	private void initialize() {
		
		Participants courant = modelParticipant.getCourant();
		
		tf_nom.textProperty().bindBidirectional( courant.nomProperty() );
		
		tf_prenom.textProperty().bindBidirectional( courant.prenomProperty() );
		
		tf_adresse.textProperty().bindBidirectional( courant.adresseProperty() );
		
		tf_cp.textProperty().bindBidirectional( courant.cpProperty(), new ConverterStringInteger() );
	
		
		tf_ville.textProperty().bindBidirectional( courant.villeProperty() );
		
		tf_telephone.textProperty().bindBidirectional( courant.telephoneProperty(),  new ConverterStringInteger());
		
	//	tf_mail.textProperty().bindBidirectional( courant.mailProperty() );
		
		
		
	}
	

}
