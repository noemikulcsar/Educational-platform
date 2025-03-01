use platformaStudiu;
DELIMITER //

CREATE PROCEDURE VizualizareMesaje()
BEGIN
    SELECT * FROM MesajeGrup;
END //

DELIMITER ;
