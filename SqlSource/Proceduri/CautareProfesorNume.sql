use platformaStudiu;

DELIMITER //
CREATE PROCEDURE CautaProfesorDupaUserName(IN userName VARCHAR(30))
BEGIN
    SELECT *
    FROM Profesori
    WHERE Profesori.UserName = userName;

END//
DELIMITER ;