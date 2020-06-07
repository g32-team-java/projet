package projet.view;

import javafx.scene.Scene;
import jfox.javafx.view.IEnumView;


public enum EnumView implements IEnumView {

	
	// Valeurs
	
	Info				( "systeme/ViewInfo.fxml" ),
	Connexion			( "systeme/ViewConnexion.fxml" ),
	CompteListe			( "compte/ViewCompteListe.fxml" ),
	CompteForm			( "compte/ViewCompteForm.fxml" ),
	Accueil				("accueil/ViewAccueil.fxml"),
	Participants		("participants/ViewParticipants.fxml"),
	AffichageInscrit    ("participants/ViewInscritEntier.fxml"),
	DemandeForm         ("participants/ViewAcceptdemande.fxml"),
	Statistiques        ("stats/ViewStats.fxml"),
	ListeDemandeInscrit ("participants/ViewListeDemandeInscrit.fxml"),
	ListeInscrits       ("participants/ViewListeInscrits.fxml"),
	Benevoles			("benevoles/ViewBenevoles.fxml"),
	DetailsBenevoles	("benevoles/ViewDetailsBenevoles.fxml"),
	Postes              ("poste/ViewListePoste.fxml"),
	DetailsPostes       ("poste/ViewDetailsPoste.fxml"),
	
	;

	
	// Champs
	
	private String		path;
	private Object		controller;
	private Scene		scene;

	
	// Constructeur 
	
	EnumView( String path ) {
		this.path = path;
	}

	
	// Getters & setters

	@Override
	public String getPath() {
		return path;
	}
	
	@Override
	public Object getController() {
		return controller;
	}

	@Override
	public void setController(Object controller) {
		this.controller = controller;
	}
	
	@Override
	public Scene getScene() {
		return scene;
	}
	
	@Override
	public void setScene(Scene scene) {
		this.scene = scene;
	}

}
