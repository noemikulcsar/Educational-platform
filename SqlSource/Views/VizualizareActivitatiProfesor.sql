use platformaStudiu;
DELIMITER //

CREATE PROCEDURE VizualizareActivitatiProfesor(IN ProfesorID INT)
BEGIN
    SELECT ProgramareActivitati.*, Cursuri.Nume AS NumeCurs
    FROM ProgramareActivitati
    JOIN Cursuri ON ProgramareActivitati.ID_Curs = Cursuri.ID_Curs
    WHERE Cursuri.ID_Profesor = ProfesorID;
END //

DELIMITER ;
