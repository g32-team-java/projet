package projet.view.benevoles;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jfox.javafx.util.UtilFX;
import projet.commun.IMapper;
import projet.dao.DaoBenevoles;
import projet.data.Benevoles;
import projet.view.systeme.ModelConfig;

public class ModelBenevoles {

	private final ObservableList<Benevoles> liste = FXCollections.observableArrayList(); 
	private final ObservableList<String> details = FXCollections.observableArrayList(); 
	private final Property<Boolean> majeur = new SimpleObjectProperty<Boolean>();
	private final Property<Boolean> permis = new SimpleObjectProperty<Boolean>();
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
 	
 	public Benevoles getCourant() {
 		return courant;
 	}
 	
 	public Property<Boolean> majeurProperty() {
		return majeur;
	}
 	
 	public Property<Boolean> permisProperty() {
		return permis;
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

 		permis.setValue(LB.getPermis());
 		majeur.setValue(LB.getMajeur());
 		
 		List<String> liste = new LinkedList<>();
 		liste.add(id);
 		liste.add(nom);
 		liste.add(prenom);
 		liste.add(mail);
 		liste.add(tel);
 		
 		details.setAll(liste);
 				
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
		Benevoles benevole = daoBenevoles.lister(item.getId());
		int idb = benevole.getId();
		daoBenevoles.supprimer(idb);
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
