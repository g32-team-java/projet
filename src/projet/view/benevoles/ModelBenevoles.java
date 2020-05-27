package projet.view.benevoles;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
 	
 	public void preparerModifier(Benevoles item) {
 		mapper.update(courant, daoBenevoles.retrouverBenevoles(item.getId()));
 	}
 	
 	@PostConstruct
	public void init()
	{
		actualiserListe();
		//StringProperty nom = courant.nomProperty();
	}
 	
}
