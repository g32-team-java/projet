package projet.data;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Participants {
	private Property<Integer> id= new SimpleObjectProperty<>();
	private StringProperty nom = new SimpleStringProperty();
	private StringProperty prenom = new SimpleStringProperty();
	private Property<Integer> telephone = new SimpleObjectProperty<>();	
	private StringProperty adresse = new SimpleStringProperty();
	private Property<Integer> cp = new SimpleObjectProperty<>();
	private StringProperty ville = new SimpleStringProperty();
	private Property<Boolean> certificat = new SimpleObjectProperty<>();

	public Participants (){
		
	}
	
	public Participants (int id, String nom, String prenom, int telephone, String adresse, int cp, String ville, boolean certificat){
		
	}
	
	public String toString() {
		return this.getNom() +" " + this.getPrenom();
	}

	// Getters - Setters
	
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


	public final StringProperty prenomProperty() {
		return this.prenom;
	}


	public final String getPrenom() {
		return this.prenomProperty().get();
	}


	public final void setPrenom(final String prenom) {
		this.prenomProperty().set(prenom);
	}
	
	public final Property<Integer> telephoneProperty() {
		return this.telephone;
	}


	public final Integer getTelephone() {
		return this.telephoneProperty().getValue();
	}


	public final void setTelephone(final Integer telephone) {
		this.telephoneProperty().setValue(telephone);
	}
	
	public final StringProperty adresseProperty() {
		return this.adresse;
	}


	public final String getAdresse() {
		return this.adresseProperty().get();
	}


	public final void setAdresse(final String adresse) {
		this.adresseProperty().set(adresse);
	}
	
	
	public final Property<Integer> cpProperty() {
		return this.cp;
	}


	public final Integer getCp() {
		return this.cpProperty().getValue();
	}


	public final void setCp(final Integer cp) {
		this.cpProperty().setValue(cp);
	}
	
	public final StringProperty villeProperty() {
		return this.ville;
	}


	public final String getVille() {
		return this.villeProperty().get();
	}


	public final void setVille(final String ville) {
		this.villeProperty().set(ville);
	}
	
	public final Property<Boolean> certificatProperty() {
		return this.certificat;
	}


	public final Boolean getCertificat() {
		return this.certificatProperty().getValue();
	}


	public final void setCertificat(final Boolean certificat) {
		this.certificatProperty().setValue(certificat);
	}
	
	

	
	
	
}
