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
        mdp        Varchar (200) NOT NULL ,
        age        Int NOT NULL ,
        numeroSecu Varchar (20) NOT NULL
	,CONSTRAINT personne_PK PRIMARY KEY (idpersonne)
)ENGINE=InnoDB;


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
  role enum("sante", "user"),
  primary key(iduser)
);

insert into user values(null, "DUGIMONT", "Garance", "garancedugimont@gmail.com", "123", "sante"), (null,'YONNET',"Jimmy","b@gmail.com","456", "user");
