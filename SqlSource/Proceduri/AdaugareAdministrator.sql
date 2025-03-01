use platformaStudiu;
DELIMITER //

CREATE PROCEDURE AdaugaAdministrator(
    IN p_CNP_Administrator VARCHAR(20),
    IN p_Nume_Administrator VARCHAR(50),
    IN p_Prenume_Administrator VARCHAR(50),
    IN p_Adresa_Administrator VARCHAR(100),
    IN p_Telefon_Administrator VARCHAR(15),
    IN p_Email_Administrator VARCHAR(50),
    IN p_ContIBAN_Administrator VARCHAR(30),
    IN p_NumarContract_Administrator INT,
    IN p_UserName VARCHAR(30),
    IN p_Parola VARCHAR(255)
)
BEGIN
    INSERT INTO Administratori (
        CNP_Administrator,
        Nume_Administrator,
        Prenume_Administrator,
        Adresa_Administrator,
        Telefon_Administrator,
        Email_Administrator,
        ContIBAN_Administrator,
        NumarContract_Administrator,
        UserName,
        Parola
    )
    VALUES (
        p_CNP_Administrator,
        p_Nume_Administrator,
        p_Prenume_Administrator,
        p_Adresa_Administrator,
        p_Telefon_Administrator,
        p_Email_Administrator,
        p_ContIBAN_Administrator,
        p_NumarContract_Administrator,
        p_UserName,
        p_Parola
    );
END //

DELIMITER ;
