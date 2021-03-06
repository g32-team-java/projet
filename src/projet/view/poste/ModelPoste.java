package projet.view.poste;

import javax.inject.Inject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import jfox.commun.exception.ExceptionValidation;
import jfox.javafx.util.UtilFX;
import projet.commun.IMapper;
import projet.dao.DaoPoste;
import projet.data.Poste;


public class ModelPoste {
	
	private ObservableList<Poste> liste = FXCollections.observableArrayList();
	
	private Poste courant = new Poste();
	
	@Inject
	private IMapper			mapper;
	@Inject
	private DaoPoste		daoPoste;
	
	
	public ObservableList<Poste> getListe() {
		return liste;
	}
	
	public Poste getCourant() {
		return courant;
	}
	
	public void actualiserListe() {
		liste.setAll(daoPoste.listerTout());
	}
	
	public void preparerAjouter() {
		mapper.update(courant, new Poste());
	}
	
	public void preparerModifier(Poste item) {
		mapper.update(courant, daoPoste.retrouver(item.getId()));
	}
	
	public void validerMiseAJour() {
		StringBuilder message = new StringBuilder();

		if( courant.getNom() == null || courant.getNom().isEmpty() ) {
			message.append( "\nLe nom ne doit pas être vide." );
		} else  if ( courant.getNom().length()> 50 ) {
			message.append( "\nLe nom est trop long : 50 maxi." );
		}
		if(courant.getHeure_debut() == null || courant.getHeure_fin() ==null ) {
			message.append( "\nLe format de l'horaire est HH:MM" );
		}
		
		if(courant.getMajeur() == null) {
			courant.setMajeur(false);
		}
		
		if(courant.getMembre() == null) {
			courant.setMembre(false);
		}
		
		if ( message.length() > 0 ) {
			throw new ExceptionValidation( message.toString().substring(1) );
		}
		
		if ( courant.getId() == null ) {
			// Insertion
			courant.setId( daoPoste.inserer( courant ) );
		}else {
			daoPoste.modifier(courant);
		}
	}
	
	public void actualiserListeInscrits() {
		liste.setAll( daoPoste.listerTout() );
	}
	
	public void supprimer( Poste item ) {
		
		daoPoste.supprimer( item.getId() );
		mapper.update( courant, UtilFX.findNext( liste, item ) );
	}

}
