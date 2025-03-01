use platformaStudiu;
DELIMITER //

CREATE PROCEDURE AdaugaProfesor(
    IN p_CNP_Profesor VARCHAR(20),
    IN p_Nume_Profesor VARCHAR(50),
    IN p_Prenume_Profesor VARCHAR(50),
    IN p_Adresa_Profesor VARCHAR(100),
    IN p_Telefon_Profesor VARCHAR(15),
    IN p_Email_Profesor VARCHAR(50),
    IN p_ContIBAN_Profesor VARCHAR(30),
    IN p_NumarContract_Profesor INT,
    IN p_CursuriPredate VARCHAR(30),
    IN p_Departament VARCHAR(50),
    IN p_MinOre INT,
    IN p_MaxOre INT,
    IN p_UserName VARCHAR(30),
    IN p_Parola VARCHAR(255)
)
BEGIN
    INSERT INTO Profesori (
        CNP_Profesor,
        Nume_Profesor,
        Prenume_Profesor,
        Adresa_Profesor,
        Telefon_Profesor,
        Email_Profesor,
        ContIBAN_Profesor,
        NumarContract_Profesor,
        CursuriPredate,
        Departament,
        MinOre,
        MaxOre,
        UserName,
        Parola
    )
    VALUES (
        p_CNP_Profesor,
        p_Nume_Profesor,
        p_Prenume_Profesor,
        p_Adresa_Profesor,
        p_Telefon_Profesor,
        p_Email_Profesor,
        p_ContIBAN_Profesor,
        p_NumarContract_Profesor,
        p_CursuriPredate,
        p_Departament,
        p_MinOre,
        p_MaxOre,
        p_UserName,
        p_Parola
    );
END //

DELIMITER ;
