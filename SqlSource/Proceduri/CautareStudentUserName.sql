use platformaStudiu;

DELIMITER //
CREATE PROCEDURE CautaStudentul(IN userName VARCHAR(30))
BEGIN
    SELECT *
    FROM Studenti
    WHERE Studenti.UserName = userName;
END//
DELIMITER ;