package projet.view.benevoles;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import projet.commun.IMapper;
import projet.dao.DaoBenevoles;
import projet.data.Benevoles;

public class ModelDetailsBenevoles {

	private final ObservableList<String> details = FXCollections.observableArrayList(); 
	private final Benevoles courant = new Benevoles();
	private final ObservableList<Boolean> bools=FXCollections.observableArrayList();
	
	
// Autres champs
    @Inject
	private IMapper			mapper;
    @Inject
	private DaoBenevoles	daoBenevoles;
    
// Getters
 	public ObservableList<String> getDetails() {
 		return details;
 	}
 	public ObservableList<Boolean> getBools(){
 		return bools;
 	}
 	public Benevoles getCourant() {
 		return courant;
 	}
 	
 //Actualisations
 	public void actualiserListe() {
 		List<Benevoles> LB = daoBenevoles.lister();
 		String id = LB.get(0).getId().toString();
 		String nom = LB.get(0).getNom();
 		String prenom = LB.get(0).getPrenom();
 		String mail = LB.get(0).getMail();
 		String tel = LB.get(0).getTelephone().toString();

 		Boolean permis = LB.get(0).getPermis();
 		Boolean majeur = LB.get(0).getMajeur();
 		
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
 	
 	@PostConstruct
 	public void init() {
 		actualiserListe();
 	}
 	
}
