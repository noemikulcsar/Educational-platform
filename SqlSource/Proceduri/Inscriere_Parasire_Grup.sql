use platformaStudiu;

DELIMITER //

CREATE PROCEDURE InscriereGrupStudent(
    IN NumeGrup VARCHAR(100),
    IN StudentCNP VARCHAR(20)
)
BEGIN
    DECLARE GrupID INT;
    DECLARE StudentID INT;

    -- Obține ID-ul grupului
    SELECT ID_Grup INTO GrupID
    FROM GrupuriStudiu
    WHERE Nume = NumeGrup;

    -- Obține ID-ul studentului
    SELECT ID_Student INTO StudentID
    FROM Studenti
    WHERE CNP_Student = StudentCNP;

    -- Verifică dacă grupul există și studentul există
    IF GrupID IS NOT NULL AND StudentID IS NOT NULL THEN
        -- Inserează în tabela MembriGrup
        INSERT INTO MembriGrup (ID_Grup, ID_Student)
        VALUES (GrupID, StudentID);

        SELECT CONCAT('Studentul cu CNP-ul ', StudentCNP, ' s-a inscris in grupul ', NumeGrup) AS Mesaj;
    ELSE
        SELECT 'Grupul sau studentul nu există.' AS Mesaj;
    END IF;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE ParasireGrupStudent(
    IN NumeGrup VARCHAR(100),
    IN StudentCNP VARCHAR(20)
)
BEGIN
    DECLARE GrupID INT;
    DECLARE StudentID INT;

    -- Obține ID-ul grupului
    SELECT ID_Grup INTO GrupID
    FROM GrupuriStudiu
    WHERE Nume = NumeGrup;

    -- Obține ID-ul studentului
    SELECT ID_Student INTO StudentID
    FROM Studenti
    WHERE CNP_Student = StudentCNP;

    -- Verifică dacă grupul există și studentul există
    IF GrupID IS NOT NULL AND StudentID IS NOT NULL THEN
        -- Șterge înregistrarea din tabela MembriGrup
        DELETE FROM MembriGrup
        WHERE ID_Grup = GrupID AND ID_Student = StudentID;

        SELECT CONCAT('Studentul cu CNP-ul ', StudentCNP, ' a parasit grupul ', NumeGrup) AS Mesaj;
    ELSE
        SELECT 'Grupul sau studentul nu există.' AS Mesaj;
    END IF;
END //

DELIMITER ;
