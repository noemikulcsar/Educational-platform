use platformaStudiu;

DELIMITER //
CREATE PROCEDURE CautaStudentulDupaNume(IN nume_student VARCHAR(30))
BEGIN
    SELECT *
    FROM Studenti
    WHERE Studenti.UserName = nume_student;
END//
DELIMITER ;