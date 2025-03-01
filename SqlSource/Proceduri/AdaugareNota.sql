use platformaStudiu;
DELIMITER //

CREATE PROCEDURE AdaugaNota(
    IN p_ID_Activitate INT,
    IN p_ID_Student INT,
    IN p_Nota INT
)
BEGIN
    INSERT INTO Note (ID_Activitate, ID_Student, Nota)
    VALUES (p_ID_Activitate, p_ID_Student, p_Nota);
END //

DELIMITER ;
