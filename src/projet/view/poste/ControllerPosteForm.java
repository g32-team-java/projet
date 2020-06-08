package projet.view.poste;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.util.converter.IntegerStringConverter;
import jfox.javafx.util.ConverterStringInteger;
import jfox.javafx.util.ConverterStringLocalTime;
import jfox.javafx.util.ListenerFocusValidation;
import jfox.javafx.view.IManagerGui;
import projet.data.Poste;
import projet.view.EnumView;


public class ControllerPosteForm {

	
	// Composants de la vue
	

	@FXML
	private TextField		tf_nom;
	@FXML
	private TextField		tf_nbPoste;
	@FXML
	private CheckBox		cb_majeur;
	
	@FXML
	private TextField tf_horaire_deb;
	@FXML
	private TextField tf_horaire_fin;
	
	@FXML
	private CheckBox		cb_membre;

	
	// Autres champs
	
	@Inject
	private IManagerGui		managerGui;
	@Inject
	private ModelPoste	modelPoste;


	// Initialisation du Controller

	@FXML
	private void initialize() {

		// Data binding
		
		Poste courant = modelPoste.getCourant();

		tf_nom.textProperty().bindBidirectional( courant.nomProperty() );
		
		tf_nbPoste.textProperty().bindBidirectional(courant.nbPosteProperty(), new IntegerStringConverter());
		
		cb_majeur.selectedProperty().bindBidirectional( courant.majeurProperty() );
		cb_membre.selectedProperty().bindBidirectional( courant.membreProperty() );
		
		tf_horaire_deb.textProperty().bindBidirectional(courant.heure_debutProperty(), new ConverterStringLocalTime());
		tf_horaire_fin.textProperty().bindBidirectional(courant.heure_finProperty(), new ConverterStringLocalTime());
	}
	
	// Actions
	
	@FXML
	private void doAnnuler() {
		managerGui.showView( EnumView.Postes );
	}
	
	@FXML
	private void doValider() {
		modelPoste.validerMiseAJour();
		managerGui.showView( EnumView.Postes );
	}
	
}
