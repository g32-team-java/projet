package projet.view.stats;

import javax.inject.Inject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import jfox.javafx.util.ConverterStringInteger;
import jfox.javafx.view.IManagerGui;
import projet.data.Stats;
import projet.view.EnumView;
import projet.view.memo.ModelMemo;

public class ControllerStats {
	

	@FXML
	private Button b_Accueil;
	@FXML
	private Button b_Retour;
	@FXML
	private TextField tf_nbRepas;
	@FXML
	private TextField tf_nbCanoës;

	@Inject
	private ModelStats	modelStats;
	
	@Inject
	private IManagerGui			managerGui;
	
	@FXML
	private void initialize() {
		
		modelStats.actualiserNbCanoe();
		modelStats.actualiserNbRepas();
		Stats courant = modelStats.getCourant();
		tf_nbCanoës.textProperty().bindBidirectional(courant.nbCanoeProperty(),new ConverterStringInteger() );
		tf_nbRepas.textProperty().bindBidirectional(courant.nbRepasProperty(),new ConverterStringInteger() );
		
	}

	@FXML
	private void toAccueil() {
		managerGui.showView( EnumView.Accueil );
	}

	@FXML
	private void toRetour() {
		managerGui.showView(EnumView.Participants);
	}
	
	



}
