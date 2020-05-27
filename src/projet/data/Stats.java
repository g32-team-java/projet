package projet.data;


import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Stats {
	
	private Property<Integer> nbCanoe= new SimpleObjectProperty<>();
	private Property<Integer> nbRepas= new SimpleObjectProperty<>();
	
	
	public Stats() {
		
	}
	
	public Stats(int nbCanoe, int nbRepas) {
		setNbCanoe(nbCanoe);
		setNbRepas(nbRepas);
	}

	public final Property<Integer> nbCanoeProperty() {
		return this.nbCanoe;
	}
	

	public final Integer getNbCanoe() {
		return this.nbCanoeProperty().getValue();
	}
	

	public final void setNbCanoe(final Integer nbCanoe) {
		this.nbCanoeProperty().setValue(nbCanoe);
	}
	

	public final Property<Integer> nbRepasProperty() {
		return this.nbRepas;
	}
	

	public final Integer getNbRepas() {
		return this.nbRepasProperty().getValue();
	}
	

	public final void setNbRepas(final Integer nbRepas) {
		this.nbRepasProperty().setValue(nbRepas);
	}
	
	
	

}
