use platformaStudiu;

DELIMITER //
CREATE PROCEDURE CautaSuperAdministratoriDupaUserName(IN userName VARCHAR(30))
BEGIN
    SELECT *
    FROM SuperAdministratori
    WHERE SuperAdministratori.UserName = userName;

END//
DELIMITER ;