package projet.data;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Benevoles {

	private final Property<Integer> id= new SimpleObjectProperty<>();
	private final StringProperty nom = new SimpleStringProperty();
	private final StringProperty prenom = new SimpleStringProperty();
	private final Property<Boolean> permis = new SimpleObjectProperty<>();
	private final Property<Boolean> majeur = new SimpleObjectProperty<>();
	private final StringProperty mail = new SimpleStringProperty();
	private final Property<Integer> telephone = new SimpleObjectProperty<>();	


public Benevoles() {
}

public Benevoles(int id, String nom, String prenom, boolean permis, boolean majeur, String mail, int telephone) {

	setId(id);
	setNom(nom);
	setPrenom(prenom);
	setPermis(permis);
	setMajeur(majeur);
	setMail(mail);
	setTelephone(telephone);	
}

	public String toString() {
		return this.getNom();
	}




//Get-Set

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


public final Property<Boolean> permisProperty() {
	return this.permis;
}


public final Boolean getPermis() {
	return this.permisProperty().getValue();
}


public final void setPermis(final Boolean permis) {
	this.permisProperty().setValue(permis);
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


public final StringProperty mailProperty() {
	return this.mail;
}


public final String getMail() {
	return this.mailProperty().get();
}


public final void setMail(final String mail) {
	this.mailProperty().set(mail);
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

}