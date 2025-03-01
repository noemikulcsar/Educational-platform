use platformaStudiu;

DELIMITER //
CREATE PROCEDURE CautaAdministratorDupaNume(IN nume_administrator VARCHAR(50))
BEGIN
    SELECT *
    FROM Administratori
    WHERE Nume_Administrator = nume_administrator;

END//
DELIMITER ;