create database platformaStudiu;
use platformaStudiu;

CREATE TABLE Studenti (
    ID_Student INT PRIMARY KEY AUTO_INCREMENT,
    CNP_Student VARCHAR(20) UNIQUE,
    Nume_Student VARCHAR(50),
    Prenume_Student VARCHAR(50),
    Adresa_Student VARCHAR(100),
    Telefon_Student VARCHAR(15),
    Email_Student VARCHAR(50),
    ContIBAN_Student VARCHAR(30),
    NumarContract_Student INT,
    AnStudiu INT,
    OreSustinute_Student INT,
    UserName VARCHAR(30) UNIQUE,
    Parola VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE Profesori (
    ID_Profesor INT PRIMARY KEY AUTO_INCREMENT,
    CNP_Profesor VARCHAR(20) UNIQUE,
    Nume_Profesor VARCHAR(50),
    Prenume_Profesor VARCHAR(50),
    Adresa_Profesor VARCHAR(100),
    Telefon_Profesor VARCHAR(15),
    Email_Profesor VARCHAR(50),
    ContIBAN_Profesor VARCHAR(30),
    NumarContract_Profesor INT,
    CursuriPredate VARCHAR(30),
    Departament VARCHAR(50),
    MinOre INT,
    MaxOre INT,
    UserName VARCHAR(30) UNIQUE,
    Parola VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE Administratori (
    ID_Administrator INT PRIMARY KEY AUTO_INCREMENT,
    CNP_Administrator VARCHAR(20) UNIQUE,
    Nume_Administrator VARCHAR(50),
    Prenume_Administrator VARCHAR(50),
    Adresa_Administrator VARCHAR(100),
    Telefon_Administrator VARCHAR(15),
    Email_Administrator VARCHAR(50),
    ContIBAN_Administrator VARCHAR(30),
    NumarContract_Administrator INT,
    UserName VARCHAR(30) UNIQUE,
    Parola VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE SuperAdministratori (
    ID_SuperAdministratori INT PRIMARY KEY AUTO_INCREMENT,
    CNP_SuperAdministratori VARCHAR(20) UNIQUE,
    Nume_SuperAdministratori VARCHAR(50),
    Prenume_SuperAdministratori VARCHAR(50),
    Adresa_SuperAdministratori VARCHAR(100),
    Telefon_SuperAdministratori VARCHAR(15),
    Email_SuperAdministratori VARCHAR(50),
    ContIBAN_SuperAdministratori VARCHAR(30),
    NumarContract_SuperAdministratori INT,
    UserName VARCHAR(30) UNIQUE,
    Parola VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE Cursuri (
    ID_Curs INT PRIMARY KEY AUTO_INCREMENT,
    ID_Profesor INT,
    Nume VARCHAR(100),
    Descriere TEXT,
    MaxStudenti INT,
    FOREIGN KEY (ID_Profesor) REFERENCES Profesori(ID_Profesor)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE ProgramareActivitati (
    ID_Activitate INT PRIMARY KEY AUTO_INCREMENT,
    ID_Curs INT,
    TipActivitate VARCHAR(20),
    DataInceput DATETIME,
    DataSfarsit DATETIME,
    MaxParticipanti INT,
    FOREIGN KEY (ID_Curs) REFERENCES Cursuri(ID_Curs)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE InscrieriStudenti_Activitate (
    ID_Inscriere INT PRIMARY KEY AUTO_INCREMENT,
    ID_Activitate INT,
    ID_Student INT, 
    FOREIGN KEY (ID_Activitate) REFERENCES ProgramareActivitati(ID_Activitate),
    FOREIGN KEY (ID_Student) REFERENCES Studenti(ID_Student)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE InscrieriStudenti_Curs (
    ID_Inscriere INT PRIMARY KEY AUTO_INCREMENT,
    ID_Curs INT,
	ID_Student INT,  
    FOREIGN KEY (ID_Curs) REFERENCES Cursuri(ID_Curs),
    FOREIGN KEY (ID_Student) REFERENCES Studenti(ID_Student)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE Note (
    ID_Nota INT PRIMARY KEY AUTO_INCREMENT,
    ID_Activitate INT,
    ID_Student INT,  
    Nota INT,
    FOREIGN KEY (ID_Activitate) REFERENCES ProgramareActivitati(ID_Activitate),
    FOREIGN KEY (ID_Student) REFERENCES Studenti(ID_Student)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE GrupuriStudiu (
    ID_Grup INT PRIMARY KEY AUTO_INCREMENT,
    Nume VARCHAR(100),
    ID_Curs INT,
    FOREIGN KEY (ID_Curs) REFERENCES Cursuri(ID_Curs)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE Activitati_Grup (
    ID_Activitate INT PRIMARY KEY AUTO_INCREMENT,
    Data_activitate DATETIME,
    Durata_activitate INT,
    Confirmare_activitate DATETIME,
    NrInscrisi INT,
    MinParticipanti INT,
    FOREIGN KEY (ID_Activitate) REFERENCES GrupuriStudiu(ID_Grup)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE MembriGrup (
    ID_Membru INT PRIMARY KEY AUTO_INCREMENT,
    ID_Grup INT,
    ID_Student INT,
    FOREIGN KEY (ID_Grup) REFERENCES GrupuriStudiu(ID_Grup),
    FOREIGN KEY (ID_Student) REFERENCES Studenti(ID_Student)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE MesajeGrup (
    ID_Mesaj INT PRIMARY KEY AUTO_INCREMENT,
    ID_Grup INT,
    ID_Student INT,   
    Mesaj TEXT,
    FOREIGN KEY (ID_Grup) REFERENCES GrupuriStudiu(ID_Grup),
    FOREIGN KEY (ID_Student) REFERENCES Studenti(ID_Student)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#un administrator poate fi asociat cu mai multe cursuri, iar un curs poate avea un singur administrator.
ALTER TABLE Cursuri
ADD COLUMN ID_Administrator INT,
ADD FOREIGN KEY (ID_Administrator) REFERENCES Administratori(ID_Administrator);

 #un administrator poate fi asociat cu un superadministrator, iar un superadministrator poate avea mai mulți administratori subordonați
ALTER TABLE Administratori
ADD COLUMN ID_SuperAdministratori INT,
ADD FOREIGN KEY (ID_SuperAdministratori) REFERENCES SuperAdministratori(ID_SuperAdministratori);

CREATE TABLE ProcenteCursuri (
    ID_Procent INT PRIMARY KEY AUTO_INCREMENT,
    ID_Curs INT,
    ProcentCurs INT,
    ProcentSeminar INT,
    ProcentLaborator INT,
    FOREIGN KEY (ID_Curs) REFERENCES Cursuri(ID_Curs)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
