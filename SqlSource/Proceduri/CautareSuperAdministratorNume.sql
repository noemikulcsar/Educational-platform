use platformaStudiu;

DELIMITER //
CREATE PROCEDURE CautaSuperadministratorDupaNume(IN nume_superadministrator VARCHAR(50))
BEGIN
    SELECT *
    FROM SuperAdministratori
    WHERE Nume_SuperAdministratori = nume_superadministrator;

END//
DELIMITER ;