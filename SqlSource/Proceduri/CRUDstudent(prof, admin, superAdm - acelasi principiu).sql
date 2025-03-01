use platformaStudiu;

-- CRUD STUDENTI
-- CREATE (Adăugare Student):

INSERT INTO Studenti (CNP_Student, Nume_Student, Prenume_Student, Adresa_Student, Telefon_Student, Email_Student, ContIBAN_Student, NumarContract_Student, AnStudiu, OreSustinute_Student, UserName, Parola)
VALUES ('1234567890100', 'Ureche', 'Simona', 'Strada Garii nr. 1082', '0764224194', 'simona.ureche@yahoo.com', 'RO123456789012345678901', 2, 2024, 15, 'simonaureche', 'parola123');

-- READ (Vizualizare Student după ID):
SELECT * FROM Studenti WHERE ID_Student = 1;

-- UPDATE (Actualizare Detalii Student):
UPDATE Studenti SET Telefon_Student = '0765001122' WHERE ID_Student = 1;

-- DELETE (Ștergere Student după ID):
DELETE FROM Studenti WHERE ID_Student = 1;
