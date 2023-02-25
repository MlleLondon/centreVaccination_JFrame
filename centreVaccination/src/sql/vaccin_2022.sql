#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------

drop database if exists vaccin_2022_CL;
create database vaccin_2022_CL;
use vaccin_2022_CL;

#------------------------------------------------------------
# Table: personne
#------------------------------------------------------------

CREATE TABLE personne(
        idpersonne Int  Auto_increment  NOT NULL ,
        nom        Varchar (50) NOT NULL ,
        prenom     Varchar (50) NOT NULL ,
        tel        Varchar (50) NOT NULL ,
        adresse    Varchar (200) NOT NULL ,
        email      Varchar (100) NOT NULL ,
        age        Int NOT NULL ,
        numeroSecu Varchar (20) NOT NULL
	,CONSTRAINT personne_PK PRIMARY KEY (idpersonne)
)ENGINE=InnoDB;

insert into personne values(null, "DUGIMONT", "Pascal", "0668571291", "Vitry-sur-Seine", "p@gmail.com", 19, "0568740555"),(null, "LEVY", "Dan", "0781267866", "Paris 16", "d@gmail.com", 25, "3368635622");


#------------------------------------------------------------
# Table: centre
#------------------------------------------------------------

CREATE TABLE centre(
        idcentre      Int  Auto_increment  NOT NULL ,
        nom           Varchar (50) NOT NULL ,
        adresse       Varchar (100) NOT NULL ,
        type          enum("caserne", "hospital", "centre mobile", "centre temporaire"),
        capacite      Int NOT NULL ,
        nbIntervenant Int NOT NULL ,
        horaire       Varchar (20) NOT NULL
	,CONSTRAINT centre_PK PRIMARY KEY (idcentre)
)ENGINE=InnoDB;

insert into centre values(null, "Pierre Semard", "10 rue de Cléry, Paris 02", "centre mobile", 50, 10, "8h-20h"), (null, "Jean Mace", "2 rue d'Ivry, Vitry-sur-Seine", "centre temporaire", 100, 20, "10h-18h");


#------------------------------------------------------------
# Table: vaccin
#------------------------------------------------------------

CREATE TABLE vaccin(
        idvaccin     Int  Auto_increment  NOT NULL ,
        nom          Varchar (20) NOT NULL ,
        laboratoire  Varchar (20) NOT NULL ,
        pays         Varchar (20) NOT NULL ,
        conservation Varchar (50) NOT NULL
	,CONSTRAINT vaccin_PK PRIMARY KEY (idvaccin)
)ENGINE=InnoDB;

insert into vaccin values(null, "Pfizer", "Pfizer Inc.", "Etats-Unis", "3 a 5 degres (Frigo)");

#------------------------------------------------------------
# Table: vaccination
#------------------------------------------------------------

CREATE TABLE vaccination(
        idvaccination Int  Auto_increment  NOT NULL ,
        description   Varchar (200) NOT NULL ,
        dateVacc       Date NOT NULL ,
        heure         Time NOT NULL ,
        nbDose        Int NOT NULL ,
        temperature   Varchar (200) NOT NULL ,
        nomMedecin    Varchar (50) NOT NULL ,
        idcentre      Int NOT NULL ,
        idpersonne    Int NOT NULL ,
        idvaccin      Int NOT NULL
	,CONSTRAINT vaccination_PK PRIMARY KEY (idvaccination)

	,CONSTRAINT vaccination_centre_FK FOREIGN KEY (idcentre) REFERENCES centre(idcentre)
	,CONSTRAINT vaccination_personne0_FK FOREIGN KEY (idpersonne) REFERENCES personne(idpersonne)
	,CONSTRAINT vaccination_vaccin1_FK FOREIGN KEY (idvaccin) REFERENCES vaccin(idvaccin)
)ENGINE=InnoDB;




create table user(
  iduser int(3) not null auto_increment,
  nom varchar(30),
  prenom varchar(30),
  email varchar(30),
  mdp varchar(30),
  primary key(iduser)
);

insert into user values(null, "DUGIMONT", "Garance", "a@gmail.com", "123");
