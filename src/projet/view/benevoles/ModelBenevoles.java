package projet.view.benevoles;

import java.util.LinkedList;
import java.util.List;

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
	private final ObservableList<String> details = FXCollections.observableArrayList(); 
	private final ObservableList<Boolean> bools=FXCollections.observableArrayList();
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
 	
 	public ObservableList<String> getDetails() {
 		return details;
 	}
 	
 	public ObservableList<Boolean> getBools(){
 		return bools;
 	}
 	
 	public Benevoles getCourant() {
 		return courant;
 	}
 	
// Actualisations
 	public void actualiserListe() {
 		liste.setAll( daoBenevoles.listerTout() );
 		
  	}
 	
 	public void actualiseLister() {
 		Benevoles LB = daoBenevoles.lister();
 		String id = LB.getId().toString();
 		String nom = LB.getNom();
 		String prenom = LB.getPrenom();
 		String mail = LB.getMail();
 		String tel = LB.getTelephone().toString();

 		Boolean permis = LB.getPermis();
 		Boolean majeur = LB.getMajeur();
 		
 		List<String> liste = new LinkedList<>();
 		liste.add(id);
 		liste.add(nom);
 		liste.add(prenom);
 		liste.add(mail);
 		liste.add(tel);
 		
 		List<Boolean> liste2 = new LinkedList<>();
 		liste2.add(majeur);
 		liste2.add(permis);
 		
 		details.setAll(liste);
 		bools.setAll(liste2);
 				
  	}
 	
 	public void preparerModifier(Benevoles item) {
 		mapper.update(courant, daoBenevoles.retrouverBenevoles(item.getId()));
 	}
 	
 	public void preparerLister(Benevoles item) {
 		mapper.update(courant, daoBenevoles.lister());
 	}
 	 	
 	@PostConstruct
	public void init()
	{
		actualiserListe();
		actualiseLister();
	}
 	
}
