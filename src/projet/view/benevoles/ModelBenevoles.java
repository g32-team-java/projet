package projet.view.benevoles;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jfox.javafx.util.UtilFX;
import projet.commun.IMapper;
import projet.dao.DaoBenevoles;
import projet.data.Benevoles;
import projet.data.Memo;
import projet.view.systeme.ModelConfig;

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
    @Inject
    private ModelConfig		modelConfig;
    
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
 	
 	public void actualiseLister(Benevoles item) {
 		Benevoles LB = daoBenevoles.lister(item.getId());
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
 		mapper.update(courant, daoBenevoles.lister(item.getId()));
 	}
 	 	
 	@PostConstruct
	public void init()
	{
		actualiserListe();
	}
 	
	public void supprimer( Benevoles item ) {
		
		daoBenevoles.supprimer( item.getId() );
		mapper.update( courant, UtilFX.findNext( liste, item ) );
		
		getFichierSchemaCourant().delete();
	}
	
	// Méthodes auxiliaires
	
	public File getFichierSchemaCourant() {
		String nomFichier = String.format( "%06d.jpg", courant.getId() );
		File dossierSchemas = modelConfig.getDossierSchemas();
		return new File( dossierSchemas, nomFichier );
	}
	
	
}
