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
 ('parlamamain@gmail.com','fatal');
