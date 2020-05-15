package projet.view.benevoles;

import javax.inject.Inject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import projet.commun.IMapper;
import projet.dao.DaoBenevoles;
import projet.data.Benevoles;

public class ModelDetailsBenevoles {

	private final ObservableList<Benevoles> details = FXCollections.observableArrayList(); 
	private final Benevoles courant = new Benevoles();
	
	
// Autres champs
    @Inject
	private IMapper			mapper;
    @Inject
	private DaoBenevoles	daoBenevoles;
    
// Getters
 	public ObservableList<Benevoles> getDetails() {
 		return details;
 	}

 	public Benevoles getCourant() {
 		return courant;
 	}
 	
 //Actualisations
 	public void actualiserListe() {
 		details.setAll( daoBenevoles.lister() );
  	}
}
