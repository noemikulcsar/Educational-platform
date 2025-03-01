use platformaStudiu;
DELIMITER //

CREATE PROCEDURE VizualizareDescarcareActivitati()
BEGIN
    DECLARE today DATE;
    SET today = CURDATE();

    -- Vizualizare activități curente și viitoare
    SELECT * FROM ProgramareActivitati
    WHERE DataInceput >= today;

    -- Descărcare activități curente și viitoare într-un fișier CSV
    SELECT * FROM ProgramareActivitati
    WHERE DataInceput >= today
    INTO OUTFILE '/path/to/activitati.csv'
    FIELDS TERMINATED BY ','
    ENCLOSED BY '"'
    LINES TERMINATED BY '\n';
END //

DELIMITER ;
