SET search_path TO projet;


-- Supprimer toutes les données

DELETE FROM role;
DELETE FROM compte;


-- Compte

INSERT INTO compte (idcompte, pseudo, motdepasse, email ) VALUES 
  (1, 'geek', 'geek', 'geek@3il.fr' ),
  (2, 'chef', 'chef', 'chef@3il.fr' ),
  (3, 'job', 'job', 'job@3il.fr' );

ALTER TABLE compte ALTER COLUMN idcompte RESTART WITH 4;


-- Role

INSERT INTO role (idcompte, role) VALUES 
  ( 1, 'ADMINISTRATEUR' ),
  ( 1, 'UTILISATEUR' ),
  ( 2, 'UTILISATEUR' ),
  ( 3, 'UTILISATEUR' );

-- Utilisateurs

 INSERT INTO utilisateur (mail, mdp) VALUES 
 
 ('baptiste.paterne@gmail.com', 'I12019'),
 ('v.dereclenne@gmail.com', 'I12020'),
 ('monstergege@gmail.com', 'calloflover'),
 ('kekezez@gmail.com', 'punkdebutant'),
 ('huiteuros@gmail.com', '8euros'),
 ('dupond.jena@gmail.com','I12500'),
 ('alex.alfred@gmail.com','I12000'),
 ('jacky.michel@gmail.com','I12021'),
 ('lebg.jean@gmail.com','elements'),
 ('parlamamain@gmail.com','fatal'),
 ('trevis.alabama@gmail.com','842512');
 

 
 INSERT INTO Participant (nom, prenom, date_naissance, telephone, adresse, cp, ville, certificat_ok, id_club, id_utilisateur) VALUES
 
 ('Jena','DUPOND','{d '2000-02-25'}','0670079746','3 rue de la Marne','87000','Limoges',TRUE,'1','6'),
 ('Alfred','ALEX','{d '2001-12-12'}','0635248547','5 avenue de la liberté','21110','FAUVERNEY',TRUE,'2','7'),
 ('Michel','JACKY','{d '1995-01-01'}','0632698546','18 bis avenue Jean Charles','87000','87000',TRUE,'3','8'),
 ('Jean','DEPARDIEU','{d '1996-05-18'}','0632541230','45 rue Eric Cantona','21000','Dijon',TRUE,'2','9'),
 ('Eric','KANT','{d '1992-04-22'}','0635996585','86 rue du vide','87000','Limoges',TRUE,'1','10'),
 ('Trevis','ALABAMA','{d '1958-06-18'}','0625356595','54 rue des Paquerettes','21000','Dijon',TRUE,'3','11');
 
 INSERT INTO Club (nom_club) VALUES
 ('Les Limougeauds'),
 ('Les Dijonnais'),
 ('CM de LaVille');
 
 INSERT INTO Equipe (nom, etat_inscription, nombre_repas, id_capitaine, id_equipier, id_raid) VALUES
 
 ('Equipe 1',TRUE,'2','6','10','1'),
 ('Equipe 2',TRUE,'2','7','9','2'),
 ('Equipe 3',TRUE,'2','8','11','1');
 
 INSERT INTO Raid (type_raid) VALUES
 ('Grand Bol d''air'),
 ('Petit Bol d''air');
 
 INSERT INTO poste (nom, nb_poste, majeur, membre, horaire_deb_esti, horaire_fin_esti) VALUES
  ('parking voiture', 2, TRUE, TRUE, '07:00', '09:00'),
  ('parking vélo', 2, FALSE, TRUE, '07:00', '09:00'),
  ('remise des dossards', 4,FALSE, TRUE, '07:00', '09:00'),
  ('signaleur', 37, FALSE, FALSE, '08:30', '13:30'),
  ('ravitaillement 1', 2, FALSE,FALSE, '09:00', '13:00'),
  ('ravitaillement 2', 2, FALSE,FALSE, '09:00', '13:00'),
  ('ravitaillement 3', 2, FALSE,FALSE, '09:00', '13:00'),
  ('sécurité sur eau', 6, FALSE, TRUE, '09:00', '10:30'),
  ('chronométrage 1', 2, FALSE, FALSE, '09:30','10:30' ),
  ('chronométrage 2', 2, FALSE, FALSE, '10:15', '11:15' ),
  ('chronométrage 3', 2, FALSE, FALSE, '13:30', '14:30'),
  ('moto (fermeture)', 2, TRUE, FALSE, '09:00', '13:30'),
  ('buvette', 5, FALSE, TRUE, '07:00', '15:00'),
  ('repas', 3, FALSE, FALSE, '11:00', '14:00'),
  ('recuperation puces', 1, FALSE, TRUE, '12:00', '13:30'),
  ('photographe', 2, TRUE, FALSE, '07:00', '14:00');
  
  /*INSERT INTO benevole (nom, prenom, permis, majeur, telephone) VALUES
  ()
  
  ALTER TABLE benevole ALTER COLUMN id_benevole RESTART WITH 100;*/