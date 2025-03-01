use platformaStudiu;

# Adăugare Curs
DELIMITER //

CREATE PROCEDURE AdaugareCurs(
    IN ProfesorCNP VARCHAR(20),
    IN NumeCurs VARCHAR(100),
    IN DescriereCurs TEXT,
    IN MaxStudenti INT
)
BEGIN
    DECLARE ProfID INT;

    -- Obține ID-ul profesorului
    SELECT ID_Profesor INTO ProfID
    FROM Profesori
    WHERE CNP_Profesor = ProfesorCNP;

    -- Verifică dacă profesorul există
    IF ProfID IS NOT NULL THEN
        -- Adaugă cursul
        INSERT INTO Cursuri (ID_Profesor, Nume, Descriere, MaxStudenti)
        VALUES (ProfID, NumeCurs, DescriereCurs, MaxStudenti);

        SELECT 'Cursul a fost adăugat cu succes.' AS Mesaj;
    ELSE
        SELECT 'Profesorul nu există.' AS Mesaj;
    END IF;
END //

DELIMITER ;

# Actualizare Curs:
DELIMITER //

CREATE PROCEDURE ActualizareCurs(
    IN CursID INT,
    IN ProfesorCNP VARCHAR(20),
    IN NumeCurs VARCHAR(100),
    IN DescriereCurs TEXT,
    IN MaxStudenti INT
)
BEGIN
    DECLARE ProfID INT;

    -- Obține ID-ul profesorului
    SELECT ID_Profesor INTO ProfID
    FROM Profesori
    WHERE CNP_Profesor = ProfesorCNP;

    -- Verifică dacă profesorul există
    IF ProfID IS NOT NULL THEN
        -- Actualizează cursul
        UPDATE Cursuri
        SET ID_Profesor = ProfID, Nume = NumeCurs, Descriere = DescriereCurs, MaxStudenti = MaxStudenti
        WHERE ID_Curs = CursID;

        SELECT 'Cursul a fost actualizat cu succes.' AS Mesaj;
    ELSE
        SELECT 'Profesorul nu există.' AS Mesaj;
    END IF;
END //

DELIMITER ;

#Ștergere Curs:
DELIMITER //

CREATE PROCEDURE StergereCurs(
    IN CursID INT
)
BEGIN
    -- Șterge cursul
    DELETE FROM Cursuri WHERE ID_Curs = CursID;

    SELECT 'Cursul a fost șters cu succes.' AS Mesaj;
END //

DELIMITER ;


#Vizualizare Curs:
DELIMITER //

CREATE PROCEDURE VizualizareCurs(
    IN CursID INT
)
BEGIN
    -- Afișează informațiile despre curs
    SELECT * FROM Cursuri WHERE ID_Curs = CursID;
END //

DELIMITER ;
