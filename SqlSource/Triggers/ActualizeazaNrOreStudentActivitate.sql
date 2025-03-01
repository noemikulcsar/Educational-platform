
USE PlatformaStudiu;
DELIMITER //

CREATE TRIGGER ActualizareOreStudent
AFTER INSERT ON Note
FOR EACH ROW
BEGIN
    DECLARE oreActivitate INT;
    
    -- Află numărul de ore asociate activității în funcție de nota obținută
    SELECT CASE
        WHEN NEW.Nota >= 5 THEN 2
        WHEN NEW.Nota >= 8 THEN 4
        ELSE 0
    END INTO oreActivitate;
    
    -- Actualizează numărul total de ore ale studentului
    UPDATE Studenti
    SET OreSustinute_Student = OreSustinute_Student + oreActivitate
    WHERE ID_Student = NEW.ID_Student;
END //

DELIMITER ;
