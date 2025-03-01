use platformaStudiu;

DELIMITER //

CREATE PROCEDURE VizualizareStudenti()
BEGIN
    SELECT * FROM Studenti;
END //

DELIMITER ;
