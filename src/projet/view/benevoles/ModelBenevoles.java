package projet.view.benevoles;

import javax.inject.Inject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import projet.commun.IMapper;
import projet.dao.DaoBenevoles;
import projet.data.Benevoles;

public class ModelBenevoles {

	private final ObservableList<Benevoles> liste = FXCollections.observableArrayList(); 
	private final Benevoles courant = new Benevoles();
	
	
// Autres champs
    @Inject
	private IMapper			mapper;
    @Inject
	private DaoBenevoles	daoBenevoles;
    
// Getters
 	public ObservableList<Benevoles> getListe() {
 		return liste;
 	}

 	public Benevoles getCourant() {
 		return courant;
 	}
 	
// Actualisations
 	public void actualiserListe() {
 		liste.setAll( daoBenevoles.listerTout() );
  	}
}
