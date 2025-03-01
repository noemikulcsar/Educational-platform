use platformaStudiu;

INSERT INTO Studenti (ID_Student, CNP_Student, Nume_Student, Prenume_Student, Adresa_Student, Telefon_Student, Email_Student, ContIBAN_Student, NumarContract_Student, AnStudiu, OreSustinute_Student, UserName, Parola)
VALUES
('1', '1234567890100', 'Ureche', 'Simona', 'Strada Garii nr. 1082', '0764224194', 'simona.ureche@yahoo.com', 'RO123456789012345678901', 1, 2024, 25, 'UrecheSimona', 'parolaSimona'),
('2', '2345678901111', 'Repede', 'Oana', 'Strada Avram Iancu nr. 410', '0784059519', 'oana.repede@yahoo.com', 'RO234567890123456789012', 2, 2024, 25, 'RepedeOana', 'parolaOana'),
('3','2345678901457', 'Kulcsar', 'Noaemi', 'Strada Aleeea Zorilor nr 6', '0754617850', 'kulcsar.noemi@yahoo.com', 'RO234567890123456789012', 3, 2024, 10, 'KucsarNoemi', 'parolaNoemi'),
('4', '1234567890123', 'Popescu', 'Ion', 'Strada Principala nr. 10', '0712345678', 'ion.popescu@example.com', 'RO123456789012345678901', 4, 2023, 20, 'PopescuIon', 'parolaIon'),
('5', '2345678901234', 'Ionescu', 'Maria', 'Bulevardul Libertatii nr. 5', '0723456789', 'maria.ionescu@example.com', 'RO234567890123456789012', 5, 2023, 25, 'IonescuMaria', 'parolaMaria');

INSERT INTO Profesori (ID_Profesor ,CNP_Profesor, Nume_Profesor, Prenume_Profesor, Adresa_Profesor, Telefon_Profesor, Email_Profesor, ContIBAN_Profesor, NumarContract_Profesor, CursuriPredate, Departament, MinOre, MaxOre, UserName, Parola)
VALUES
('1', '3456789012999', 'Pop', 'Vasile', 'Strada Bulevardul Eroilor nr. 10', '0734567890', 'vasile.pop@example.com', 'RO345678901234567890123', 5, 'Analiza', 'Matematica', 10, 20, 'PopVasile', 'parolaVasile'),
('2','4567890123888', 'Potolea', 'Rodica', 'Strada Gheorge Baritiu nr. 26', '0745678908', 'rodi.poto@example.com', 'RO456789012345678901255', 6, 'Alogoritmi Fundamentali', 'Calculoare', 15, 25, 'PotoleaRodica' ,'parolaRodica'),
('3','3456789012777', 'Oprisa', 'Ciprian', 'Strada Parang nr. 14', '0734567111', 'op.cipri@example.com', 'RO345678901234567440123', 7, 'Sisteme de operare', 'Calculatoare', 5, 30, 'OprisaCiprian', 'parolaCiprian'),
('4','3456789012345', 'Popa', 'Ana', 'Strada Mihai Viteazu nr. 15', '0734567890', 'ana.popa@example.com', 'RO345678901234567890123', 3, 'Matematica', 'Matematica', 10, 20, 'PopaAna', 'parolaAna'),
('5','4567890123456', 'Radu', 'Alexandru', 'Aleea Florilor nr. 8', '0745678901', 'alex.radu@example.com', 'RO456789012345678901234', 4, 'Fizica', 'Fizica', 15, 25, 'RaduAlexandru', 'parolaRadu');

INSERT INTO Administratori (ID_Administrator, CNP_Administrator, Nume_Administrator, Prenume_Administrator, Adresa_Administrator, Telefon_Administrator, Email_Administrator, ContIBAN_Administrator, NumarContract_Administrator, UserName, Parola)
VALUES
('1','9012345678901', 'Dragomir', 'Alina', 'Bulevardul Iancu de Hunedoara nr. 12', '0790123456', 'alina.dragomir@example.com', 'RO901234567890123456789', 9, 'DragomirAlina', 'parolaAlina'),
('2','8901234567890', 'Popescu', 'Ionel', 'Strada Libertatii nr. 5', '0789012345', 'ionel.popescu@example.com', 'RO890123456789012345678', 8, 'PopescuIonel', 'parolaIonel'),
('3','7890123456789', 'Ionescu', 'Ana', 'Calea Dorobantilor nr. 40', '0778901234', 'ana.ionescu@example.com', 'RO789012345678901234567', 7, 'IonescuAna', 'parolaAna'),
('4','5678901234567', 'Dumitrescu', 'Elena', 'Bulevardul Unirii nr. 30', '0756789012', 'elena.dumitrescu@example.com', 'RO567890123456789012345', 5, 'DumitrescuElena', 'parolaElena'),
('5','6789012345678', 'Constantin', 'Mihai', 'Strada Victoriei nr. 25', '0767890123', 'mihai.constantin@example.com', 'RO678901234567890123456', 6, 'ConstantinMihai', 'parolaMihai');


INSERT INTO SuperAdministratori (ID_SuperAdministratori, CNP_SuperAdministratori, Nume_SuperAdministratori, Prenume_SuperAdministratori, Adresa_SuperAdministratori, Telefon_SuperAdministratori, Email_SuperAdministratori, ContIBAN_SuperAdministratori, NumarContract_SuperAdministratori, UserName, Parola)
VALUES
('1', '1234567890123', 'Andronesi', 'Ana', 'Strada Victoriei nr. 10', '0765432109', 'ana.ionescu@example.com', 'RO123456789012345678901', 10, 'AndronesiAna', 'parolaAna'),
('2','2345678901234', 'Popovici', 'Radu', 'Aleea Mihai Eminescu nr. 15', '0789012345', 'radu.popovici@example.com', 'RO234567890123456789012', 11, 'PopoviciRadu', 'parolaRadu'),
('3', '3456789012345', 'Gheorghe', 'Elena', 'Bulevardul Unirii nr. 20', '0790123456', 'elena.gheorghe@example.com', 'RO345678901234567890123', 12, 'GheorgheElena','parolaElena'),
('4','7890123456789', 'Iacob', 'Andreea', 'Calea Dorobantilor nr. 40', '0778901234', 'andreea.iacob@example.com', 'RO789012345678901234567', 7, 'IacobAndreea', 'parolaAndreea'),
('5','8901234567890', 'Cristescu', 'Marius', 'Bulevardul Dacia nr. 12', '0789012345', 'marius.cristescu@example.com', 'RO890123456789012345678', 8, 'CristescuMarius', 'parolaMarius');

INSERT INTO Cursuri (ID_Curs, ID_Profesor, Nume, Descriere, MaxStudenti)
VALUES
(1, '3', 'Sisteme de operare', 'Curs de sisteme de operare', 30),
(2, '2', 'Alogoritmi Fundamentali', 'Curs introductiv in alogoritmi', 25),
(3, '1', 'Analiza', 'Curs de analiza numerica', 25),
(4, '4', 'Matematica', 'Curs de matematica avansata', 30),
(5, '5', 'Fizica', 'Curs de fizica cuantica', 25);

INSERT INTO ProgramareActivitati (ID_Activitate, ID_Curs, TipActivitate, DataInceput, DataSfarsit, MaxParticipanti)
VALUES
(1, 1, 'Curs', '2024-01-10 09:00:00', '2024-01-10 11:00:00', 25),
(2, 2, 'Seminar', '2024-01-12 14:00:00', '2024-01-12 16:00:00', 20),
(5, 5, 'Proiect', '2024-01-18 11:00:00', '2024-01-18 13:00:00', 25),
(4, 4, 'Curs', '2024-01-18 11:00:00', '2024-01-18 13:00:00', 25),
(3, 3, 'Laborator', '2024-01-15 14:00:00', '2024-01-15 16:00:00', 18);

INSERT INTO InscrieriStudenti_Activitate (ID_Inscriere, ID_Activitate, ID_Student)
VALUES
(5, 1, '1'),
(6, 2, '2'),
(7, 1, '3'),
(1, 1, '4'),
(2, 2, '5');

INSERT INTO InscrieriStudenti_Curs (ID_Inscriere, ID_Curs, ID_Student)
VALUES
(7, 5, '5'),
(5, 3, '4'),
(6, 4, '3'),
(1, 1, '2'),
(2, 2, '1');

INSERT INTO Note (ID_Nota, ID_Activitate, ID_Student, Nota)
VALUES
(6, 4, '2', 8),
(7, 5, '3', 7),
(5, 3, '4', 9),
(1, 1, '5', 9),
(2, 2, '1', 8);



INSERT INTO GrupuriStudiu (ID_Grup, Nume, ID_Curs)
VALUES
(5, 'Grupa 5', 1),
(6, 'Grupa 6', 2),
(7, 'Grupa 7', 3),
(1, 'Grupa 1', 1),
(2, 'Grupa 2', 2);

INSERT INTO Activitati_Grup(ID_Activitate, Data_activitate, Durata_activitate, Confirmare_activitate, NrInscrisi, MinParticipanti)
VALUES
(1, '2024-02-10 16:00:00', 2, '2024-02-10 16:30:00', 15, 10),
(2, '2024-02-15 09:00:00', 1, '2024-02-15 09:15:00', 22, 12),
(7, '2024-02-20 14:00:00', 3, '2024-02-20 14:45:00', 10, 8),
(6, '2024-01-15 10:00:00', 2, '2024-01-15 10:30:00', 20, 10),
(5, '2024-01-20 15:00:00', 1, '2024-01-20 15:15:00', 15, 8);


INSERT INTO MembriGrup (ID_Membru, ID_Grup, ID_Student)
VALUES
(5, 5, '1'),
(6, 6, '2'),
(7, 7, '3'),
(1, 1, '4'),
(2, 2, '5');


INSERT INTO MesajeGrup (ID_Mesaj, ID_Grup, ID_Student, Mesaj)
VALUES
(5, 5, '5', 'Salut! Cand putem stabili urmatoarea intalnire?'),
(6, 6, '4', 'Buna! Astept cu nerabdare sedinta.'),
(7, 7, '3', 'Salutare tuturor! Avem teme pentru saptamana asta?'),
(1, 1, '2', 'Salutare! Asteptam cu nerabdare prima sedinta.'),
(2, 2, '1', 'Buna tuturor! Vom avea sedinta saptamana viitoare.');
