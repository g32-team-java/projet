package projet.view.participants;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import jfox.javafx.util.ConverterStringInteger;
import jfox.javafx.view.IManagerGui;
import projet.data.Participants;
import projet.view.EnumView;


public class ControllerInscritEntier {

	@FXML
	private Button b_Retour;
	@FXML
	private Label l_nom;
	@FXML
	private Label l_prenom;
	@FXML
	private Label l_adresse;
	@FXML
	private Label l_cp;
	@FXML
	private Label l_ville;
	@FXML
	private Label l_telephone;
	@FXML
	private Label l_mail;
	@Inject
	private IManagerGui		managerGui;
	@Inject
	private ModelParticipant		modelParticipant;
	
	
	public void initialize() {
		
		Participants courant = modelParticipant.getCourant();
		
		l_nom.setText(courant.getNom());
		l_prenom.setText(courant.getPrenom());
		l_adresse.setText(courant.getAdresse());
		l_cp.setText(""+courant.getCp());
		l_ville.setText(courant.getVille());
		l_telephone.setText(""+courant.getTelephone());
		l_mail.setText(courant.getMail());
				
	}
	
	@FXML
	private void toRetour() {
		
		managerGui.showView( EnumView.ListeInscrits);
	}
	
}
