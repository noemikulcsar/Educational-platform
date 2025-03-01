use platformaStudiu;
DELIMITER //

CREATE PROCEDURE AdaugareActivitate(
    IN curs_id INT,
    IN tip_activitate VARCHAR(20),
    IN data_inceput DATETIME,
    IN data_sfarsit DATETIME,
    IN max_participanti INT
)
BEGIN
    -- Verifică dacă curs_id există în tabela Cursuri
    DECLARE curs_count INT;
    SELECT COUNT(*) INTO curs_count FROM Cursuri WHERE ID_Curs = curs_id;

    IF curs_count > 0 THEN
        -- Adaugă activitatea
        INSERT INTO ProgramareActivitati (ID_Curs, TipActivitate, DataInceput, DataSfarsit, MaxParticipanti)
        VALUES (curs_id, tip_activitate, data_inceput, data_sfarsit, max_participanti);

        SELECT 'Activitate adăugată cu succes!' AS Result;
    ELSE
        SELECT 'ID-ul cursului nu există!' AS Result;
    END IF;
END //

DELIMITER ;
