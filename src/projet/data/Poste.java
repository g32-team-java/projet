package projet.data;


import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Poste {
	private Property<Integer> id= new SimpleObjectProperty<>();
	private StringProperty nom = new SimpleStringProperty();
	private Property<Integer> nbPoste= new SimpleObjectProperty<>();
	private final Property<Boolean> majeur	 = new SimpleObjectProperty<>();
	private final Property<Boolean> membre = new SimpleObjectProperty<>();
	//private final Property<Time> heue_debut = new SimpleObjectProperty<>()
	
	public Poste(){
		
	}
	
	public Poste(int id, String nom,int nbPoste, boolean majeur, boolean membre ){
		setId(id);
		setNom(nom);
		setNbPoste(nbPoste);
		setNom(nom);
		setMajeur(majeur);
		setMembre(membre);
	}

	
	@Override
	public String toString() {
		return nom + " " +nbPoste;
	}

	public final Property<Integer> idProperty() {
		return this.id;
	}
	

	public final Integer getId() {
		return this.idProperty().getValue();
	}
	

	public final void setId(final Integer id) {
		this.idProperty().setValue(id);
	}
	

	public final StringProperty nomProperty() {
		return this.nom;
	}
	

	public final String getNom() {
		return this.nomProperty().get();
	}
	

	public final void setNom(final String nom) {
		this.nomProperty().set(nom);
	}
	

	public final Property<Integer> nbPosteProperty() {
		return this.nbPoste;
	}
	

	public final Integer getNbPoste() {
		return this.nbPosteProperty().getValue();
	}
	

	public final void setNbPoste(final Integer nbPoste) {
		this.nbPosteProperty().setValue(nbPoste);
	}
	

	public final Property<Boolean> majeurProperty() {
		return this.majeur;
	}
	

	public final Boolean getMajeur() {
		return this.majeurProperty().getValue();
	}
	

	public final void setMajeur(final Boolean majeur) {
		this.majeurProperty().setValue(majeur);
	}
	

	public final Property<Boolean> membreProperty() {
		return this.membre;
	}
	

	public final Boolean getMembre() {
		return this.membreProperty().getValue();
	}
	

	public final void setMembre(final Boolean membre) {
		this.membreProperty().setValue(membre);
	}

}
