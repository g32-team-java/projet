package projet.view.participants;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import javax.inject.Inject;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import jfox.commun.exception.ExceptionValidation;
import jfox.javafx.util.UtilFX;
import projet.commun.IMapper;
import projet.dao.DaoParticipant;
import projet.data.Participants;
import projet.view.systeme.ModelConfig;


public class ModelParticipant {

	private final ObservableList<Participants> liste = FXCollections.observableArrayList(); 

	private final Participants courant = new Participants();
	
	
	
	@Inject
	private IMapper			mapper;


	@Inject
	private DaoParticipant	daoParticipant;

	public ObservableList<Participants> getListe() {
		return liste;
	}

	public Participants getCourant() {
		return courant;
	}
	
	// Actualisations
	public void actualiserListeInscrits() {
		liste.setAll( daoParticipant.listerInscrits() );
	}

	public void actualiserListeDemandes() {
		liste.setAll( daoParticipant.listerDemandes() );
	}

	// Préparations de modifs
	
	public void preparerModifier(Participants item) {
		System.out.println(item.getId());
		mapper.update(courant, daoParticipant.retrouverParticipant(item.getId()));
	}
	
	public void preparerAjoutBase(Participants item) {
		daoParticipant.modifier(item);
		mapper.update(courant, UtilFX.findNext(liste, item));
	}
	public void preparerAjouter(Participants item) {
		mapper.update(courant, new Participants());
	}
	
	public void supprimer(Participants item) {
		//Supprime un Participant
		daoParticipant.supprimer(item);
		mapper.update(courant, UtilFX.findNext(liste, item));
	}
	
	
	

}
