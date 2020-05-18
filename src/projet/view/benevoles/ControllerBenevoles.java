package projet.view.benevoles;

import javax.inject.Inject;

import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import jfox.javafx.util.UtilFX;
import jfox.javafx.view.IManagerGui;
import projet.data.Benevoles;
import projet.view.EnumView;

public class ControllerBenevoles {
@Inject
private IManagerGui			managerGui;
@Inject
private ModelBenevoles		modelBenevoles;

	@FXML
	private Button Accueil;
	@FXML
	private Button Details;
	
//	ObservableList<Benevoles> benes=FXCollections.observableArrayList();
	
	@FXML
//	private ListView<Benevoles> ListeBenevoles=new ListView<Benevoles>(benes);
	private ListView<Benevoles> ListeBenevoles;
	
	@FXML
	private void toAccueil() {
		managerGui.showView( EnumView.Accueil );
	}
	@FXML
	private void toDetails() {
		managerGui.showView( EnumView.DetailsBenevoles);
	}
	
	
	@FXML
	private void initialize() {
		modelBenevoles.actualiserListe();
		ListeBenevoles.setItems(modelBenevoles.getListe());
//		ListeBenevoles.getSelectionModel().selectedItemProperty().addListener(ChangeListener<? extends Benevoles>{
//			@Override
//			public void changed(ObservableValue<? extends Benevoles> obsval,Benevoles oldVal, Benevoles newVal)
//			{System.out.println(oldVal+"->"+newVal);});
//			
//		});
	}
		 
	
 
	
}
