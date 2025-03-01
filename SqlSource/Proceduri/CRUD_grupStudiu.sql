use platformaStudiu;

#Adăugare Grup de Studiu:
DELIMITER //

CREATE PROCEDURE AdaugareGrupStudiu(
    IN NumeGrup VARCHAR(100),
    IN CursID INT
)
BEGIN
    -- Adaugă grupul de studiu
    INSERT INTO GrupuriStudiu (Nume, ID_Curs)
    VALUES (NumeGrup, CursID);

    SELECT 'Grupul de studiu a fost adăugat cu succes.' AS Mesaj;
END //

DELIMITER ;

 #Actualizare Grup de Studiu:
 DELIMITER //

CREATE PROCEDURE ActualizareGrupStudiu(
    IN GrupID INT,
    IN NumeGrup VARCHAR(100),
    IN CursID INT
)
BEGIN
    -- Actualizează grupul de studiu
    UPDATE GrupuriStudiu
    SET Nume = NumeGrup, ID_Curs = CursID
    WHERE ID_Grup = GrupID;

    SELECT 'Grupul de studiu a fost actualizat cu succes.' AS Mesaj;
END //

DELIMITER ;

#Ștergere Grup de Studiu:
DELIMITER //

CREATE PROCEDURE StergereGrupStudiu(
    IN GrupID INT
)
BEGIN
    -- Șterge grupul de studiu
    DELETE FROM GrupuriStudiu WHERE ID_Grup = GrupID;

    SELECT 'Grupul de studiu a fost șters cu succes.' AS Mesaj;
END //

DELIMITER ;

#Vizualizare Grup de Studiu:
DELIMITER //

CREATE PROCEDURE VizualizareGrupStudiu(
    IN GrupID INT
)
BEGIN
    -- Afișează informațiile despre grupul de studiu
    SELECT * FROM GrupuriStudiu WHERE ID_Grup = GrupID;
END //

DELIMITER ;
