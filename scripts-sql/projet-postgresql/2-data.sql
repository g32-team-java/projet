SET search_path TO projet;


-- Supprimer toutes les données

DELETE FROM equipe;
DELETE FROM raid;
DELETE FROM participant;
DELETE FROM club;
DELETE FROM avoir;
DELETE FROM poste;
DELETE FROM benevole;
DELETE FROM utilisateur;
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
 ('trevis.alabama@gmail.com','842512'),
 ('baptiste.paterne@gmail.com', 'I12019'),
 ('v.dereclenne@gmail.com', 'I12020'),
 ('monstergege@gmail.com', 'calloflover'),
 ('kekezez@gmail.com', 'punkdebutant'),
 ('huiteuros@gmail.com', '8euros'),
 ('baptiste.paterne@gmail.com', 'I12019'),
 ('v.dereclenne@gmail.com', 'I12020'),
 ('monstergege@gmail.com', 'calloflover'),
 ('kekezez@gmail.com', 'punkdebutant'),
 ('huiteuros@gmail.com', '8euros'),
 ('baptiste.paterne@gmail.com', 'I12019'),
 ('v.dereclenne@gmail.com', 'I12020'),
 ('monstergege@gmail.com', 'calloflover'),
 ('kekezez@gmail.com', 'punkdebutant'),
 ('huiteuros@gmail.com', '8euros');
 
 
 
  
  
  ALTER TABLE benevole ALTER COLUMN id_benevole RESTART WITH 1;
 
  INSERT INTO Club (nom_club) VALUES
  ('Pas de club'),
  ('Les Limougeauds'),
  ('Les Dijonnais'),
  ('CM de LaVille');
 
  ALTER TABLE club ALTER COLUMN id_club RESTART WITH 1;
  
   INSERT INTO Participant (prenom,nom, date_naissance, telephone, adresse, cp, ville, certificat_ok, inscription_ok, id_club, id_utilisateur) VALUES
 
 ('Jena','DUPOND', '2000-02-25','0670079746','3 rue de la Marne','87000','Limoges',TRUE,TRUE,'2','6'),
 ('Alfred','ALEX', '2001-12-12','0635248547','5 avenue de la liberté','21110','FAUVERNEY',TRUE,FALSE, '3','7'),
 ('Michel','JACKY', '1995-01-01','0632698546','18 bis avenue Jean Charles','87000','87000',TRUE,TRUE,'4','8'),
 ('Jean','DEPARDIEU','1996-05-18','0632541230','45 rue Eric Cantona','21000','Dijon',TRUE,FALSE,'3','9'),
 ('Eric','KANT', '1992-04-22','0635996585','86 rue du vide','87000','Limoges',TRUE,TRUE, '2','10'),
 ('Trevis','ALABAMA', '1958-06-18','0625356595','54 rue des Paquerettes','21000','Dijon',TRUE,TRUE, '4','11');

 
  ALTER TABLE participant ALTER COLUMN id_participant RESTART WITH 7;
  	
   INSERT INTO Raid (type_raid) VALUES
  ('Grand Bol d''air'),
  ('Petit Bol d''air');
 
  ALTER TABLE raid ALTER COLUMN id_raid RESTART WITH 1;
  
  
  INSERT INTO Equipe (nom, etat_inscription, nombre_repas, id_capitaine, id_equipier, id_raid) VALUES
 
 ('Equipe 1',TRUE,'2','1','5','1'),
 ('Equipe 2',FALSE,'2','2','4','2'),
 ('Equipe 3',TRUE,'2','3','6','1');
 
 ALTER TABLE equipe ALTER COLUMN id_equipe RESTART WITH 1;
 
 
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
  
  INSERT INTO benevole (prenom, nom, permis, majeur, membre, telephone, id_utilisateur) VALUES
  ('Baptiste', 'Paterne', TRUE,TRUE, FALSE, 0770707070, 1 ),
  ('Vincent', 'Dereclenne', TRUE, TRUE, TRUE, 0680545153,2),
  ('Gege', 'Monster', FALSE,FALSE, FALSE, 0606060606,3 ),
  ('Keke', 'Zeze', FALSE, FALSE, TRUE, 0658963215, 4),
  ('8', 'Euros', FALSE,TRUE, FALSE, 0647251386, 5 ),
  ('Jean', 'Charles', TRUE,TRUE, FALSE, 0511409066, 12 ),
  ('Charles', 'Edouard', TRUE, TRUE, TRUE, 0642811324,13),
  ('Jean-Richard', 'De la Boustifaille', FALSE,FALSE, FALSE, 0319184736,14 ),
  ('Charles-Edouard', 'Richard', FALSE, FALSE, TRUE, 0143830155, 15),
  ('16', 'Euros', FALSE,TRUE, FALSE, 0876000075, 16 ),
  ('George', 'Clowney', TRUE,TRUE, FALSE, 0965877704, 17 ),
  ('Sir-Alfonse', 'Du Chateau', TRUE, TRUE, TRUE, 0196424469,18),
  ('Fanny', 'Azertyuiop', FALSE,FALSE, FALSE, 0542805625,19 ),
  ('3IL', 'Ingenieurs', FALSE, FALSE, TRUE, 0220813803, 20),
  ('32', 'Euros', FALSE,TRUE, FALSE, 0262962377, 21 ),
  ('Paul', 'Haut', TRUE,TRUE, FALSE, 0397560077, 22 ),
  ('Enzo', 'Petunia', TRUE, TRUE, TRUE, 0261803339,23),
  ('Olivier', 'De La Foret', FALSE,FALSE, FALSE, 0679869276,24 ),
  ('Bepo', 'Dvorak', FALSE, FALSE, TRUE, 0952639105, 25),
  ('64', 'Euros', FALSE,TRUE, FALSE, 0562973076, 26 );
  
  
  
  INSERT INTO avoir( id_poste, id_benevole, horaire_deb, horaire_fin) VALUES 
  (1,1,'09:00', '13:30'),
  (2,2,'07:00', '09:00'),
  (3,3,'09:00', '13:00'),
  (4,4,'12:00', '13:30'),
  (5,5,'07:00', '14:00'),
  (6,6,'09:00', '13:30'),
  (7,7,'07:00', '09:00'),
  (8,8,'09:00', '13:00'),
  (9,9,'12:00', '13:30'),
  (10,10,'07:00', '14:00'),
  (11,11,'09:00', '13:30'),
  (12,12,'07:00', '09:00'),
  (13,13,'09:00', '13:00'),
  (14,14,'12:00', '13:30'),
  (15,15,'07:00', '14:00'),
  (16,16,'09:00', '13:30'),
  (1,17,'07:00', '09:00'),
  (2,18,'09:00', '13:00'),
  (3,19,'12:00', '13:30'),
  (4,20,'07:00', '14:00');
  
  
 