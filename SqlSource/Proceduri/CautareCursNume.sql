use platformaStudiu;

DELIMITER //
CREATE PROCEDURE CautaCursDupaNume(IN nume_curs VARCHAR(100))
BEGIN
    SELECT *
    FROM Cursuri
    WHERE Nume = nume_curs;
END //

DELIMITER ;