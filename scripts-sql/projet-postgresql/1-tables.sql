SET search_path TO projet;


-- Schéma

DROP SCHEMA IF EXISTS projet CASCADE;
CREATE SCHEMA projet AUTHORIZATION projet;
GRANT ALL PRIVILEGES ON SCHEMA projet TO projet;


-- Tables

CREATE TABLE compte (
	idcompte		INT				GENERATED BY DEFAULT AS IDENTITY,
	pseudo			VARCHAR(25)		NOT NULL,
	motdepasse		VARCHAR(25) 	NOT NULL,
	email			VARCHAR(100)	NOT NULL,
	PRIMARY KEY (idcompte),
	UNIQUE (pseudo)
);

CREATE TABLE role (
	idcompte		INT				NOT NULL,
	role			VARCHAR(20)		NOT NULL,
	CHECK( Role IN ('ADMINISTRATEUR','UTILISATEUR') ),	
	PRIMARY KEY (idcompte, role),
	FOREIGN KEY (idcompte) REFERENCES compte (idcompte)
);

------------------------------------------------------------
--        Script Postgre 
------------------------------------------------------------



------------------------------------------------------------
-- Table: Poste
------------------------------------------------------------
CREATE TABLE Poste(
	id_poste           INT				GENERATED BY DEFAULT AS IDENTITY,
	nom                VARCHAR (50) NOT NULL ,
	nb_poste           INTEGER  NOT NULL ,
	majeur             BOOL  NOT NULL ,
	membre             BOOL  NOT NULL ,
	horaire_deb_esti   TIMETZ  NOT NULL ,
	horaire_fin_esti   TIMETZ  NOT NULL  ,
	CONSTRAINT Poste_PK PRIMARY KEY (id_poste)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Club
------------------------------------------------------------
CREATE TABLE Club(
	id_club    INT				GENERATED BY DEFAULT AS IDENTITY,
	nom_club   VARCHAR (50) NOT NULL  ,
	CONSTRAINT Club_PK PRIMARY KEY (id_club)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Utilisateur
------------------------------------------------------------
CREATE TABLE Utilisateur(
	id_utilisateur   INT				GENERATED BY DEFAULT AS IDENTITY,
	mail             VARCHAR (50) NOT NULL ,
	mdp              VARCHAR (12) NOT NULL  ,
	CONSTRAINT Utilisateur_PK PRIMARY KEY (id_utilisateur)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Participant
------------------------------------------------------------
CREATE TABLE Participant(
	id_participant   INT				GENERATED BY DEFAULT AS IDENTITY,
	nom              VARCHAR (50) NOT NULL ,
	prenom           VARCHAR (50) NOT NULL ,
	date_naissance   DATE  NOT NULL ,
	telephone        INTEGER  NOT NULL ,
	adresse          VARCHAR (100) NOT NULL ,
	cp               INTEGER  NOT NULL ,
	ville            VARCHAR (50) NOT NULL ,
	certificat_ok    BOOL  NOT NULL ,
	id_club          INTEGER   ,
	id_utilisateur   INTEGER  NOT NULL  ,
	CONSTRAINT Participant_PK PRIMARY KEY (id_participant)

	,CONSTRAINT Participant_Club_FK FOREIGN KEY (id_club) REFERENCES Club(id_club)
	,CONSTRAINT Participant_Utilisateur0_FK FOREIGN KEY (id_utilisateur) REFERENCES Utilisateur(id_utilisateur)
	,CONSTRAINT Participant_Utilisateur_AK UNIQUE (id_utilisateur)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Bénévole
------------------------------------------------------------
CREATE TABLE Benevole(
	id_benevole     INT				GENERATED BY DEFAULT AS IDENTITY,
	Nom              VARCHAR (50) NOT NULL ,
	Prenom           VARCHAR (50) NOT NULL ,
	Permis           BOOL  NOT NULL ,
	Majeur           BOOL  NOT NULL ,
	mail             VARCHAR (50) NOT NULL ,
	telephone        INTEGER  NOT NULL ,
	id_utilisateur   INTEGER  NOT NULL  ,
	CONSTRAINT Benevole_PK PRIMARY KEY (id_benevole)

	,CONSTRAINT Benevole_Utilisateur_FK FOREIGN KEY (id_utilisateur) REFERENCES Utilisateur(id_utilisateur)
	,CONSTRAINT Benevole_Utilisateur_AK UNIQUE (id_utilisateur)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Raid
------------------------------------------------------------
CREATE TABLE Raid(
	id_raid     INT				GENERATED BY DEFAULT AS IDENTITY,
	type_raid   VARCHAR (50) NOT NULL  ,
	CONSTRAINT Raid_PK PRIMARY KEY (id_raid)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Equipe
------------------------------------------------------------
CREATE TABLE Equipe(
	id_equipe               INT				GENERATED BY DEFAULT AS IDENTITY,
	nom                     VARCHAR (50) NOT NULL ,
	etat_inscription        BOOL  NOT NULL ,
	nombre_repas            INTEGER  NOT NULL ,
	id_capitaine            INTEGER  NOT NULL ,
	id_equipier             INTEGER  NOT NULL ,
	id_raid                 INTEGER  NOT NULL  ,
	CONSTRAINT Equipe_PK PRIMARY KEY (id_equipe)

	,CONSTRAINT Equipe_Capitaine_FK FOREIGN KEY (id_capitaine) REFERENCES Participant(id_participant)
	,CONSTRAINT Equipe_Equipier_FK FOREIGN KEY (id_equipier) REFERENCES Participant(id_participant)
	,CONSTRAINT Equipe_Raid1_FK FOREIGN KEY (id_raid) REFERENCES Raid(id_raid)
	,CONSTRAINT Equipe_Capitaine_AK UNIQUE (id_capitaine)
	,CONSTRAINT Equipe_Equipier_AK UNIQUE (id_equipier)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: Avoir
------------------------------------------------------------
CREATE TABLE Avoir(
	id_poste      INTEGER  NOT NULL ,
	id_benevole   INTEGER  NOT NULL ,
	horaire_deb   TIMETZ  NOT NULL ,
	horaire_fin   TIMETZ  NOT NULL  ,
	CONSTRAINT Avoir_PK PRIMARY KEY (id_poste,id_benevole)

	,CONSTRAINT Avoir_Poste_FK FOREIGN KEY (id_poste) REFERENCES Poste(id_poste)
	,CONSTRAINT Avoir_Benevole0_FK FOREIGN KEY (id_benevole) REFERENCES Benevole(id_benevole)
)WITHOUT OIDS;






-- Vues

CREATE VIEW v_compte_avec_roles AS
	SELECT c.*, ARRAY_AGG( r.role ) AS roles
	FROM compte c 
	LEFT JOIN ROLE r ON c.idcompte = r.idcompte
	GROUP BY c.idcompte;

