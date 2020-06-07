package projet.view;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import jfox.javafx.view.IManagerGui;
import projet.commun.Roles;
import projet.data.Compte;
import projet.view.systeme.ModelConnexion;


public class MenuBarAppli extends MenuBar {

	
	// Champs
	
	private Menu	menuBenevoles;
	private Menu	menuParticipants;
	private Menu	menuPoste;
	
	private MenuItem itemDeconnecter;
	
	@Inject
	private IManagerGui 	managerGui;
	@Inject
	private ModelConnexion	modelConnexion;	
	
	
	// Initialisation
	
	@PostConstruct
	public void init() {

		
		// Variables de travail
		Menu menu;
		MenuItem item;
		
		
		// Manu Système
		
		menu =  new Menu( "Système" );;
		this.getMenus().add(menu);
		
		item = new MenuItem( "Se déconnecter" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.Connexion )  );
		menu.getItems().add( item );
		itemDeconnecter = item;
		
		item = new MenuItem( "Quitter" );
		item.setOnAction(  (e) -> managerGui.exit()  );
		menu.getItems().add( item );

		
		// Manu Données
		
		menu =  new Menu( "Benevoles" );;
		this.getMenus().add(menu);
		menuBenevoles = menu;
		
		item = new MenuItem( "Liste des Benevoles" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.Benevoles )  );
		menu.getItems().add( item );
		
		

		
		// Manu Etats
		
		menu =  new Menu( "Participants" );;
		this.getMenus().add(menu);
		menuParticipants = menu;
		
		item = new MenuItem( "Liste des participants inscrits " );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.ListeInscrits )  );
		menu.getItems().add( item );
		
		item = new MenuItem( "Liste des demandes d'inscription " );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.ListeDemandeInscrit )  );
		menu.getItems().add( item );
		
		item = new MenuItem( "Statistiques");
		item.setOnAction(  (e) -> managerGui.showView( EnumView.Statistiques )  );
		menu.getItems().add( item );

		
		menu =  new Menu( "Poste" );;
		this.getMenus().add(menu);
		menuPoste = menu;
		
		item = new MenuItem( "Liste des Postes" );
		item.setOnAction(  (e) -> managerGui.showView( EnumView.Postes )  );
		menu.getItems().add( item );
		
		// Configuration initiale du menu
		configurerMenu( modelConnexion.getCompteActif() );

		// Le changement du compte connecté modifie automatiquement le menu
		modelConnexion.compteActifProperty().addListener( (obs) -> {
					Platform.runLater( () -> configurerMenu( modelConnexion.getCompteActif() ) );
				}
			); 
		
	}

	
	// Méthodes auxiliaires
	
	private void configurerMenu( Compte compteActif  ) {

		itemDeconnecter.setDisable(true);
		
		menuBenevoles.setVisible(false);
		menuParticipants.setVisible(false);
		menuParticipants.setVisible(false);
		
		if( compteActif != null ) {
			itemDeconnecter.setDisable(false);
			if( compteActif.isInRole( Roles.UTILISATEUR) ) {
				menuBenevoles.setVisible(true);
				menuParticipants.setVisible(true);
			}
			if( compteActif.isInRole( Roles.ADMINISTRATEUR ) ) {
				menuBenevoles.setVisible(true);
			}
		}
	}
	
}
