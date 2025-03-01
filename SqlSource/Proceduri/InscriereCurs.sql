use platformaStudiu;
DELIMITER //

CREATE PROCEDURE InregistrareCursStudent(IN CNPStudent VARCHAR(20), IN NumeCurs VARCHAR(100))
BEGIN
    DECLARE StudentID INT;
    DECLARE CursID INT;

    -- Obține ID-ul studentului
    SELECT ID_Student INTO StudentID
    FROM Studenti
    WHERE CNP_Student = CNPStudent;

    -- Obține ID-ul cursului
    SELECT ID_Curs INTO CursID
    FROM Cursuri
    WHERE Nume = NumeCurs;

    -- Verifică dacă studentul și cursul există
    IF StudentID IS NOT NULL AND CursID IS NOT NULL THEN
        -- Inserează în tabela de înregistrări pentru curs
        INSERT INTO InscrieriStudenti_Curs (ID_Curs, ID_Student)
        VALUES (CursID, StudentID);

        SELECT CONCAT('Studentul cu CNP ', CNPStudent, ' a fost înscris cu succes la cursul ', NumeCurs) AS Mesaj;
    ELSE
        SELECT 'Studentul sau cursul nu există.' AS Mesaj;
    END IF;
END //

DELIMITER ;

