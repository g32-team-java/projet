package projet.view.stats;

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
import projet.dao.DaoStats;
import projet.data.Stats;
import projet.view.systeme.ModelConfig;

public class ModelStats {
	
	private final Stats courant = new Stats();
	
	
	@Inject
	private IMapper			mapper;
	
	@Inject
	private DaoStats daoStats;
	
	public Stats getCourant() {
		return courant;
	}
	
	public void actualiserNbCanoe() {
		courant.setNbCanoe(daoStats.listerNbCanoe());
	}
	
	public void actualiserNbRepas() {
		courant.setNbRepas(daoStats.listerNbRepas());
	}

}
