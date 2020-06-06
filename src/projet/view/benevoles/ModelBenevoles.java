package projet.view.benevoles;

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

public class ModelBenevoles {

	private final ObservableList<Benevoles> liste = FXCollections.observableArrayList();
	private final Benevoles courant = new Benevoles();

	
// Autres champs
	@Inject
	private IMapper mapper;
	@Inject
	private DaoBenevoles daoBenevoles;

// Getters
	public ObservableList<Benevoles> getListe() {
		return liste;
	}

	public Benevoles getCourant() {
		return courant;
	}

	
// Actualisations
	public void actualiserListe() {
		liste.setAll(daoBenevoles.listerTout());

	}

	public void preparerModifier(Benevoles item) {
		mapper.update(courant, daoBenevoles.retrouverBenevoles(item.getId()));
	}

	public void preparerLister(Benevoles item) {
		mapper.update(courant, daoBenevoles.lister(item.getId()));
	}

	@PostConstruct
	public void init() {
		actualiserListe();
	}

	public void supprimer(Benevoles item) {
		daoBenevoles.supprimer(item.getId());
		mapper.update(courant, UtilFX.findNext(liste, item));
	}
	
	public void modifier(Benevoles item) {
		daoBenevoles.modifier(item);
		mapper.update(courant, UtilFX.findNext(liste, item));
	}
	
	public void infoActualiserBenevoles(Benevoles item) {
		mapper.update(courant, daoBenevoles.retrouverBenevoles(item.getId()));
	}
}
