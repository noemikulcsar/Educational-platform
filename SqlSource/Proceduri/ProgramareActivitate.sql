use platformaStudiu;
DELIMITER //

CREATE PROCEDURE ProgramareActivitate(
    IN NumeCurs VARCHAR(100),
    IN TipActivitate VARCHAR(20),
    IN DataInceput DATETIME,
    IN DataSfarsit DATETIME,
    IN MaxParticipanti INT
)
BEGIN
    DECLARE CursID INT;

    -- Obține ID-ul cursului
    SELECT ID_Curs INTO CursID
    FROM Cursuri
    WHERE Nume = NumeCurs;

    -- Verifică dacă cursul există
    IF CursID IS NOT NULL THEN
        -- Inserează în tabela ProgramareActivitati
        INSERT INTO ProgramareActivitati (ID_Curs, TipActivitate, DataInceput, DataSfarsit, MaxParticipanti)
        VALUES (CursID, TipActivitate, DataInceput, DataSfarsit, MaxParticipanti);

        SELECT CONCAT('Activitatea pentru cursul ', NumeCurs, ' a fost programată cu succes.') AS Mesaj;
    ELSE
        SELECT 'Cursul nu există.' AS Mesaj;
    END IF;
END //

DELIMITER ;
