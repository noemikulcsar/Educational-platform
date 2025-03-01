USE PlatformaStudiu;
DELIMITER //

CREATE PROCEDURE SetPonderiActivitate(
    IN idCurs INT,
    IN procentCurs INT,
    IN procentSeminar INT,
    IN procentLaborator INT
)
BEGIN
    DECLARE totalProcente INT;
    
    SET totalProcente = procentCurs + procentSeminar + procentLaborator;
    
    IF totalProcente = 100 THEN
        INSERT INTO ProcenteCursuri (ID_Curs, ProcentCurs, ProcentSeminar, ProcentLaborator)
        VALUES (idCurs, procentCurs, procentSeminar, procentLaborator)
        ON DUPLICATE KEY UPDATE 
            ProcentCurs = procentCurs, 
            ProcentSeminar = procentSeminar, 
            ProcentLaborator = procentLaborator;
    END IF;
END //

DELIMITER ;
