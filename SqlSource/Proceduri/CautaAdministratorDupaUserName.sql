use platformaStudiu;

DELIMITER //
CREATE PROCEDURE CautaAdministratorDupaUserName(IN userName VARCHAR(30))
BEGIN
    SELECT *
    FROM Administratori
    WHERE Administratori.UserName = userName;

END//
DELIMITER ;