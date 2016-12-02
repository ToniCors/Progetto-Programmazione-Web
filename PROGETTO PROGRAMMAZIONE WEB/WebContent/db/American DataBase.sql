DROP DATABASE IF EXISTS American;
CREATE DATABASE American;
USE American;

DROP TABLE IF EXISTS CLIENTE;

CREATE TABLE CLIENTE (	

  Username varchar(30)  primary key ,
  nome varchar(30) not null,
  cognome varchar(30) not null, 
  email varchar(30) not null,
  passWorld varchar(40) not null,
  sesso char(1) not null,
  cellulare char(10) not null,
  dataDiNascita date not null,
  
  check(sesso= 'M'or sesso= 'F')  
);


DROP TABLE IF EXISTS FILM;

CREATE TABLE FILM (	

    Titolo		    varchar(50) primary key ,
	genere			varchar(25)not null,
	durata			int(3)not null, 
	regista			varchar(30) not null,
    trailer     text not null,
    trama       text not null,
    immagine    text not null,
    
    check(durata > 0 and durata < 240 )  
);



DROP TABLE IF EXISTS SALA;

CREATE TABLE SALA (	

    IDsala			char(1) primary key ,	/* A < x < Z */
	numeroPosti		int(3) 	
   
);




DROP TABLE IF EXISTS PROIEZIONE;

CREATE TABLE PROIEZIONE (
	
  IDproiezione int auto_increment primary key ,
  dataProiezione date  not null,
  fasciaOraria int not null,
  prezzoBase  int(2) not null,
  _3D boolean not null,
  film    varchar(50),  
  
  foreign key (film) references Film(Titolo)
       on delete set null on update cascade,   
       
  check(fasciaOraria > 0 and fasciaOraria < 4 )       

);


DROP TABLE IF EXISTS BIGLIETTO;

CREATE TABLE BIGLIETTO (

  IDbiglietto    varchar(35) primary key,
  prezzo        decimal not null,
  dataAcquisto  date  not null,
  oraAcquisto time not null,
  posto         int(3) not null,
  cliente       char(30),
  proiezione    int,

   foreign key (cliente) references CLIENTE(Username)
       on delete cascade on update cascade,
   foreign key (proiezione) references PROIEZIONE(IDproiezione)
       on delete set null on update cascade,

    check(prezzoFinale > 0)
);

DROP TABLE IF EXISTS UBICAZIONE;

CREATE TABLE UBICAZIONE (

  Proiezione int not null,
  Sala char(1) not null,
  
  primary key (Proiezione,Sala),

  foreign key (Sala) references SALA(IDsala)
       on delete cascade on update cascade,
  foreign key (proiezione) references PROIEZIONE(IDproiezione)
       on delete cascade on update cascade
);


