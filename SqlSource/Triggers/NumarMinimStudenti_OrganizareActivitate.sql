#activat atunci când este inserată o nouă activitate în tabela 
USE PlatformaStudiu;
DELIMITER //

CREATE TRIGGER SetMinParticipanti
AFTER INSERT ON ProgramareActivitati
FOR EACH ROW
BEGIN
    DECLARE nrInscrisi INT;

    -- Obține numărul de participanți actual
    SELECT NrInscrisi INTO nrInscrisi
    FROM Activitati_Grup
    WHERE ID_Activitate = NEW.ID_Activitate;

    -- Actualizează numărul minim de participanți
    UPDATE ProgramareActivitati
    SET MinParticipanti = nrInscrisi
    WHERE ID_Activitate = NEW.ID_Activitate;
END //

DELIMITER ;
