use platformaStudiu;
DELIMITER //

CREATE PROCEDURE AdaugareActivitatiGrup(
    IN grup_id INT,
    IN data_activitate DATETIME,
    IN durata_activitate INT,
    IN confirmare_activitate DATETIME,
    IN nr_inscrisi INT,
    IN min_participanti INT
)
BEGIN
    -- Verifică dacă grup_id există în tabela GrupuriStudiu
    DECLARE grup_count INT;
    SELECT COUNT(*) INTO grup_count FROM GrupuriStudiu WHERE ID_Grup = grup_id;

    IF grup_count > 0 THEN
        -- Adaugă activitatea de grup
        INSERT INTO Activitati_Grup (ID_Activitate, Data_activitate, Durata_activitate, Confirmare_activitate, NrInscrisi, MinParticipanti)
        VALUES (grup_id, data_activitate, durata_activitate, confirmare_activitate, nr_inscrisi, min_participanti);

        SELECT 'Activitate de grup adăugată cu succes!' AS Result;
    ELSE
        SELECT 'ID-ul grupului nu există!' AS Result;
    END IF;
END //

DELIMITER ;

